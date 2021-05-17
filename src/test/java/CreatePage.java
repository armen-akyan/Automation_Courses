import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePage extends BasePage {
    private By uploadButton = By.cssSelector("[accept='image/jpeg, image/png, image/gif']");
    private By downloadButton=By.id("download-button");

    public CreatePage(){
        openByURL(("https://picsartstage2.com/create"));
    }
    public void UploadImage() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(uploadButton));
        WebElement uploadBtn = findWebElement(uploadButton);
        uploadBtn.sendKeys("/Users/armen_a02/Desktop/me_aua.png");
    }

    public boolean isDownloadButtonDisplayed(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(downloadButton));
        return true;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
