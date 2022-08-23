import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;

public class TestOne extends BaseTest{


    @Test
    public void testOne() throws InterruptedException {
        landingPage
                   .acceptCookies()
                   .clickSearch(getProperty("input"))
                   .openRightBicycle();

        Thread.sleep(4000);
    }
}
