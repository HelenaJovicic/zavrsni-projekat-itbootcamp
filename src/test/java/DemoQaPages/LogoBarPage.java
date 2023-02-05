package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoBarPage {

    public WebDriver driver;
    public WebDriverWait wdwait;


    public LogoBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLogo() {
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"app\"]/header/a"));
        logo.click();
    }

}
