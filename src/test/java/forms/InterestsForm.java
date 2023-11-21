package forms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import utils.FileUploaderUtils;
import utils.RandomUtils;

public class InterestsForm extends Form {
    private static final By RANDOM_SELECT_LOCATOR = By.xpath("//div[@class='avatar-and-interests__interests-list']//label[not(contains(@for, 'unselectall') or contains(@for, 'selectall'))]");
    private final ICheckBox unSelectAllCheckbox = getElementFactory().getCheckBox(By.xpath("//label[contains(@class, 'checkbox__label') and contains(@for, 'interest_unselectall')]"), "UnSelectAllCheckBox");
    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'avatar-and-interests__upload-button')]"), "UploadButton");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[contains(@name, 'button') and contains(@class, 'button button--stroked button--white button--fluid')]"), "NextButton");

    public InterestsForm() {
        super(By.xpath("//div[contains(@class, 'avatar-and-interests__avatar-box')]"), "InterestForm");
    }

    //click on unselect all
    public void clickUnselectAllCheckbox() {
        unSelectAllCheckbox.click();
    }

    // upload image
    public void uploadImage(String imagePath) {
        uploadButton.click();
        FileUploaderUtils.copyImagePath(imagePath);
    }

    //select random elements
    public void chooseInterests(int numberOfInterest) {
        List<ICheckBox> checkboxes = getElementFactory().findElements(RANDOM_SELECT_LOCATOR, ICheckBox.class);

        Set<Integer> selectedIndexes = new HashSet<>();
        while (selectedIndexes.size() < numberOfInterest) {
            int randomIndex = RandomUtils.generateRandomNumber(checkboxes.size());
            if (selectedIndexes.add(randomIndex)) {
                checkboxes.get(randomIndex).click();
            }
        }
    }

    //Next Page
    public void clickNextButton() {
        nextButton.click();
    }
}
