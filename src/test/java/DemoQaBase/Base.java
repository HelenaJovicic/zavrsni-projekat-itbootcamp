package DemoQaBase;

import DemoQaPages.*;
import common.excel.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Base {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public String homeUrl;
    public ExcelReader excelReader;
    public SeleniumPage seleniumPage;
    public CheckBoxPage checkBoxPage;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        excelReader = new ExcelReader("src/test/java/DemoQaData.xlsx");
        homeUrl = excelReader.getStringData("URL", 1, 0);
        seleniumPage = new SeleniumPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage (driver);
        checkBoxPage = new CheckBoxPage (driver);



    }

    public void switchToTabWithTheUrl(String url) {
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (driver.getCurrentUrl().equals(url)) {
                break; //kad pronadjes tab izadji
            }
        }
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webelement;
    }

    public void assertThatCartIsEmpty() {
        try {
            WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("rt-noData")));
            Assert.assertTrue(webElement.isDisplayed());
            System.out.println("Cart is epmty");
        } catch (Exception e) {
            System.out.println("Cart is not empty");
            e.printStackTrace();
            Assert.fail("no rows element not found - possibly there are books in cart");
        }
    }


}
