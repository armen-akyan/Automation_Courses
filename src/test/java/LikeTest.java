import com.google.gson.JsonObject;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class LikeTest {
    @BeforeMethod
    public void setUp() throws IOException {
        JsonObject obj = ApiHelper.createUser();
        LoginPage loginPage=new LoginPage();
        loginPage.enterUsername(obj.get("username").toString());
        loginPage.enterUsername(obj.get("username").toString());

    }
}
