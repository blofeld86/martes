package page.object;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import test.helpers.WebElementHandler;

@Slf4j
public class BasePage extends WebElementHandler {

    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected Logger logger(){return log;}
    protected Select select;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        jse = ((JavascriptExecutor)driver);
        PageFactory.initElements(driver,this);
    }

    public void highlightMethod(WebElement element){
        jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 5px solid blue')",element);
    }

    public void clickElement(WebElement element){
        log.info("Click perform on the object: "+element.getText());
        highlightMethod(element);
        element.click();
    }

    public void scrollToElement(WebElement element){
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void switchToFrameByIndex(int x){
        driver.switchTo().frame(x);
    }

    public void switchToFrameByElement(WebElement element){
        driver.switchTo().frame(element);
    }
}
