import Helpers.LoginHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EditorTests {
    private NavBar navBar;

    @BeforeMethod
    public void drive() {
        DriverSetUp.getDriver();
        navBar = new NavBar();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public void imageUpload() {
        LoginHelper.loginWithKey(null);
        CreatePage createPage = new CreatePage();
        createPage.uploadImage();
        assertTrue(createPage.initPage().isDownloadButtonDisplayed(), "Upload Failed");
    }

    @Test
    public void instaStory() {
        CreatePage createPage = new CreatePage();
        createPage.clickInstagramStory();
        createPage.switchToTab(1);
        createPage.initPage().closeInstructionsWindowByCookie();
        createPage.clickTemplatesIcon();
        assertEquals(createPage.initPage().getSizesListSize(), 28, "Number of elements is less than 28");
    }


}
