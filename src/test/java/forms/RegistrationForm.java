package forms;

import java.util.List;

import org.openqa.selenium.By;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import utils.RandomUtils;

public class RegistrationForm extends Form {
    private static final By DROPDOWN_OPTION_LOCATOR = By.cssSelector(".dropdown__list-item");
    private final ITextBox passwordCheckBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Choose Password')]"), "PasswordTextBox");
    private final ITextBox yourEmailCheckBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Your email')]"), "EmailTextBox");
    private final ITextBox domainsCheckBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"), "DomainTextBox");
    private final IComboBox domainSelectorDropdown = getElementFactory().getComboBox(By.xpath("//div[contains(@class, 'dropdown dropdown--gray')]"), "DomainSelectorDropdown");
    private final ICheckBox doNotAcceptTermsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class, 'icon icon-check checkbox__check')]"), "TickButton");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'button--secondary')and not(contains(@class, 'u-right'))]"), "NextButton");
    private final ILabel timerLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'timer timer--white timer--center')]"), "TimerStartingLocator");

    public RegistrationForm() {
        super(By.xpath("//div[@class='login-form__container']"), "RegistrationForm");
    }

    //Writing Random userName     
    public void writeUserName(String input) {
        yourEmailCheckBox.clearAndType(input);
    }

    //Sending Random Password
    public void writePassword(String input) {
        passwordCheckBox.clearAndType(input);
    }

    //Sending Domains name
    public void writeDomains(String input) {
        domainsCheckBox.clearAndType(input);
    }

    //click on Domain extension and select random option
    public void selectRandomOptionFromDropdown() { //Select random Domain
        domainSelectorDropdown.click();

        List<IButton> dropdownOptions = getElementFactory().findElements(DROPDOWN_OPTION_LOCATOR, IButton.class);
        int randomIndex = RandomUtils.generateRandomNumber(dropdownOptions.size());
        dropdownOptions.get(randomIndex).click();
    }

    //select the tick
    public void unTickTermsAndConditions() {
        doNotAcceptTermsCheckBox.click();
    }

    //Next Page
    public void clickNextPage() {
        nextButton.click();
    }

    public String getTimerValue() {
        return timerLabel.getText();
    }
}
