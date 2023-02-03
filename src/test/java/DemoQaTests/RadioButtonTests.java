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
    public void clickOnRadioButtonCard()  {
        homePage.clickOnElements();
        elementsPage.clickOnButton("Radio Button");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/radio-button");
        //Assert.assertTrue(isDisplayed(radioButtonPage.titleText));
        //Thread.sleep(4000);
        //Assert.assertTrue(isDisplayed(radioButtonPage.radioButtonYes));

    }

    @Test
    public void clickOnRadioButtonYes(){
        clickOnRadioButtonCard();
        radioButtonPage.clickOnRadioButton("Yes");

    }
    @Test
    public void clickOnRadioButtonImpressive(){
        clickOnRadioButtonCard();
        radioButtonPage.clickOnRadioButton("Impressive");

    }

















}
