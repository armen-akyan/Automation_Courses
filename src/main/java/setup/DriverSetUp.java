package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverSetUp {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://automation.picsartstage2.com/");
        return driver;
    }

    public static void quit() {
        DriverSetUp.getDriver().quit();
        driver = null;
    }

}
