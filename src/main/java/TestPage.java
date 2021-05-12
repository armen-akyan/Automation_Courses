import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestPage {

    public static void login(WebDriver driver) {
        WebElement signIn = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        signIn.click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("janeeyr");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("230901890");
        WebElement loginButton = driver.findElement(By.cssSelector("[class*='primary pa-uiLib-authentication-signIn']"));
        loginButton.click();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo")).click();
        WebElement logoutButton = driver.findElement(By.cssSelector("[href='/logout']"));
        logoutButton.click();
    }


    public static boolean isProfileIconDisplayed(WebDriver driver) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo")));
        WebElement profileIcon = driver.findElement(By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo"));
        return profileIcon.isDisplayed();
    }

    @Test
    public static void main(String[] args) throws InterruptedException {
        //Set Driver
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");

        //Login
        login(driver);

        //Check if Login Successful
        System.out.println(isProfileIconDisplayed(driver) ? "Login Successful" : "Error while Logging in");

        //Logout
        if (isProfileIconDisplayed(driver))
            logout(driver);

        //Quit Driver
        driver.quit();
    }
}
