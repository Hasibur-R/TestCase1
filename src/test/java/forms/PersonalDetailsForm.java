package forms;

import org.openqa.selenium.By;

import aquality.selenium.forms.Form;

public class PersonalDetailsForm extends Form {
    public PersonalDetailsForm() {
        super(By.xpath("//div[contains(@class, 'personal-details__content')]"), "PersonalDetailsForm");
    }
}
