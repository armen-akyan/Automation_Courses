import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

public class LoginTests {

    private WebDriver driver;
    private NavBar navBar;

    @BeforeMethod
    public void drive() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
        navBar = new NavBar(driver);

    }

    @Test(priority = 6666)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error while Logging in", navBar.isProfileIconDisplayed());

    }

    @Test
    public void loginWithINValidUsername() {
        LoginPage loginPage = new LoginPage(driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("jaeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.getTopSectionErrorMessage().contains("Username or password incorrect"));
    }

    @Test
    public void loginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.isInputFieldRed());
    }

    @Test
    public void loginWithINValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("2309018d90");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.getTopSectionErrorMessage().contains("Username or password incorrect"));
    }


    @Test
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("");
        loginPage.clickSignIn();

        assertTrue("Error message not displayed", loginPage.isInputFieldRed());
    }

//    @Test(priority = 8898989)
//    public void logout() {
//        navBar = new NavBar(driver);
//        navBar.clickLogOutButtonFromNavBarSI();
//        assertTrue("Error while Logging out", navBar.isLogInButtonDisplayed());
//    }

    @AfterTest
    public void endDrive(){
        driver.quit();
    }
}
