package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Admin on 23.04.2016.
 */
public class ApplicationPage extends BasePage {

    public static final String USER_SELECTOR = ".qb-qbusers";
    public static final String APPS_LIST = "ul.apps-list";
    public static final String APP_NAV_MENU = "div.col-sm-2.col-nav.modules-menu";
    public static final String NEW_USER = "a.btn.btn-primary";
    public static final String USER_TABLE = "users_list";
    public static final int USER_ID_COLUMN = 1;
    public static final int USER_LOGIN_COLUMN = 2;

    public ApplicationPage(WebDriver driver) {
        super(driver);
    }

    public ApplicationPage selectApplication(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(APPS_LIST)));
        getDriver().findElement(By.xpath("//li/a[@title='" + name + "']")).click();
        return this;
    }

    public ApplicationPage clickUsers() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(APP_NAV_MENU)));
        getDriver().findElement(By.cssSelector(USER_SELECTOR)).click();
        return this;
    }

    public void addNewUser() {
        getDriver().findElement(By.cssSelector(NEW_USER)).click();
    }


    public boolean isUserAddedInTable(String login) {
        // wait for table with user appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("users_list_wrapper")));

        WebElement table_element = driver.findElement(By.id(USER_TABLE));
        List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + USER_TABLE + "')/tbody/tr"));
        boolean result = false;
        for(WebElement trElement : tr_collection) {

            List<WebElement> td_collection = trElement.findElements(By.xpath("td"));
            String userName = td_collection.get(USER_LOGIN_COLUMN).getText();
            System.out.println(userName);
            if (userName.equals(login)) {
                System.out.println("User ID: " + td_collection.get(USER_ID_COLUMN).getText());
                result = true;
                break;
            }
        }

        return result;
    }
}