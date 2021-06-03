import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import setup.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;

public abstract class BasePage {
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;
    protected static final String BASE_URL = "https://automation.picsartstage2.com/";

    public BasePage() {
        this.driver = DriverSetUp.getDriver();
    }

    public abstract String getUrl();

    public final void open() {
        openByURL(getUrl());
    }

    public WebElement findWebElement(By location) {
        LOGGER.info("Finding element -> " + location.toString());
        WaitHelper.getInstance().WaitForElementToBeDisplayed(location);
        return driver.findElement(location);
    }

    public List<WebElement> findWebElements(By location) {
        LOGGER.info("Finding element -> " + location.toString());
        WaitHelper.getInstance().WaitForElementToBeDisplayed(location);
        return driver.findElements(location);
    }

    public void type(By location, String text) {
        LOGGER.info("Typing " + text + " in -> " + location.toString());

        type(findWebElement(location), text);
    }

    public void type(WebElement element, String text) {
        LOGGER.info("Typing " + text + " in -> " + element.toString());

        element.sendKeys(text);
    }

    public void click(By location) {
        LOGGER.info("Clicking on -> " + location.toString());

        click(findWebElement(location));
    }

    public void click(WebElement element) {
        LOGGER.info("Clicking on -> " + element.toString());

        element.click();
    }

    public void clickByJS(By location) {
        LOGGER.info("Clicking on -> " + location.toString());
        ((JavascriptExecutor) DriverSetUp.getDriver()).executeScript("arguments[0].click();", findWebElement(location));
    }

    public void clickByJS(WebElement element) {
        LOGGER.info("Clicking on -> " + element.toString());
        ((JavascriptExecutor) DriverSetUp.getDriver()).executeScript("arguments[0].click();", element);
    }

    public void clickAndHold(By location) {
        LOGGER.info("Clicking and holding on -> " + location.toString());

        Actions actions = new Actions(driver);
        actions.clickAndHold(findWebElement(location)).perform();
    }

    public void clickAndHold(WebElement element) {
        LOGGER.info("Clicking and holding on -> " + element.toString());

        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            LOGGER.info("Making sure that element is displayed -> " + element.toString());
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
        try {
            LOGGER.info("Making sure that element is displayed -> " + location.toString());
            return findWebElement(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openByURL(String url) {
        LOGGER.info("Opening URL -> " + url);
        driver.get(url);
    }

    public void switchToTab(int index) {
        List<String> windowHandlers = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandlers.get(index));
    }

    public void dragAndDrop(By ByFrom, By ByTo) {
        WebElement LocatorFrom = driver.findElement(ByFrom);
        WebElement LocatorTo = driver.findElement(ByTo);
        String xto = Integer.toString(LocatorTo.getLocation().x);
        String yto = Integer.toString(LocatorTo.getLocation().y);
        ((JavascriptExecutor) driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
                        "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
                LocatorFrom, xto, yto);
    }


    public void scrollUntilVisibleJS(By location) {
        WebElement webElement = findWebElement(location);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void scrollUntilVisibleJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void typeJS(WebElement element, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value=" + text, element);
    }

    public void typeJS(By locator, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value=" + text, findWebElement(locator));
    }

    public void pressEnterOnElement(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void pressEnterOnElement(By locator) {
        findWebElement(locator).sendKeys(Keys.ENTER);
    }

    public void rightClick(WebElement element) {
        Actions actions = new Actions(DriverSetUp.getDriver());
        actions.contextClick(element).perform();
    }

    public void rightClick(By location) {
        Actions actions = new Actions(DriverSetUp.getDriver());
        actions.contextClick(findWebElement(location)).perform();
    }
}
