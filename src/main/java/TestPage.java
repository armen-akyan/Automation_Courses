import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestPage {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
        WebElement signIn = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        signIn.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("janeeyr");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("230901890");
        WebElement loginButton=driver.findElement(By.cssSelector("[class*='primary pa-uiLib-authentication-signIn']"));
        loginButton.click();

        //driver.quit();
    }
}
