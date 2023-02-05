package DemoQaTests;

import DemoQaBase.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextBoxTests extends Base {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeUrl);
    }

    @Test
    public void clickOnLogoFromTextBoxPage() {
        homePage.clickOnElements();
        logoBarPage.clickOnLogo();
        assertThatCurrentUrlIs(homeUrl);
    }

    @Test
    public void clickOnElementsButton() {
        homePage.clickOnElements();
        sideBarPage.clickOnButton("Text Box");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/text-box");
    }

    @Test
    public void userSubmittedWithAllValidInfo() {
        clickOnElementsButton();
        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        String validCurrentAddres = excelReader.getStringData("TextBox", 1, 2);
        String validPermanentAddress = excelReader.getStringData("TextBox", 1, 3);
        textBoxPage.insertFullName(validFullName);
        textBoxPage.insertEmail(validEmail);
        textBoxPage.insertCurrentAddres(validCurrentAddres);
        textBoxPage.inserPermanentAddres(validPermanentAddress);
        textBoxPage.clickOnSubmitButton();
        scrollIntoView(textBoxPage.outputTextInfo);
        Assert.assertTrue(isDisplayed(textBoxPage.outputTextInfo));
        Assert.assertEquals(textBoxPage.outputTextInfo.getText(),
                "Name:Pera Peric\n" +
                        "Email:pera@email.com\n" +
                        "Current Address :Adresa Validna\n" +
                        "Permananet Address :Trenutna Adresa");
        // Assert.assertEquals(textBoxPage.outputTextInfo.getText(), "Name:Pera Peric");
    }


    @Test
    public void userSubmittedWithOneInsertField() {
        clickOnElementsButton();
        String validFullName = excelReader.getStringData("TextBox", 1, 0);
        textBoxPage.insertFullName(validFullName);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.outputTextInfo));

    }

    @Test
    public void userSubmittedWithTwoInsertField() {
        clickOnElementsButton();
        userSubmittedWithOneInsertField();
        String validEmail = excelReader.getStringData("TextBox", 1, 1);
        textBoxPage.insertEmail(validEmail);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.outputTextInfo));
        Assert.assertEquals(textBoxPage.outputTextInfo.getText(), "Name:Pera Peric\n" +
                "Email:pera@email.com");
    }

    @Test
    public void userSubmittedWithThreeInsertField() {
        clickOnElementsButton();
        userSubmittedWithTwoInsertField();
        String validCurrentAddress = excelReader.getStringData("TextBox", 1, 2);
        textBoxPage.insertCurrentAddres(validCurrentAddress);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(isDisplayed(textBoxPage.outputTextInfo));
        Assert.assertEquals(textBoxPage.outputTextInfo.getText(), "Name:Pera Peric\n" +
                "Email:pera@email.com\n" +
                "Current Address :Adresa Validna");

    }

    @Test
    public void userCanNotSubmittedWithEmptyField() {
        clickOnElementsButton();
        textBoxPage.insertFullName("");
        textBoxPage.insertEmail("");
        textBoxPage.insertCurrentAddres("");
        textBoxPage.inserPermanentAddres("");
        textBoxPage.submitButton.click();
        Assert.assertFalse(isDisplayed(textBoxPage.outputTextInfo));

    }

    //
//    /**
//     * This test use data provider which provides all invalid email addresses.
//     * Data provider is defined by "invalid-email-provider"
//     * @param invalidEmail invalid email that is passed from data provider
//     */
    @Test(dataProvider = "invalid-email-provider")
    public void userCanNotSubmittedWithInvalidEmail(String invalidEmail) {
        clickOnElementsButton();
        textBoxPage.insertEmail(invalidEmail);
        textBoxPage.clickOnSubmitButton();
        Assert.assertFalse(isDisplayed(textBoxPage.outputTextInfo));
    }

    @DataProvider(name = "invalid-email-provider")//def provajder i dam mu podatke iz tabele
    public Object[][] invalidEmailDataProvider() { // koristim ga umesto for petlje, to je pruzalac podataka
        return new Object[][]{//
                {excelReader.getStringData("TextBoxInvalidEmail", 1, 0)},
                {excelReader.getStringData("TextBoxInvalidEmail", 2, 0)},
                {excelReader.getStringData("TextBoxInvalidEmail", 3, 0)},
                {excelReader.getStringData("TextBoxInvalidEmail", 4, 0)},
        };
    }


}
