package Pages;


import Utilities.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Payment extends BaseClass {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public String getURL() {

        //wait until the url is loaded
        wait.until(ExpectedConditions.urlContains("payment"));
        return driver.getCurrentUrl();
    }

}
