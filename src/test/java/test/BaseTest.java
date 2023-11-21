package test;

import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {
    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
