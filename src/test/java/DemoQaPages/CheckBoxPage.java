package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckBoxPage {

    public static final String HOME_CB_TEXT = "Home";
    public static final String DESKTOP_CB_TEXT = "Desktop";
    public static final String NOTES_CB_TEXT = "Notes";
    public static final String COMMANDS_CB_TEXT = "Commands";
    public static final String DOCUMENTS_CB_TEXT = "Documents";
    public static final String WORKSPACE_CB_TEXT = "WorkSpace";
    public static final String REACT_CB_TEXT = "React";
    public static final String ANGULAR_CB_TEXT = "Angular";
    public static final String VEU_CB_TEXT = "Veu";
    public static final String OFFICE_CB_TEXT = "Office";
    public static final String PUBLIC_CB_TEXT = "Public";
    public static final String PRIVATE_CB_TEXT = "Private";
    public static final String CLASSIFIED_CB_TEXT = "Classified";
    public static final String GENERAL_CB_TEXT = "General";
    public static final String DOWNLOADS_CB_TEXT = "Downloads";
    public static final String WORD_CB_TEXT = "Word File.doc";
    public static final String EXCEL_CB_TEXT = "Excel File.doc";

    public static final List<String> ALL_CHECKBOXES =
            List.of(HOME_CB_TEXT, DESKTOP_CB_TEXT, NOTES_CB_TEXT, COMMANDS_CB_TEXT, DOCUMENTS_CB_TEXT,
                    WORKSPACE_CB_TEXT, REACT_CB_TEXT, ANGULAR_CB_TEXT, VEU_CB_TEXT, OFFICE_CB_TEXT,
                    PUBLIC_CB_TEXT, PRIVATE_CB_TEXT, CLASSIFIED_CB_TEXT, GENERAL_CB_TEXT, DOWNLOADS_CB_TEXT,
                    WORD_CB_TEXT, EXCEL_CB_TEXT);

    public WebDriver driver;

    @FindAll(@FindBy(className = "rct-text"))
    public List<WebElement> allCheckBoxesWithArrows;

    @FindBy(id = "result")
    public WebElement textResult;

    @FindBy(css = ".rct-option.rct-option-expand-all")
    public WebElement plusButton;

    @FindBy(css = ".rct-option.rct-option-collapse-all")
    public WebElement minusButton;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnButton(String buttonName) {
        getCheckBoxByName(buttonName).click();
    }

    public WebElement getButtonByName(String buttonName) {
        return getCheckBoxByName(buttonName);
    }

    public void clickOnPlusButton() {
        plusButton.click();
    }

    public void clickOnMinusButton() {
        minusButton.click();
    }

    public void clickOnArrowButtonByName(String checkboxName) {
        getArrowAssociatedWithCheckBoxByCheckBoxName(checkboxName)
                .click();
    }

    /**
     * @return only visible checkboxes and associated arrows
     */
    public List<WebElement> getAllCheckBoxesWithArrows() {
        return allCheckBoxesWithArrows;
    }

    /**
     * @param checkBoxName check box name
     * @return web element that contains both checkbox and arrow associated to that checkbox
     */
    public WebElement getCheckBoxWithArrowByName(String checkBoxName) {
        for (WebElement checkBoxWithArrow : getAllCheckBoxesWithArrows()) {
            if (checkBoxWithArrow.getText().equals(checkBoxName)) {
                return checkBoxWithArrow;
            }
        }

        Assert.fail("Failed to get checkbox and associated arrow by name: " + checkBoxName);
        return null;
    }

    public WebElement getCheckBoxByName(String checkBoxName) {
        WebElement checkBoxWithArrow = getCheckBoxWithArrowByName(checkBoxName);
        WebElement checkBoxOnly = checkBoxWithArrow.findElement(By.className("rct-checkbox"));
        return checkBoxOnly;
    }

    public WebElement getArrowAssociatedWithCheckBoxByCheckBoxName(String checkBoxName) {
        WebElement checkBoxWithArrow = getCheckBoxWithArrowByName(checkBoxName);
        WebElement arrowAssociatedWithCheckbox = checkBoxWithArrow.findElement(By.xpath(".//button"));
        return arrowAssociatedWithCheckbox;
    }
}
