import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

public class LoginPage extends BasePage{

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By signInButton = By.cssSelector("[class*='primary pa-uiLib-authentication-signIn']");
    private By topSectionErrorMessage = By.cssSelector("[class='pa-uiLib-authentication-signInForm-container'] [class*='error'] span");
    private By errorRedBoxClass = By.cssSelector(".pa-uiLib-input-withError");

    public LoginPage(){
        openByURL(("https://picsartstage2.com/"));
    }


    public void enterUsername(String username) {
        type(usernameField,username);
    }

    public void enterPassword(String password) {
        type(passwordField,password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public String getTopSectionErrorMessage() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(topSectionErrorMessage));
        WebElement errorMessage = findWebElement(topSectionErrorMessage);
        return errorMessage.getText();
    }
    public boolean isInputFieldRed() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorRedBoxClass));
        return isDisplayed(errorRedBoxClass);
    }

    @Override
    public String getUrl() {
        return null;
    }
}
