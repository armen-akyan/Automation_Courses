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
    private By logInNavBar = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogInButtonFromNavBar() {
        WebElement loginBtn = driver.findElement(logInNavBar);
        loginBtn.click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameField));
    }

    public void enterUsername(String username) {
        WebElement usernameFld = driver.findElement(usernameField);
        usernameFld.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordFld = driver.findElement(passwordField);
        passwordFld.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(signInButton);
        signInBtn.click();
    }
}
