import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import static org.junit.Assert.assertTrue;

public class LoginTests {
    private NavBar navBar;

    @BeforeMethod
    public void drive() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        Properties.driver = new ChromeDriver();
        Properties.driver.get("https://picsartstage2.com/");
        navBar = new NavBar(Properties.driver);
    }

    @AfterMethod
    public void endDrive() {
        Properties.driver.quit();
    }

    @Test(priority = 6666)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(Properties.driver);
        if (navBar == null) navBar = new NavBar(Properties.driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error while Logging in", navBar.isProfileIconDisplayed());

    }

    @Test
    public void loginWithINValidUsername() {
        LoginPage loginPage = new LoginPage(Properties.driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("jaeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.getTopSectionErrorMessage().contains("Username or password incorrect"));
    }

    @Test
    public void loginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(Properties.driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.isInputFieldRed());
    }

    @Test
    public void loginWithINValidPassword() {
        LoginPage loginPage = new LoginPage(Properties.driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("2309018d90");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.getTopSectionErrorMessage().contains("Username or password incorrect"));
    }


    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(Properties.driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.isInputFieldRed());
    }

}
