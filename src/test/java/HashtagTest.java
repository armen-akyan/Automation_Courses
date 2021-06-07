import Helpers.ApiHelper;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HashtagTest {
    private String key;
    private String image_url;
    //private String hashtag = "#test_pic";
    private String hashtag = "#freetoedit";
    private JsonObject photo;

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        //login
        DriverSetUp.getDriver();
//        new LoginDialog();
//        new NavBar().isLogInButtonDisplayed();
//        JsonObject user = Helpers.ApiHelper.createUser();
//        key = user.get("response").getAsJsonObject().get("key").getAsString();
//        LoginTests.loginWithKey(key);
//        new NavBar().isProfileIconDisplayed();
//
//        //upload photo
//        photo = Helpers.ApiHelper.uploadPhoto(key);
//        image_url = photo.get("id").getAsString();
    }

    @Test
    public void checkHashtag() {
        //ImageBrowserPage imageBrowserPage = new ImageBrowserPage(photo.get("id").getAsString());
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage("image-323342605037201");
        assertEquals(imageBrowserPage.getHashtag(), hashtag, "Hashtag displayed incorrect");
    }

    @AfterMethod
    public void cleanUp() throws IOException {
        //delete user
        ApiHelper.deleteUser(key);
        //quit driver
        DriverSetUp.quit();
    }


}
