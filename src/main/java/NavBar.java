import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

public class NavBar {
    private By logInNavBarSO = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By logOutNavBarSI = By.cssSelector("[href='/logout']");
    private By profileIcon = By.cssSelector(".pa-uiLib-headerProfileInfo-profileInfo");


    private By usernameField = By.name("username"); //to check in login dialogue


    public void clickLogOutButtonFromNavBarSI() {
        isProfileIconDisplayed();
        clickProfileIcon();
        WebElement logOutBtn = DriverSetUp.driver.findElement(logOutNavBarSI);
        logOutBtn.click();
        new WebDriverWait(DriverSetUp.driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logInNavBarSO));
    }

    public void clickLogInButtonFromNavBarSO() {
        new WebDriverWait(DriverSetUp.driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logInNavBarSO));

        WebElement loginBtn = DriverSetUp.driver.findElement(logInNavBarSO);
        loginBtn.click();
        new WebDriverWait(DriverSetUp.driver, 2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameField));
    }

    public void clickProfileIcon(){
        if (isProfileIconDisplayed()){
            WebElement profileIcn = DriverSetUp.driver.findElement(profileIcon);
            profileIcn.click();
        }

    }

    public boolean isProfileIconDisplayed() {
        new WebDriverWait(DriverSetUp.driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(profileIcon));
        WebElement profileIcn = DriverSetUp.driver.findElement(profileIcon);
        return profileIcn.isDisplayed();
    }

    public boolean isLogInButtonDisplayed() {
        new WebDriverWait(DriverSetUp.driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logInNavBarSO));
        WebElement loginBtn = DriverSetUp.driver.findElement(logInNavBarSO);
        return loginBtn.isDisplayed();
    }
}
