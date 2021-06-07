import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.*;

import static org.testng.AssertJUnit.assertTrue;

public class LogOutTest {
    private NavBar navBar;

    @BeforeMethod
    public void drive() {
        DriverSetUp.getDriver();
        new LoginTests().loginWithValidCredentials();
        navBar = new NavBar();
    }

    @AfterMethod
    public void endDrive(){
        DriverSetUp.quit();
    }

    @Test
    public void logout() {
        navBar.clickLogOutButtonFromNavBarSI();
        assertTrue("Error while Logging out", navBar.isLogInButtonDisplayed());
    }
}
