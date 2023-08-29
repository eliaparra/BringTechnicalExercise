package Pages;


import Utilities.BaseClass;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Bags extends BaseClass {


    @FindBy(xpath = "//span[@data-ref='product.CBAG']")
    public WebElement smallBagsLink;
    @FindBy(xpath = "//div[@class='_container']")
    public WebElement smallBagsCheckbox;
    @FindBy(xpath = "//input[@value='small-bag']")
    public WebElement smallBagsRadio;
    @FindBy(xpath = "//button[contains(@data-ref,'continue-button')]")
    public WebElement continueButton;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    /*
    * It seems they are performing A/B testing on this step and sometimes appears a link, other a checkbox and other a radio button.
    * That is the reason why I have 3 locators.
    * */
    public void checkSmallBag() {
        if (isElementDisplayed(smallBagsCheckbox)) {
            smallBagsCheckbox.click();
        } else if (isElementDisplayed(smallBagsLink)) {
            smallBagsLink.click();
        } else if (isElementDisplayed(smallBagsRadio)) {
            smallBagsRadio.click();
        }

    }


    public void continueButton() {
        WebElement buttonContinue;
        buttonContinue = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        buttonContinue.click();
    }
}
