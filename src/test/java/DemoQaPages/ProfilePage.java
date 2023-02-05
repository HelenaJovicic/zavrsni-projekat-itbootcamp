package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public JavascriptExecutor js;

    public ProfilePage(WebDriver driver, WebDriverWait wdwait, JavascriptExecutor js) {
        this.driver = driver;
        this.wdwait = wdwait;
        this.js = js;
        PageFactory.initElements(driver, this);
    }

    public void assertThatBookByLinkTextIsAdded(String bookNameByLinkText) {
        driver.get("https://demoqa.com/profile");
        try {
            wdwait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(bookNameByLinkText)));
        } catch (Exception e) {
            Assert.fail("Book " + bookNameByLinkText + " is not found in cart");
        }
    }


    public void emtpyCart() {
        //delete all books
        driver.get("https://demoqa.com/profile");

        //scroll down so addToYourCollectionButton is visible
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("submit")));
        driver.findElements(By.id("submit")).get(2).click(); //delete all books clicked

        wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("closeSmallModal-ok"))).click();

        closeAlert();
    }

    public void logout() {
        driver.get("https://demoqa.com/profile");
        wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("submit")));

        //logout
        driver.findElements(By.id("submit")).get(0).click();
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
