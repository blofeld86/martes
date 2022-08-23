import configuration.DriverFactory;
import configuration.YamlReader;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page.object.LandingPage;

import static java.lang.System.getProperty;

@Slf4j
public class BaseTest {

    protected DriverFactory driverFactory = new DriverFactory();
    protected LandingPage landingPage;
    protected WebDriver driver;

    @Step("Loading the properties")
    @BeforeClass
    public void beforeClass() {
        YamlReader.setPropertiesFromYAML();
    }

    @Step("Setting up the configuration")
    @BeforeMethod
    public void setUp() {
        driver = driverFactory.getDriver(driverFactory.getBrowserFromYAML());
        log.info("Driver initiated properly");
        driver.get(getProperty("appUrl"));
        landingPage = new LandingPage(driver);
    }

    @Step("Closing the project")
    @AfterMethod
    public void tearDown(){
        driver.quit();
        log.info("Driver closed properly");
    }
}
