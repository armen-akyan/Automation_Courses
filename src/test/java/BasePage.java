import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import setup.DriverSetUp;

public abstract class BasePage {
    protected WebDriver driver;
    protected static final String BASE_URL = "http://picsart.com";

    public BasePage() {
        this.driver = DriverSetUp.getDriver();
    }

    public abstract String getUrl();

    public WebElement findWebElement(By location) {
        System.out.println("Finding element -> " + location.toString());

        return driver.findElement(location);
    }

    public void type(By location, String text) {
        System.out.println("Typing " + text + " in -> " + location.toString());

        type(findWebElement(location), text);
    }

    public void type(WebElement element, String text) {
        System.out.println("Typing " + text + " in -> " + element.toString());

        element.sendKeys(text);
    }

    public void click(By location) {
        System.out.println("Clicking on -> " + location.toString());

        click(findWebElement(location));
    }

    public void click(WebElement element) {
        System.out.println("Clicking on -> " + element.toString());

        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            System.out.println("Making sure that element is displayed -> " + element.toString());
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
        try {
            System.out.println("Making sure that element is displayed -> " + location.toString());
            return findWebElement(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openByURL(String url) {
        System.out.println("Opening URL -> " + url);
        driver.get(url);
    }
}
