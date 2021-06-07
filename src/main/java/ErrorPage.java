import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;

public class ErrorPage extends BasePage<ErrorPage> {


    @FindBy(css = "[class='message']")
    private WebElement errorMessage;

    @Override
    public String getUrl() {
        return BASE_URL + "/u/";
    }


    public ErrorPage(String userKey) {
        openByURL(getUrl() + userKey);
        PageFactory.initElements(DriverSetUp.getDriver(), this);

    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }


}
