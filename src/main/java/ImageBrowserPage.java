import org.openqa.selenium.By;

public class ImageBrowserPage extends BasePage {

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");
    private final By hashtag = By.cssSelector("[class*='grid-col'] [href*='/hashtag']");

    public ImageBrowserPage() {
    }

    public ImageBrowserPage(String imageID) {
        openByURL(BASE_URL + "/i/" + imageID);
    }

    public String getHashtag(){
        WaitHelper.getInstance().WaitForElementToBeDisplayed(hashtag);
        return findWebElement(hashtag).getText();
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void clickOnLikeIcon() {
        WaitHelper.getInstance().WaitForElementToBeDisplayed(likeIconLocation);
        click(likeIconLocation);
    }

    public boolean isImageLiked() {
        return findWebElement(likeIconLocation).getAttribute("class").contains("active");
    }
}
