package forms;

import org.openqa.selenium.By;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;


public class GamePage extends Form {
    private final ILink linkHere = getElementFactory().getLink(By.xpath("//a[contains(@href, '/game.html') and contains(@class, 'start__link')]"), "HereLink");
    private final IButton hideHelpFormButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button button--solid button--blue help-form__send-to-bottom-button')]"), "HideHelp");
    private final ILabel afterHideFromLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class,'help-form is-hidden')]"), "check");
    private final IButton hideCookieButton = getElementFactory().getButton(By.xpath("//button[contains(@name, 'button') and contains(@class, 'button button--solid button--transparent')]"), "CookieYesSelected");
    private final ILabel cookieLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class,'cookies')]"), "CookieLabel");
    private final RegistrationForm registrationForm;
    private final InterestsForm interestsForm;
    private final PersonalDetailsForm personalDetailsForm;


    public GamePage() {
        super(By.xpath("//button[contains(@class, 'start__button') and contains(@type,'button')]"), "WelcomePage");
        registrationForm = new RegistrationForm();
        interestsForm = new InterestsForm();
        personalDetailsForm = new PersonalDetailsForm();
    }

    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    public InterestsForm getInterestsForm() {
        return interestsForm;
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return personalDetailsForm;
    }

    //Here button
    public void clickLinkHere() {
        linkHere.click();
    }

    //Send to bottom button
    public void clickHideHelp() {
        hideHelpFormButton.state().waitForClickable();
        hideHelpFormButton.click();
    }

    public boolean isFormHidden() {
        return afterHideFromLabel.state().isDisplayed();
    }

    public boolean isCookieFormHidden() {
        return cookieLabel.state().isDisplayed();
    }

    //No, really no button
    public void clickCookieYesButton() {
        hideCookieButton.clickAndWait();
    }
}
