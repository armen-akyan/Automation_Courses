import org.openqa.selenium.By;

public class ErrorPage extends BasePage {

    private By errorMessage = By.cssSelector("[class='message']");

    public ErrorPage(String userKey) {
        openByURL(BASE_URL + "/u/" + userKey);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    @Override
    public String getUrl() {
        return null;
    }


}
