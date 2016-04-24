package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Admin on 23.04.2016.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user_login")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement userpassword;

    @FindBy(id = "signin_submit")
    private WebElement submintButton;

    public void signIn(String name, String password) {
        if (getDriver().getPageSource().contains("Please login")) {
            userName.sendKeys(name);
            userpassword.sendKeys(password);
            submintButton.click();
        }
    }

}
