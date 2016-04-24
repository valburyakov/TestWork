package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Admin on 23.04.2016.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
}
