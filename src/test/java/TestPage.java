import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

public class TestPage {

    private WebDriver driver;
    private NavBar navBar;

    @BeforeTest
    public void drive() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
        navBar = new NavBar(driver);

    }

    @Test(priority = 0)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        navBar.clickLogInButtonFromNavBarSO();

        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();

        assertTrue("Error while Logging in", navBar.isProfileIconDisplayed());

    }


    @Test(priority = 1)
    public void logout() {
        navBar = new NavBar(driver);
        navBar.clickLogOutButtonFromNavBarSI();
        assertTrue("Error while Logging out", navBar.isLogInButtonDisplayed());
    }

    @AfterTest
    public void endDrive(){
        driver.quit();
    }
}
