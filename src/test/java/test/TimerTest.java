package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import aquality.selenium.browser.AqualityServices;
import config.EnvironmentConfig;
import forms.GamePage;

public class TimerTest extends BaseTest {
	private static final String INITIAL_TIMER_VALUE = "00:00:00";
    private GamePage gamePage;

    @Test
    public void verifyTimerStartValue() {
    	AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
    	AqualityServices.getBrowser().waitForPageToLoad();

        //Test Case 3 - Home page loaded
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "HomePage is not Opened");
        gamePage.clickLinkHere();

        String initialTimerValue = gamePage.getRegistrationForm().getTimerValue();
        Assert.assertEquals(initialTimerValue, INITIAL_TIMER_VALUE, String.format("Timer did not start from %s", INITIAL_TIMER_VALUE));
    }
}
