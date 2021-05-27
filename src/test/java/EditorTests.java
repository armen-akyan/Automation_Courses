import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EditorTests {
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
    public void imageUpload() {
        CreatePage createPage = new CreatePage();
        //new LoginTests().loginWithKey();
        createPage.UploadImage();
        assertTrue( createPage.isDownloadButtonDisplayed(),"Upload Failed");
    }

    @Test
    public void instaStory() {
        CreatePage createPage = new CreatePage();
        createPage.clickInstagramStory();
        createPage.switchToTab(1);
        createPage.closeInstructionsWindowByCookie();
        createPage.clickTemplatesIcon();
        assertEquals( createPage.getSizesListSize(),28, "Number of elements is less than 28");
    }


}
