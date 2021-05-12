import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertTrue;

public class TestPage {

    private WebDriver driver;

    public void login() {
        LoginPage loginPage=new LoginPage(driver);

        loginPage.clickLogInButtonFromNavBar();
        loginPage.enterUsername("janeeyr");
        loginPage.enterPassword("230901890");
        loginPage.clickSignIn();
    }

    public void logout() {
        driver.findElement(By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo")).click();
        WebElement logoutButton = driver.findElement(By.cssSelector("[href='/logout']"));
        logoutButton.click();
    }


    public boolean isProfileIconDisplayed() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo")));
        WebElement profileIcon = driver.findElement(By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo"));
        return profileIcon.isDisplayed();
    }

    @BeforeMethod
    public void drive(){
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://picsartstage2.com/");
    }

    @Test
    public void FirstTest() {
        //Set Driver
        drive();

        //Login
        login();

        //assertTrue( "Error while Logging in", driver.getCurrentUrl().contains("/create"));
        assertTrue( "Error while Logging in", isProfileIconDisplayed());

        //Check if Login Successful
        System.out.println(isProfileIconDisplayed() ? "Login Successful" : "Error while Logging in");

        //Logout
        if (isProfileIconDisplayed())
            logout();

        //Quit Driver
        driver.quit();
    }
}
