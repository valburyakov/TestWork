package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Admin on 24.04.2016.
 */
public class BrowserFactory {
    public BrowserFactory() {}

    public static WebDriver getDriver(String name) {

        WebDriver defaultDriver = new FirefoxDriver();

        if (name.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }

        return defaultDriver;
    }
}
