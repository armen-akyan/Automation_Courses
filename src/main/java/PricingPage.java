import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PricingPage extends BasePage {
    @Override
    public String getUrl() {
        return BASE_URL + "gold";
    }

    public PricingPage() {
        openByURL(getUrl());
    }


    private By carouselImage = By.cssSelector("[class='pa-uiLib-testimonial-old-avatarBlock']");
    private By helpButton = By.cssSelector("[aria-label='Help']");

    public void swipeTestimonials() throws InterruptedException {
        scrollUntilVisibleJS(carouselImage);
        WebElement carouselItem = findWebElement(carouselImage);
        findWebElement(helpButton);
        dragAndDrop(carouselImage, helpButton);
    }
}
