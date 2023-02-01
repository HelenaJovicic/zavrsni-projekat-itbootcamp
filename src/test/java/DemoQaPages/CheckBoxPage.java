package DemoQaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckBoxPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    @FindBy(className="rct-title")
    public WebElement buttonHome;

    @FindBy(id="result")
    public WebElement textResult;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonHome(){
        buttonHome.click();
    }

















}
