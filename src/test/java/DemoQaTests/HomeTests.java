package DemoQaTests;

import DemoQaBase.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTests extends Base {


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeUrl);

    }

    @Test
    public void clickOnBanner() {
        String expectedUrl = "https://www.toolsqa.com/selenium-training/";
        homePage.clickOnSeleniuBanner();
        switchToTabWithTheUrl(expectedUrl);//prebaci se na tab sa ocekivanom url
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertEquals(seleniumPage.titleText.getText(), "Selenium Certification Training | Enroll Now | Study Online");
        Assert.assertTrue(isDisplayed(seleniumPage.goToRegistartionButton));
        Assert.assertTrue(isDisplayed(seleniumPage.tutorialsButton));
    }

    @Test
    public void clickOnElementsCard() {
        homePage.clickOnElements();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/elements");
    }


    @Test
    public void clickOnFormsCard() {
        homePage.clickOnForms();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/forms");
    }

    @Test
    public void clickOnAlertsFrameWindows() {
        homePage.clickOnAlerts();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/alertsWindows");
    }

    @Test
    public void clickOnWidgets() {
        homePage.clickOnWidgets();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/widgets");
    }

    @Test
    public void clickOnInteractions() {
        homePage.clickOnInteractions();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/interaction");
    }

    @Test
    public void clickOnBookStoreApplication() {
        scrollIntoView(homePage.getCards().get(5));
        homePage.clickOnBookstore();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");
    }

}
