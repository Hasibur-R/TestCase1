package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import aquality.selenium.browser.AqualityServices;
import config.EnvironmentConfig;
import forms.GamePage;

public class HideContentTest extends BaseTest {
    private GamePage gamePage;

    @Test
    public void verifyHideTest() {
    	AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
    	AqualityServices.getBrowser().waitForPageToLoad();

        // Test Case 2
        // Page 1
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "HomePage is not Opened");
        gamePage.clickLinkHere();
        Assert.assertTrue(gamePage.getRegistrationForm().state().waitForDisplayed(), "Registration card 1 is not displayed");

        gamePage.clickHideHelp();
        Assert.assertTrue(gamePage.isFormHidden(), "The From is not Hidden");
    }
}
