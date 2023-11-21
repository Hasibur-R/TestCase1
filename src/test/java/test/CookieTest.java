package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import aquality.selenium.browser.AqualityServices;
import config.EnvironmentConfig;
import forms.GamePage;

public class CookieTest extends BaseTest {
    private GamePage gamePage;

    @Test
    public void verifyCookieTest() {
        AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
        AqualityServices.getBrowser().waitForPageToLoad();


        // Test Case 3
        // Page 1
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "HomePage is not Opened");
        gamePage.clickLinkHere();
        Assert.assertTrue(gamePage.getRegistrationForm().state().isDisplayed(), "Registration card 1 is not displayed");

        // Page 2 card 1
        gamePage.clickCookieYesButton();
        Assert.assertFalse(gamePage.isCookieFormHidden(), "Cookie did not accepted");
    }
}
