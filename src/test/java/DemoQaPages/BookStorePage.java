package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BookStorePage {


    @FindBy(id = "userName")
    public WebElement usernameTextField;
    @FindBy(id = "password")
    public WebElement passwordTextField;
    @FindBy(id = "login")
    public WebElement submitUsernameAndPasswordButton;

    @FindBy(id = "gotoStore")
    public WebElement goToBookStoreButton;

    public WebDriver driver;
    public WebDriverWait wdwait;

    public BookStorePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
        PageFactory.initElements(driver, this);
    }

    public void insertUsername(String username) {
        usernameTextField.clear();
        usernameTextField.sendKeys(username);
    }

    public void insertPassword(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    public void submitUsernameAndPassword() {
        submitUsernameAndPasswordButton.click();
    }

    public void clickOnGoToBookStoreButton() {
        wdwait.until(ExpectedConditions.elementToBeClickable(goToBookStoreButton));
        goToBookStoreButton.click();
    }

    public WebElement getGoToBookStoreButton() {
        return goToBookStoreButton;
    }

    public void assertThatCartIsEmpty() {
        try {
            WebElement webElement = wdwait.until(ExpectedConditions.presenceOfElementLocated(By.className("rt-noData")));
            Assert.assertTrue(webElement.isDisplayed());
            System.out.println("Cart is epmty");
        } catch (Exception e) {
            System.out.println("Cart is not empty");
            e.printStackTrace();
            Assert.fail("Cart should be empty (but it contains some books)");
        }
    }

    public void addBookByLinkText(String bookNameByLinkText) {
        //get a book by link text
        WebElement addBook = wdwait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(bookNameByLinkText)));
        addBook.click();

        //click
        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("addNewRecordButton")));
        List<WebElement> backAndAddToCollectionButtons = driver.findElements((By.id("addNewRecordButton")));
        WebElement addToYourCollectionButton = backAndAddToCollectionButtons.get(1);
        scrollIntoView(addToYourCollectionButton);
        //scroll into view
        addToYourCollectionButton.click();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void closeAlert() {
        try {
            Thread.sleep(3000); //wait for the alert to appear in order to close it
            driver.switchTo().alert().accept();
        } catch (Exception exception) {
            System.out.println("no alert");
        }
    }
}
