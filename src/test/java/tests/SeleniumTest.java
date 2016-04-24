package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.ApplicationPage;
import pages.LoginPage;
import pages.NewUserPage;
import utils.BrowserFactory;

import static org.testng.Assert.*;
import static utils.PropertyReader.*;
import static utils.Waitings.*;

public class SeleniumTest {
    public final String url = "https://admin.quickblox.com/signin";

    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.getDriver(getProperty("browser"));
        setTimeouts(driver, 10, 10);
        maximaze(driver);
    }

    @BeforeMethod
    public void openUrl(){
        driver.get(url);
        LoginPage login = new LoginPage(driver);
        login.signIn(getProperty("user"), getProperty("password"));
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "valik1", "Valentin Ivanov", "11111111", "valik@gmail.com"}};
    }

   @Test(dataProvider = "Authentication")
    public void testUserAdd(String user, String fullName, String password, String email) throws Exception {
        // wait for application list
        ApplicationPage app = new ApplicationPage(driver);
        String appName = getProperty("application");
        app.selectApplication(appName)
                .clickUsers()
                .addNewUser();

        NewUserPage userPage = new NewUserPage(driver);
        userPage.createUser(user, fullName, email, password);
        // check is User added successfully
        assertTrue(userPage.isNewUserAdded(), "User is not added!");
    }

    @Test(dataProvider = "Authentication")
    public void testUserShouldNotAdd(String user, String fullName, String password, String email) throws Exception {
        // wait for application list
        ApplicationPage app = new ApplicationPage(driver);
        String appName = getProperty("application");
        app.selectApplication(appName)
                .clickUsers()
                .addNewUser();

        NewUserPage userPage = new NewUserPage(driver);
        userPage.createUser(user, fullName, "valburyakov@gmail.com", password);
        // check is User not Added
        assertFalse(userPage.isNewUserAdded(), "User added!");
    }

    @Test
    public void testUserShouldExists() throws Exception {
        // wait for application list
        ApplicationPage app = new ApplicationPage(driver);
        String appName = getProperty("application");
        app.selectApplication(appName).clickUsers();
        // check is User In Table
        assertTrue(app.isUserAddedInTable(getProperty("user")));

    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
