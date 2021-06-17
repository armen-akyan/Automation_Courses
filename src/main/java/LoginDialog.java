import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

public class LoginDialog extends BasePage<LoginDialog> {

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

    @Override
    protected void load() {
        DriverSetUp.getDriver().get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        isUserNameFieldDisplayed();
    }


    public void enterUsername(String username) {
        if (isDisplayed(usernameField))
            type(usernameField, username);
    }

    public void enterPassword(String password) {
        if (isDisplayed(passwordField))
            type(passwordField, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public String getTopSectionErrorMessage() {
        if (isDisplayed(topSectionErrorMessage))
            return topSectionErrorMessage.getText();
        return null;
    }

    public boolean isInputFieldRed() {
        return isDisplayed(errorRedBoxClass);
    }

    public boolean isUserNameFieldDisplayed(){
        return isDisplayed(usernameField);
    }


}
