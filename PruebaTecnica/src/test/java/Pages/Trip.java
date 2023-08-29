package Pages;


import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Trip extends BaseClass {


    @FindBy(xpath = "//button[contains(@class,'flight-card-summary')]")
    public List<WebElement> selectFlight;

    @FindBy(xpath = "//span[contains(@class,'login-later')]")
    public WebElement logInLater;
    @FindBy(xpath = "((//div[@class='dropdown body-l-lg body-l-sm']//span[text()='-'])[1])/parent::button")
    public WebElement titleDropdownEmpty;
    @FindBy(xpath = "(//label[contains(text(),'First')]/preceding-sibling::div//input[not(contains(@class,'_has-value'))])[1]")
    public WebElement firstNameEmpty;
    @FindBy(xpath = "//button[contains(@class,'continue')]")
    public WebElement continueButton;
    @FindBy(xpath = "(//label[contains(text(),'Last')]/preceding-sibling::div//input[not(contains(@class,'_has-value'))])[1]")
    public WebElement lastNameEmpty;
    public String fares = "//th[contains(@data-e2e,'%s')]";

    public String titles = "//div[contains(text(),'%s')]";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void selectDepartureFlight() {
        List<WebElement> flights;
        flights = wait.until(ExpectedConditions.visibilityOfAllElements(selectFlight));
        flights.get(0).click();
    }

    public void selectComeBackFlight() {
        List<WebElement> flights;
        flights = wait.until(ExpectedConditions.visibilityOfAllElements(selectFlight));
        flights.get(flights.size() - 1).click();
    }


    public void selectFare(String fareString) {

        WebElement fare;
        fare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(fares, fareString))));
        fare.click();
    }

    public void clickLogInLater() {
        WebElement linkLogInLater;
        linkLogInLater = wait.until(ExpectedConditions.elementToBeClickable(logInLater));
        linkLogInLater.click();
    }

    public void fillAdultPassengerDetails(String title, String firstName, String lastName) {
        titleDropdownEmpty.click();
        driver.findElement(By.xpath(String.format(titles, title))).click();
        firstNameEmpty.sendKeys(firstName);
        lastNameEmpty.sendKeys(lastName);
    }

    public void fillChilPassengerDetails(String firstName, String lastName) {
        firstNameEmpty.sendKeys(firstName);
        lastNameEmpty.sendKeys(lastName);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
