import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBar {
    private WebDriver driver;

    private By logInNavBarSO = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By logOutNavBarSI = By.cssSelector("[href='/logout']");
    private By profileIcon = By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo");


    private By usernameField = By.name("username"); //to check in login dialogue

    public NavBar(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogOutButtonFromNavBarSI() {
        isProfileIconDisplayed();
        clickProfileIcon();
        WebElement logOutBtn = driver.findElement(logOutNavBarSI);
        logOutBtn.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logInNavBarSO));
    }

    public void clickLogInButtonFromNavBarSO() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logInNavBarSO));

        WebElement loginBtn = driver.findElement(logInNavBarSO);
        loginBtn.click();
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameField));
    }

    public void clickProfileIcon(){
        if (isProfileIconDisplayed()){
            WebElement profileIcn = driver.findElement(profileIcon);
            profileIcn.click();
        }

    }

    public boolean isProfileIconDisplayed() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(profileIcon));
        WebElement profileIcn = driver.findElement(profileIcon);
        return profileIcn.isDisplayed();
    }

    public boolean isLogInButtonDisplayed() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logInNavBarSO));
        WebElement loginBtn = driver.findElement(logInNavBarSO);
        return loginBtn.isDisplayed();
    }
}
