package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class RadioButtonPage {

    public WebDriver driver;

    @FindBy(id = "Ad.Plus-728x90")
    public WebElement titleText;


    public List<WebElement> getRadioButtons() {
        return driver.findElements(By.className("custom-control-label"));
    }

    public void clickOnRadioButton(String radioButtonText) {
        for (int i = 0; i < getRadioButtons().size(); i++) {
            if (getRadioButtons().get(i).getText().equals(radioButtonText)) {
                getRadioButtons().get(i).click();
                return;
            }
        }
        Assert.fail("I couldn't find a button with text: " + radioButtonText);
    }

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}








