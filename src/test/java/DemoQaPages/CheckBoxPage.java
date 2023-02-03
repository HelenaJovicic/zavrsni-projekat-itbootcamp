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

    @FindBy (css = ".rct-collapse.rct-collapse-btn")
    public WebElement buttonArrow;

    @FindBy(id="result")
    public WebElement textResult;

    @FindBy (css = ".rct-option.rct-option-expand-all")
    public WebElement plusButton;

    @FindBy (css = ".rct-option.rct-option-collapse-all")
    public WebElement minusButton;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonHome(){
        buttonHome.click();
    }

    public void clickOnPlusButton(){
        plusButton.click();
    }

    public void clickOnMinusButton(){
        minusButton.click();
    }

    public void clickOnArrowButton(){
        buttonArrow.click();
    }

















}
