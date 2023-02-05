package DemoQaTests;

import DemoQaBase.Base;
import DemoQaPages.CheckBoxPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTests extends Base {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeUrl);
    }

    @Test
    public void clickOnCheckBoxCard() {
        homePage.clickOnElements();
        sideBarPage.clickOnButton("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");
        Assert.assertTrue(isDisplayed(checkBoxPage.getButtonByName("Home")));
    }

    @Test
    public void clickOnHomeButton() {
        clickOnCheckBoxCard();
        checkBoxPage.clickOnButton("Home");
        Assert.assertTrue(isDisplayed(checkBoxPage.textResult));
        Assert.assertEquals(checkBoxPage.textResult.getText(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }

    @Test
    public void clickOnButtonPlus() {
        clickOnCheckBoxCard();
        assertCheckBoxIsDisplayed("Home");
        assertCheckBoxIsNotDisplayed("Desktop");
        assertCheckBoxIsNotDisplayed("Documents");
        assertCheckBoxIsNotDisplayed("Downloads");

        checkBoxPage.clickOnPlusButton();

        assertAllCheckBoxesAreVisible();
    }

    public void assertCheckBoxIsDisplayed(String checkBoxName) {
        List<WebElement> checkBoxesWithArrows = checkBoxPage.getAllCheckBoxesWithArrows();
        boolean checkBoxVisisble = false;
        for (WebElement webElement : checkBoxesWithArrows) {
            if (webElement.getText().equals(checkBoxName)) {
                checkBoxVisisble = true;
                break;
            }
        }
        Assert.assertTrue(checkBoxVisisble, "Checkbox with name " + checkBoxName + " should be visible");
    }

    public void assertCheckBoxIsNotDisplayed(String checkBoxName) {
        List<WebElement> checkBoxesWithArrows = checkBoxPage.getAllCheckBoxesWithArrows();
        boolean checkBoxVisisble = false;
        for (WebElement webElement : checkBoxesWithArrows) {
            if (webElement.getText().equals(checkBoxName)) {
                checkBoxVisisble = true;
                break;
            }
        }
        Assert.assertFalse(checkBoxVisisble, "Checkbox with name " + checkBoxName + " should not be visible");
    }

    @Test
    public void clickOnDesktopCheckBox() {
        clickOnCheckBoxCard();

        assertCheckBoxIsDisplayed("Home");
        assertCheckBoxIsNotDisplayed("Desktop");
        assertCheckBoxIsNotDisplayed("Documents");
        assertCheckBoxIsNotDisplayed("Downloads");

        checkBoxPage.clickOnArrowButtonByName("Home");
        assertCheckBoxIsDisplayed("Desktop");
        assertCheckBoxIsDisplayed("Documents");
        assertCheckBoxIsDisplayed("Downloads");

        checkBoxPage.clickOnButton("Desktop");
        assertCheckBoxIsNotDisplayed("Notes");
        assertCheckBoxIsNotDisplayed("Commands");

        Assert.assertEquals(checkBoxPage.textResult.getText(),
                "You have selected :\n" +
                        "desktop\n" +
                        "notes\n" +
                        "commands");
    }

    @Test
    public void deselectDesktopWhenAllBoxesWereChecked() {
        //given home button and all child boxes are checked
        clickOnCheckBoxCard();
        clickOnHomeButton();

        //when user expand the tree
        checkBoxPage.clickOnPlusButton();
        //then all boxes are visible
        assertAllCheckBoxesAreVisible();

        //when user deselect Desktop checkbox
        checkBoxPage.clickOnButton("Desktop");
        //then output is changed and in output there's no desktop, notes and commands
        Assert.assertEquals(checkBoxPage.textResult.getText(),
                "You have selected :\n" +
                        "documents\n" +
                        "workspace\n" +
                        "react\n" +
                        "angular\n" +
                        "veu\n" +
                        "office\n" +
                        "public\n" +
                        "private\n" +
                        "classified\n" +
                        "general\n" +
                        "downloads\n" +
                        "wordFile\n" +
                        "excelFile");
    }

    @Test
    public void clickOnButtonMinus() {
        clickOnCheckBoxCard();
        clickOnButtonPlus();

        assertAllCheckBoxesAreVisible();
        checkBoxPage.clickOnMinusButton();

        assertCheckBoxIsDisplayed(CheckBoxPage.HOME_CB_TEXT);
        assertCheckBoxIsNotDisplayed(CheckBoxPage.DESKTOP_CB_TEXT);
        assertCheckBoxIsNotDisplayed(CheckBoxPage.DOCUMENTS_CB_TEXT);
        assertCheckBoxIsNotDisplayed(CheckBoxPage.DOWNLOADS_CB_TEXT);
        Assert.assertFalse(isDisplayed(checkBoxPage.textResult)); //nema texta resulta kada odmah kliknem na +- dugme
    }

    private void assertAllCheckBoxesAreVisible() {
        for (String checkBoxName : CheckBoxPage.ALL_CHECKBOXES) {
            assertCheckBoxIsDisplayed(checkBoxName);
        }
    }

    @Test
    public void clickOnButtonPlusAfterHomeButtonIsClicked() {
        clickOnCheckBoxCard();
        clickOnHomeButton();
        clickOnButtonPlus();
        Assert.assertTrue(isDisplayed(checkBoxPage.textResult));
    }

    @Test
    public void clickOnButtonMinusAfterHomeButtonIsClicked() {
        clickOnCheckBoxCard();
        clickOnHomeButton();
        clickOnButtonPlus();
        checkBoxPage.minusButton.click();
        Assert.assertTrue(isDisplayed(checkBoxPage.textResult));
    }

    @Test
    public void clickOnButtonArrow() {
        clickOnCheckBoxCard();
        checkBoxPage.clickOnArrowButtonByName("Home");
        checkBoxPage.clickOnArrowButtonByName("Documents");
        checkBoxPage.clickOnArrowButtonByName("Office");
    }


}
