package DemoQaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {

    public WebDriver driver;
    public WebDriverWait wdwait;


    @FindBy(css = ".btnbtn-lightactive")
    public WebElement textBox;

    @FindBy(id = "userName")
    public WebElement fullName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".border.col-md-12.col-sm-12")
    public WebElement outputTextInfo;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnTextBox() {
        textBox.click();
    }

    public void insertFullName(String fullNameToEnter) {
        fullName.clear();
        fullName.click();
        fullName.sendKeys(fullNameToEnter);

    }

    public void insertEmail(String emailToEnter) {
        email.clear();
        email.click();
        email.sendKeys(emailToEnter);

    }

    public void insertCurrentAddres(String currentAddressToEnter) {
        currentAddress.clear();
        currentAddress.click();
        currentAddress.sendKeys(currentAddressToEnter);
    }

    public void inserPermanentAddres(String permanentAddressToEnter) {
        permanentAddress.clear();
        permanentAddress.click();
        permanentAddress.sendKeys(permanentAddressToEnter);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }


}
