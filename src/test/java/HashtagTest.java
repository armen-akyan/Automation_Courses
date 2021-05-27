import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
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
    private String hashtag = "#test_pic";
    private JsonObject photo;

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        //login
        DriverSetUp.getDriver();
        new LoginPage();
        JsonObject user = ApiHelper.createUser();
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginTests.loginWithKey(key);

        //upload photo
        photo = ApiHelper.uploadPhoto(key);
        image_url = photo.get("id").getAsString();
    }

    @Test
    public void checkHashtag() {
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(photo.get("id").getAsString());
        assertEquals(imageBrowserPage.getHashtag(), hashtag, "Hashtag displayed incorrect");
    }

    @AfterMethod
    public void cleanUp() throws IOException {
        //delete user
        ApiHelper.deleteUser(key);
        ErrorPage errorPage = new ErrorPage(key);
        assertTrue(errorPage.isErrorMessageDisplayed(), "User not deleted");
        //quit driver
        DriverSetUp.driver.quit();
    }

//    @Test
//    public void like() throws IOException, InterruptedException {
//        JsonObject image = ApiHelper.uploadPhoto(key);
//        ApiHelper.likePhoto(key, image.get("id").getAsString());
//        new ImageBrowserPage(image.get("id").getAsString());
//    }
}
