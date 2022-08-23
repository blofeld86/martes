package page.object;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    @FindBy(css = "button.primary")
    private WebElement cookies;

    @FindBy(css = "[type=search]")
    private WebElement inputSearch;
    public LandingPage(WebDriver driver) { super(driver);}


    public LandingPage acceptCookies(){
        getWait().until(ExpectedConditions.elementToBeClickable(cookies));
        clickElement(cookies);
//        getWait().until(ExpectedConditions.stalenessOf(cookies));
        return this;
    }

    public ResultPage clickSearch(String value){
        scrollToElement(inputSearch);
        inputSearch.sendKeys(value, Keys.ENTER);
        return new ResultPage(driver);
    }


}
