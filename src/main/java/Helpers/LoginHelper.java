package Helpers;

import org.openqa.selenium.Cookie;
import setup.DriverSetUp;

public class LoginHelper {


    public static void loginWithKey(String key) {
        if (key == null)
            key = "3fb5ce77-a372-42bf-9a52-289dfa0f4324";
        DriverSetUp.getDriver().manage().addCookie(new Cookie("user_key", key));
        DriverSetUp.getDriver().navigate().refresh();
    }
}
