package DemoQaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    @FindBy(className = "banner-image")
    public WebElement seleniumBanner;


    @FindAll(@FindBy(className = "card-body")) //pronalazi sve web elemente koji imaju class="card-body".
    // ovo je isto sto i driver.findElements(By.className("card-body"));

    public List<WebElement> cards; // i sve ih smesta u cards


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCards() {
        return cards;
    }

    public void clickOnSeleniuBanner() {
        seleniumBanner.click();

    }

    public void clickOnElements() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Elements")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnForms() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Forms")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnAlerts() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Alerts, Frame & Windows")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnWidgets() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Widgets")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnInteractions() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Interactions")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnBookstore() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Book Store Application")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnCard(String cardName) {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals(cardName)) {
                getCards().get(i).click();
                break;
            }
        }
    }


}
