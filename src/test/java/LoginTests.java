import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;
import setup.*;

import java.time.Clock;

import static org.junit.Assert.assertTrue;

public class LoginTests {
    private NavBar navBar;
    Clock clock = Clock.systemUTC();

    @BeforeMethod
    public void drive() {
        DriverSetUp.getDriver();
        navBar = new NavBar();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test(priority = 6666)
    public void loginWithValidCredentials() {
        LoginDialog loginPage = new LoginDialog();
        if (navBar == null) navBar = new NavBar();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        Assert.assertTrue(navBar.initPage().isProfileIconDisplayed(), "Error while Logging in");

    }

    @Test
    public void loginWithINValidUsername() {
        LoginDialog loginPage = new LoginDialog();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("jaeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.initPage().getTopSectionErrorMessage().contains("Username or password incorrect"));
    }

    @Test
    public void loginWithEmptyUsername() {
        LoginDialog loginPage = new LoginDialog();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.initPage().isInputFieldRed());
    }

    @Test
    public void loginWithINValidPassword() {
        LoginDialog loginPage = new LoginDialog();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("2309018d90");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.initPage().getTopSectionErrorMessage().contains("Username or password incorrect"));
    }


    @Test
    public void loginWithEmptyPassword() {
        LoginDialog loginPage = new LoginDialog();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.initPage().isInputFieldRed());
    }


}
