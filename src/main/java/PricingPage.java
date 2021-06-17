import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;

import javax.swing.*;

public class PricingPage extends BasePage<PricingPage> {


    @FindBy(css = "[class='c0232']")
    private WebElement carouselImage;

    @FindBy(css = "[aria-label='Help']")
    private WebElement helpButton;

    @Override
    public String getUrl() {
        return BASE_URL + "gold";
    }

    public PricingPage() {
        openByURL(getUrl());
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    @Override
    protected void load() {
        DriverSetUp.getDriver().get(getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        isCarouselImageDisplayed();
    }

    public void swipeTestimonials() throws InterruptedException {
        scrollUntilVisibleJS(carouselImage);
        Actions actions = new Actions(DriverSetUp.getDriver());
        actions.moveByOffset(-4000, 0);
    }

    public boolean isCarouselImageDisplayed() {
        return isDisplayed(carouselImage);
    }
}
