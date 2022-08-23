package page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage{

    @FindBy(xpath = ".//a[contains(text(),'R22Huraganszcz')]")
    private WebElement romet;

    public ResultPage(WebDriver driver) { super(driver);}

    public ResultPage openRightBicycle(){
        getWait().until(ExpectedConditions.elementToBeClickable(romet));
        scrollToElement(romet);
        clickElement(romet);
        return this;
    }

}
