package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ElementsPage {

    public WebDriver driver;
    public WebDriverWait wdwait;


    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getButtons() {
        return driver.findElements(By.cssSelector(".btn.btn-light"));
    }

    public void clickOnButton(String buttonText) {
        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals(buttonText)) {
                getButtons().get(i).click();
                return;
            }
        }

        Assert.fail("I couldn't find a button with text: " + buttonText);
    }

}
