package Pages;


import Utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Extras extends BaseClass {


    @FindBy(xpath = "//button[contains(@class,'airport-and-flight')]")
    public WebElement continueButton;
    @FindBy(xpath = "//button[contains(@class,'transport')]")
    public WebElement continueButtonTransport;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void continueButton() {
        WebElement continueExtras;
        continueExtras = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueExtras.click();
    }

    public void continueButtonTransport() {
        WebElement continueTransport;
        continueTransport = wait.until(ExpectedConditions.elementToBeClickable(continueButtonTransport));
        continueTransport.click();
    }
}
