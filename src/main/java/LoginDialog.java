import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

public class LoginDialog extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "[class*='primary pa-uiLib-authentication-signIn']")
    private WebElement signInButton;

    @FindBy(css = "[class='pa-uiLib-authentication-signInForm-container'] [class*='error'] span")
    private WebElement topSectionErrorMessage;

    @FindBy(css = ".pa-uiLib-input-withError")
    private WebElement errorRedBoxClass;


    @Override
    public String getUrl() {
        return BASE_URL;
    }


    public LoginDialog() {
        openByURL(getUrl());
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }


    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public String getTopSectionErrorMessage() {
        return topSectionErrorMessage.getText();
    }

    public boolean isInputFieldRed() {
        return isDisplayed(errorRedBoxClass);
    }

}
