package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SideBarPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public SideBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getButtons() {
        return driver.findElements(By.cssSelector(".btn.btn-light"));
    }

    public WebElement getButtonWithText(String buttonText) {
        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals(buttonText)) {
                return getButtons().get(i);
            }
        }
        Assert.fail("Failed to get button with text: " + buttonText);
        return null;
    }

    public void clickOnButton(String buttonText) {
        getButtonWithText(buttonText).click();
    }












}
