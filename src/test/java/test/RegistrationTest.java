package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import aquality.selenium.browser.AqualityServices;
import config.EnvironmentConfig;
import config.TestDataConfig;
import forms.GamePage;
import utils.RandomUtils;

public class RegistrationTest extends BaseTest {
	private static final int COMMON_STRING_LENGTH = 10;
    private static final int DEFAULT_INTEREST = 3;
    private GamePage gamePage;
    

    @Test
    public void verifyRegistration() {
    	String url = EnvironmentConfig.getUrl();
        String email = RandomUtils.generateRandomString(COMMON_STRING_LENGTH);
        String randomPassword = RandomUtils.generateRandomPassword(email, COMMON_STRING_LENGTH);
        String randomDomain = RandomUtils.generateRandomString(COMMON_STRING_LENGTH);
        String imagePath = TestDataConfig.getPath();

        AqualityServices.getBrowser().goTo(url);
    	AqualityServices.getBrowser().waitForPageToLoad();

        //Test Case 1
        //Page 1
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "HomePage is not Opened");
        gamePage.clickLinkHere();

        //Page 2 card1
        Assert.assertTrue(gamePage.getRegistrationForm().state().isDisplayed(), "Registration card 1 is not displayed");
        gamePage.getRegistrationForm().writePassword(randomPassword);
        gamePage.getRegistrationForm().writeUserName(email);
        gamePage.getRegistrationForm().writeDomains(randomDomain);
        gamePage.getRegistrationForm().selectRandomOptionFromDropdown();
        gamePage.getRegistrationForm().unTickTermsAndConditions();
        gamePage.getRegistrationForm().clickNextPage();

        //Page 3 card2
        Assert.assertTrue(gamePage.getInterestsForm().state().isDisplayed(), "Registration card 2 is not displayed");
        gamePage.getInterestsForm().clickUnselectAllCheckbox();
        gamePage.getInterestsForm().chooseInterests(DEFAULT_INTEREST);
        gamePage.getInterestsForm().uploadImage(imagePath);
        gamePage.getInterestsForm().clickNextButton();

        //page 4 card3
        Assert.assertTrue(gamePage.getPersonalDetailsForm().state().isDisplayed(), "Registration card 3 is not displayed");
    }
}
