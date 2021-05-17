import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import static org.junit.Assert.assertTrue;


public class EditorTests {
    private NavBar navBar;

    @BeforeSuite
    public void getLoggedIn() {

    }

    @BeforeMethod
    public void drive() {
        navBar = new NavBar();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.driver.quit();
    }

    @Test
    public void imageUpload() {
        CreatePage createPage = new CreatePage();
        new LoginTests().loginWithKey();
        createPage.UploadImage();
        assertTrue("Upload Failed", createPage.isDownloadButtonDisplayed());
    }
}
