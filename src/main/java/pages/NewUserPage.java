package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Admin on 24.04.2016.
 */
public class NewUserPage extends BasePage {
    public NewUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user_full_name")
    private WebElement fullName;

    @FindBy(id = "user_email")
    private WebElement email;

    @FindBy(id = "user_login")
    private WebElement login;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(id = "user_password_confirmation")
    private WebElement confirmPass;

    @FindBy(id = "user_submit")
    private WebElement submintButton;


    public void createUser(String userLogin, String name, String mail, String pass) {

        fullName.sendKeys(name);
        email.sendKeys(mail);
        login.sendKeys(userLogin);
        password.sendKeys(pass);
        confirmPass.sendKeys(pass);

        submintButton.click();
    }

    public boolean isNewUserAdded() {
        try {
            return wait.until(
                    ExpectedConditions.textToBePresentInElementLocated(
                            By.id("form-messages"), "User has been successfully created"));
        }catch (TimeoutException e) {
            return  false;
        }

    }

}
