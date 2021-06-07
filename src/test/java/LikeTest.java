import Helpers.ApiHelper;
import Helpers.LoginHelper;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import setup.DriverSetUp;

import java.io.IOException;

public class LikeTest {
    private String image_url;
    //private String hashtag = "#test_pic";
    private JsonObject photo;

    @BeforeMethod
    public void setUp() throws IOException {
        DriverSetUp.getDriver();
        JsonObject obj = ApiHelper.createUser();
        LoginHelper.loginWithKey(obj.get("key").toString());
//        LoginDialog loginPage = new LoginDialog();
//        loginPage.enterUsername(obj.get("username").toString());
//        loginPage.enterUsername(obj.get("username").toString());
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.quit();
    }

    @Test
    public void like() throws IOException, InterruptedException {
        String key = "3fb5ce77-a372-42bf-9a52-289dfa0f4324";
        JsonObject image = ApiHelper.uploadPhoto(key);
        ApiHelper.likePhoto(key, image.get("id").getAsString());
        new ImageBrowserPage(image.get("id").getAsString());
    }
}

