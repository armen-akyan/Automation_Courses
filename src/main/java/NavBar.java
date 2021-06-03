import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

public class NavBar extends BasePage {

    @FindBy(css = "[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']")
    private WebElement logInNavBarSO;

    @FindBy(css = "[href='/logout']")
    private WebElement logOutNavBarSI;

    @FindBy(css = ".pa-uiLib-headerProfileInfo-profileInfo")
    private WebElement profileIcon;

    @FindBy(name = "username")
    private WebElement usernameField;


    @Override
    public String getUrl() {
        return BASE_URL;
    }


    public NavBar() {
        openByURL(getUrl());
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    public void clickLogOutButtonFromNavBarSI() {
        isProfileIconDisplayed();
        clickProfileIcon();
        logOutNavBarSI.click();
        WaitHelper.getInstance().WaitForElementToBeDisplayed(logInNavBarSO);
    }

    public void clickLogInButtonFromNavBarSO() {
        logInNavBarSO.click();
        WaitHelper.getInstance().WaitForElementToBeDisplayed(usernameField);
    }

    public void clickProfileIcon() {
        click(profileIcon);

    }

    public boolean isProfileIconDisplayed() {
        return isDisplayed(profileIcon);
    }

    public boolean isLogInButtonDisplayed() {
        return isDisplayed(logInNavBarSO);

    }


}
