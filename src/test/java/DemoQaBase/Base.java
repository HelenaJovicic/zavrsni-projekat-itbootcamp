package DemoQaBase;

import DemoQaPages.*;
import common.excel.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public RadioButtonPage radioButtonPage;
    public BookStorePage bookStorePage;

    public SideBarPage sideBarPage;

    public ProfilePage profilePage;
    public LogoBarPage logoBarPage;

    public JavascriptExecutor js;



    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        homePage = new HomePage(driver);
        excelReader = new ExcelReader("src/test/java/DemoQaData.xlsx");
        homeUrl = excelReader.getStringData("URL", 1, 0);
        seleniumPage = new SeleniumPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage (driver);
        checkBoxPage = new CheckBoxPage (driver);
        radioButtonPage = new RadioButtonPage(driver);
        bookStorePage = new BookStorePage(driver, wdwait);
        sideBarPage = new SideBarPage(driver);
        profilePage = new ProfilePage(driver, wdwait, js);
        logoBarPage = new LogoBarPage(driver);
    }

    public void assertThatCurrentUrlIs(String expectedCurrentUrl) {
        //wdwait ce cekati prethodno definisani broj sekundi da se sledeci uslov ispuni
        //until koristi funkciju gde se prosledjuje driver koji nam sluzi da preko njega ispitamo neki
        //web element ili u nasem slucaju da ispitamo current url
        wdwait.until(driver -> {
            //ova funkcija treba da vrati true ili false
            //ako vrati true to znaci da je uslov (condition) ispunjen i da test moze da nastavi dalje
            //ukoliko se vrati false wdwait ce pokusavati sve dokle ne istekne timeout ili se ne vrati true
            //ako istekne timeout test puca
            boolean matchUrl = driver.getCurrentUrl().equals(expectedCurrentUrl);
            return matchUrl;
        });
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

    public void performClickOnWebElement(WebElement element) {
        Actions act= new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void doubleClick(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].doubleClick();", element);
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



}
