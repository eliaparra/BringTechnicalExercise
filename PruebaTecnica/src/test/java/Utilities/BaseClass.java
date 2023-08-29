package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {

    public static WebDriver driver;

    public BaseClass() {
        PageFactory.initElements(driver, this);
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean result = false;
        try {
            if (element.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
        }
        return result;
    }
}
