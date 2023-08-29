package Pages;


import Utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Seats extends BaseClass {


    @FindBy(xpath = "//button[contains(@class,'seats-modal')]")
    public WebElement OkayModal;
    @FindBy(xpath = "//button[contains(@class,'seatmap__seat seatmap__seat--standard')]//parent::div")
    public List<WebElement> seats;
    @FindBy(xpath = "//button[contains(@data-ref,'next')]")
    public WebElement nextFlight;

    @FindBy(xpath = "//button[contains(@class,'next')]")
    public WebElement continueButton;
    @FindBy(xpath = "//button[contains(@class,'dismiss')]")
    public WebElement noThanks;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void clickOKModal() {
        WebElement OKModal;
        OKModal = wait.until(ExpectedConditions.elementToBeClickable(OkayModal));
        OKModal.click();
    }


    public void selectSeats(int numSeats) {
        List<WebElement> seatsAvailable;
        seatsAvailable = wait.until(ExpectedConditions.visibilityOfAllElements(seats));
        for (int i = 0; i < numSeats; i++) {
            //It does not work with a simple element.click(), so I use Actions to move the mouse to the element and perform click on it
            new Actions(driver)
                    .moveToElement(seatsAvailable.get(20))
                    .click()
                    .perform();

        }
    }

    public void clickNextFlight() {
        nextFlight.click();
    }


    public void doNotAddFastTrack() {
        WebElement noThankS;
        noThankS = wait.until(ExpectedConditions.elementToBeClickable(noThanks));
        noThankS.click();

    }

    public void continueButton() {
        continueButton.click();
    }
}
