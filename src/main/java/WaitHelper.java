import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.*;

public class WaitHelper {
    private final static int DEFAULT_TIMEOUT = 10;

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public WaitHelper WaitForElementToBeDisplayed(By location) {
        try {
            new WebDriverWait(DriverSetUp.driver, DEFAULT_TIMEOUT).
                    until(ExpectedConditions.visibilityOfElementLocated(location));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with locator " + location.toString() + "  not found");
        }
    }
}
