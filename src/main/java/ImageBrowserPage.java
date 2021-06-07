import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;

public class ImageBrowserPage extends BasePage<ImageBrowserPage> {

    @FindBy(css = ".actions-section .notifier-hover-toggle .like")
    private WebElement likeIcon;

    @FindBy(css = "[class*='grid-col'] [href*='/hashtag']")
    private WebElement hashtag;

    @Override
    public String getUrl() {
        return BASE_URL + "/i/";
    }

    public ImageBrowserPage(String imageID) {
        openByURL(getUrl() + imageID);
        PageFactory.initElements(DriverSetUp.getDriver(), this);

    }

    public String getHashtag() {
        WaitHelper.getInstance().WaitForElementToBeDisplayed(hashtag);
        return hashtag.getText();
    }


    public void clickOnLikeIcon() {
        click(likeIcon);
    }

    public boolean isImageLiked() {
        return likeIcon.getAttribute("class").contains("active");
    }
}
