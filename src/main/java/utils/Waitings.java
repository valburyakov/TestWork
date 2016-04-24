package utils;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Waitings {

    public static void setTimeouts(WebDriver driver, int implicityWaitInSec, int pageTimeOutInSec) {
        driver.manage().timeouts().implicitlyWait(implicityWaitInSec, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageTimeOutInSec, TimeUnit.SECONDS);
    }

    public static void maximaze(WebDriver driver) {
        driver.manage().window().maximize();
    }

}
