import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextEditorPage extends BasePage {

    private By textPreset = By.cssSelector("[data-test='text-preset']");
    private By canvasContainer = By.cssSelector("[data-test='canvas-container']");
    private By headingText = By.cssSelector("[data-test='heading_text']");
    private By shadowButton = By.cssSelector("[data-test='shadow']");
    private By colorInputField = By.cssSelector("[data-test='color_input']");
    private By layersItems = By.cssSelector("[data-test='layers-item']");
    private By chosenColorBox = By.cssSelector("[data-test='first_color_box']");

    @Override
    public String getUrl() {
        return BASE_URL + "create/editor?category=text";
    }

    public TextEditorPage() {
        openByURL(getUrl());
    }

    public void dragAndDropTexts() throws InterruptedException {
        scrollUntilVisibleJS(textPreset);
        WebElement text = findWebElement(textPreset);
        WebElement canvas = findWebElement(canvasContainer);
        dragAndDrop(textPreset, canvasContainer);
    }

    public void clickHeadingText() {
        clickByJS(headingText);
    }

    public void clickShadowButton() {
        clickByJS(shadowButton);
    }

    public WebElement getColorInputField() {
        return findWebElement(colorInputField);
    }

    public int getLayersItemsCount() {
        List<WebElement> layerItems = findWebElements(layersItems);
        return layerItems.size();
    }

    public String getChosenColorValue() {
        WebElement webElement = findWebElement(chosenColorBox);
        return webElement.getCssValue("background-color");
    }
}
