package DemoQaTests;

import DemoQaBase.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTests extends Base {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeUrl);
    }

    @Test
    public void clickOnCheckBoxCard(){
        homePage.clickOnElements();
        elementsPage.clickOnButton("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");
        Assert.assertTrue(isDisplayed(checkBoxPage.buttonHome));
    }

    @Test
    public void clickOnHomeButton(){
        homePage.clickOnElements();
        elementsPage.clickOnButton("Check Box");
        checkBoxPage.clickOnButtonHome();
        Assert.assertTrue(isDisplayed(checkBoxPage.textResult));
        Assert.assertEquals(checkBoxPage.textResult.getText(), "You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");
    }












}
