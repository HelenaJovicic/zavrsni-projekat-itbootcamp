package DemoQaTests;

import DemoQaBase.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends Base {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeUrl);
    }

    @Test
    public void clickOnRadioButtonCard() {
        homePage.clickOnElements();
        sideBarPage.clickOnButton("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/radio-button");
        Assert.assertTrue(isDisplayed(radioButtonPage.titleText));
        Assert.assertEquals(radioButtonPage.titleText.getText(), "Do you like the site?");

    }

    @Test
    public void clickOnRadioButtonYes() {
        clickOnRadioButtonCard();
        radioButtonPage.clickOnRadioButton("Yes");
        Assert.assertTrue(isDisplayed(radioButtonPage.getOutputText()));
        Assert.assertEquals(radioButtonPage.getOutputText().getText(), "You have selected Yes");
    }

    @Test
    public void clickOnRadioButtonImpressive() {
        clickOnRadioButtonCard();
        radioButtonPage.clickOnRadioButton("Impressive");
        Assert.assertTrue(isDisplayed(radioButtonPage.getOutputText()));
        Assert.assertEquals(radioButtonPage.getOutputText().getText(), "You have selected Impressive");
    }

    @Test
    public void clickOnRadioButtonNo() {
        //given user is on the home page (before each)
        //when user clicks on the radio button card
        clickOnRadioButtonCard();
        //then radio button No is not clickable
        Assert.assertEquals(radioButtonPage.getRadioButtonWithText("No").getCssValue("cursor"), "not-allowed");
        //when user clicks on radio button No
        radioButtonPage.clickOnRadioButton("No");
        //then output text is not visible
        Assert.assertFalse(isDisplayed(radioButtonPage.getOutputText()));

    }


}
