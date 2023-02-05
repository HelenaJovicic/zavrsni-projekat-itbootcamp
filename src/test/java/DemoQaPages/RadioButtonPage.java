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

    @FindBy(className = "mb-3")
    public WebElement titleText;

    /**
     * Prikazuje selektovani radio button u <b>output</b> textu
     */
    @FindBy(className = "mt-3")
    public WebElement outputText;

    @FindBy(id = "text-success")
    public WebElement textSuccessYes;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getRadioButtons() {
        return driver.findElements(By.className("custom-control-label"));
    }

    public WebElement getRadioButtonWithText(String text) {
        for (WebElement radioButton : getRadioButtons()) {
            if (radioButton.getText().equals(text)) {
                return radioButton;
            }
        }
        Assert.fail("Couldn't find radio button with text: " + text);
        return null;
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


    public List<WebElement> getSuccessText() {
        return driver.findElements(By.className("text-success"));
    }

    public void getSuccessTextt(String successText) {
        for (int i = 0; i < getRadioButtons().size(); i++) {
            if (getSuccessText().get(i).getText().equals(successText)) {
                getSuccessText().get(i).click();
                return;
            }
        }
        Assert.fail("I couldn't find a button with text: " + successText);
    }

    public WebElement getOutputText() {
        return outputText;
    }
}








