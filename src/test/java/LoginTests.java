import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import setup.DriverSetUp;


import static org.junit.Assert.assertTrue;

public class LoginTests {
    private NavBar navBar;

    @BeforeMethod
    public void drive() {
        navBar = new NavBar();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.driver.quit();
    }

    @Test
    //@org.junit.Ignore
    public void loginWithKey(){
        DriverSetUp.driver.manage().addCookie(new Cookie("user_key","3fb5ce77-a372-42bf-9a52-289dfa0f4324"));
        DriverSetUp.driver.navigate().refresh();
        //assertTrue("Error while Logging in", navBar.isProfileIconDisplayed());
    }

    @Test(priority = 6666)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();
        if (navBar == null) navBar = new NavBar();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error while Logging in", navBar.isProfileIconDisplayed());

    }

    @Test
    public void loginWithINValidUsername() {
        LoginPage loginPage = new LoginPage();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("jaeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.getTopSectionErrorMessage().contains("Username or password incorrect"));
    }

    @Test
    public void loginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.isInputFieldRed());
    }

    @Test
    public void loginWithINValidPassword() {
        LoginPage loginPage = new LoginPage();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("2309018d90");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.getTopSectionErrorMessage().contains("Username or password incorrect"));
    }


    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage();

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.isInputFieldRed());
    }


}
