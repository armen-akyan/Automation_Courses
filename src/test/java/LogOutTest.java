import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LogOutTest {
    private NavBar navBar;

    @BeforeMethod
    public void drive() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        Properties.driver = new ChromeDriver();
        Properties.driver.get("https://picsartstage2.com/");
        navBar = new NavBar(Properties.driver);
    }

    @AfterMethod
    public void endDrive(){
        Properties.driver.quit();
    }

    @Test
    public void logout() {
        LoginTests loginTests = new LoginTests();
        loginTests.loginWithValidCredentials();
        navBar.clickLogOutButtonFromNavBarSI();
        assertTrue("Error while Logging out", navBar.isLogInButtonDisplayed());
    }
}
