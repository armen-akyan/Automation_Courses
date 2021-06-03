import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

import java.util.List;

public class CreatePage extends BasePage {
    @FindBy(css = "[accept='image/jpeg, image/png, image/gif']")
    private WebElement uploadButton;

    @FindBy(id = "download-button")
    private WebElement downloadButton;

    @FindBy(css = "[data-test='insta-story']")
    private WebElement instagramButton;

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> sizeBoxes;

    @FindBy(css = "[class*='sidebarTooltipItem']")
    private List<WebElement> sideBarObjects;

    @Override
    public String getUrl() {
        return BASE_URL + "create";
    }

    public CreatePage() {
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    public void UploadImage() {
        WaitHelper.getInstance().WaitForElementToBeDisplayed(uploadButton);
        uploadButton.sendKeys("/Users/armen_a02/Desktop/me_aua.png");
    }

    public boolean isDownloadButtonDisplayed() {
        WaitHelper.getInstance().WaitForElementToBeDisplayed(downloadButton);
        return true;
    }

    public void clickInstagramStory() {
        Actions actions = new Actions(DriverSetUp.driver);
        WaitHelper.getInstance().WaitForElementToBeDisplayed(instagramButton);
        actions.moveToElement(instagramButton).click().build().perform();
    }

    public int getSizesListSize() {
        WaitHelper.getInstance().WaitForElementsToBeDisplayed(sizeBoxes);
        return sizeBoxes.size();
    }

    public void closeInstructionsWindowByCookie() {
        Cookie myCookie = new Cookie("we-editor-first-open", "true");
        driver.manage().addCookie(myCookie);
        driver.navigate().refresh();
    }

    public void clickTemplatesIcon() {
        WaitHelper.getInstance().WaitForElementsToBeDisplayed(sideBarObjects);
        sideBarObjects.get(0).click();
    }


}
