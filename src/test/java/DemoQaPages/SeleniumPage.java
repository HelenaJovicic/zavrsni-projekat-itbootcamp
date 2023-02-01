package DemoQaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPage {

    public WebDriver driver;
    public WebDriverWait wdwait;


    @FindBy(className = "enroll__heading")
    public WebElement titleText;

    @FindBy(css =".btn.btn-primary-shadow.btn-block")
    public WebElement goToRegistartionButton;

    @FindBy (className = "navbar__tutorial-menu--text")
    public WebElement tutorialsButton;


    public SeleniumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}



