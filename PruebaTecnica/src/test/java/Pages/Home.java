package Pages;


import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Home extends BaseClass {


    @FindBy(xpath = "(//div[contains(@class,'buttons')]/button)[2]")
    public WebElement YesButton;


    public String CountryItem = "//span[@data-ref='country__name' and contains(text(),'%s')]";
    @FindBy(xpath = "//input[contains(@id,'departure')]")
    public WebElement departureInput;

    @FindBy(xpath = "//div[contains(@data-ref,'dates-from')]")
    public WebElement departureCalendarInput;
    @FindBy(xpath = "//div[@class='calendar-body__cell']")
    public List<WebElement> dates;

    //I use dinamic xpath so I can change the city without changing the code
    public String CityItem = "//span[@data-ref='airport-item__name' and contains(text(),'%s')]";

    public String specificDate = "//div[@data-id='%s']";
    @FindBy(xpath = "//button[@data-ref='flight-search-widget__cta']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@data-ref='passengers-picker__adults']//div[@data-ref='counter.counter__increment']")
    public WebElement addAdult;
    @FindBy(xpath = "//*[@data-ref='passengers-picker__children']//div[@data-ref='counter.counter__increment']")
    public WebElement addChild;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void inicio() {
        // accept cookies
        YesButton.click();

    }

    public void enterDeparture(String departureCountry, String departureCity) {
        departureInput.click();
        WebElement country;
        WebElement city;
        country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CountryItem, departureCountry))));
        country.click();
        city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CityItem, departureCity))));
        city.click();

    }

    public void enterDestination(String destinationCountry, String destinationCity) {

        WebElement country;
        WebElement city;
        country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CountryItem, destinationCountry))));
        country.click();
        city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(CityItem, destinationCity))));
        city.click();

    }

    public void selectDepartureDate() {
        dates.get(1).click();
    }

    public void selectComeBackDate() {
        dates.get(7).click();
    }

    public void addAdult(int numAdults) {
        for (int i = 0; i < numAdults - 1; i++) {
            addAdult.click();
        }

    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void addChild(int numChilden) {
        for (int i = 0; i < numChilden; i++) {
            addChild.click();
        }
    }


    public void openDepartureCalendar() {
        WebElement departureCalendar;
        departureCalendar = wait.until(ExpectedConditions.elementToBeClickable(departureCalendarInput));
        departureCalendar.click();
    }

    public void selectDate(String dateString) {
        WebElement date;
        date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(specificDate, dateString))));
        date.click();
    }

    public void selectMonth(String monthName) {
        WebElement monthScroll;
        monthScroll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(specificDate, monthName))));
        monthScroll.click();
    }
}
