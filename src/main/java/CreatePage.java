import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

import java.util.List;

public class CreatePage extends BasePage {
    private By uploadButton = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private By downloadButton = By.id("download-button");
    private By instagramButton = By.cssSelector("[data-test='insta-story']");
    private By sizeBoxes = By.cssSelector("[class*='customSizeContainer']");
    private By sideBarObjects=By.cssSelector("[class*='sidebarTooltipItem']");

    public CreatePage() {
        openByURL(("https://picsartstage2.com/create"));
    }

    public void UploadImage() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(uploadButton));
        WebElement uploadBtn = findWebElement(uploadButton);
        uploadBtn.sendKeys("/Users/armen_a02/Desktop/me_aua.png");
    }

    public boolean isDownloadButtonDisplayed() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(downloadButton));
        return true;
    }

    public void clickInstagramStory() {
        Actions actions = new Actions(DriverSetUp.driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(instagramButton));
        actions.moveToElement(findWebElement(instagramButton)).click().build().perform();
    }

    public int getSizesListSize(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sizeBoxes));
        return findWebElements(sizeBoxes).size();
    }

    public void closeInstructionsWindowByCookie(){
        Cookie myCookie = new Cookie("we-editor-first-open", "true");
        driver.manage().addCookie(myCookie);
        driver.navigate().refresh();
    }

    public void clickTemplatesIcon(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sideBarObjects));
        findWebElements(sideBarObjects).get(0).click();
    }

    @Override
    public String getUrl() {
        return null;
    }
}
