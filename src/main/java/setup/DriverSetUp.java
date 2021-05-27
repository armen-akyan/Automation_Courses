package setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverSetUp {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

}
