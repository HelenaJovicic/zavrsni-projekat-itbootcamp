package DemoQaTests;

import DemoQaBase.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends Base {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeUrl);
    }

    @Test
    public void logInWithValidCredentials() {
        scrollIntoView(homePage.getCards().get(5));
        homePage.clickOnBookstore();

        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books");

        scrollIntoView(sideBarPage.getButtonWithText("Login"));
        sideBarPage.clickOnButton("Login");

        String validUsername = excelReader.getStringData("BookStoreLogin", 1, 0);
        String validPassword = excelReader.getStringData("BookStoreLogin", 1, 1);

        bookStorePage.insertUsername(validUsername);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.submitUsernameAndPassword();

        assertThatCurrentUrlIs("https://demoqa.com/profile");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
    }

    @Test
    public void addOneBook() {
        //given we are logged in and on profile page
        logInWithValidCredentials();
        //and cart is empty
        bookStorePage.assertThatCartIsEmpty();

        //when we go back to book store
        waitForVisibility(bookStorePage.getGoToBookStoreButton());
        bookStorePage.clickOnGoToBookStoreButton();
        //and we add a book
        bookStorePage.addBookByLinkText("Git Pocket Guide");
        //and alert is closed
        bookStorePage.closeAlert();

        //then the book is in cart
        profilePage.assertThatBookByLinkTextIsAdded("Git Pocket Guide");
    }

    @AfterMethod
    public void emtpyCartAndLogout() {
        profilePage.emtpyCart();
        profilePage.logout();
    }

}
