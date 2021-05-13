import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By signInButton = By.cssSelector("[class*='primary pa-uiLib-authentication-signIn']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameField));
        WebElement usernameFld = driver.findElement(usernameField);
        usernameFld.sendKeys(username);
    }

    public void enterPassword(String password) {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(passwordField));
        WebElement passwordFld = driver.findElement(passwordField);
        passwordFld.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(signInButton);
        signInBtn.click();
    }
}
