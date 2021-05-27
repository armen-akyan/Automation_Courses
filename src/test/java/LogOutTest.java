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
        DriverSetUp.getDriver().get("https://picsartstage2.com/");
        navBar = new NavBar();
    }

    @AfterMethod
    public void endDrive(){
        DriverSetUp.driver.quit();
    }

    @Test
    public void logout() {
        //new LoginTests().loginWithKey();
        navBar.clickLogOutButtonFromNavBarSI();
        assertTrue("Error while Logging out", navBar.isLogInButtonDisplayed());
    }
}
