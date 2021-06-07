import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverSetUp;

import java.util.List;

public class TextEditorPage extends BasePage<TextEditorPage> {

    @FindBy(css = "[data-test='text-preset']")
    private WebElement textPreset;

    @FindBy(css = "[data-test='canvas-container']")
    private WebElement canvasContainer;

    @FindBy(css = "[data-test='heading_text']")
    private WebElement headingText;

    @FindBy(css = "[data-test='shadow']")
    private WebElement shadowButton;

    @FindBy(css = "[data-test='color_input']")
    private WebElement colorInputField;

    @FindBy(css = "[data-test='layers-item']")
    private List<WebElement> layersItems;

    @FindBy(css = "[data-test='first_color_box']")
    private WebElement chosenColorBox;

    @FindBy(id = "context-menu")
    private WebElement contextMenu;


    @Override
    public String getUrl() {
        return BASE_URL + "create/editor?category=text";
    }

    public TextEditorPage() {
        openByURL(getUrl());
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    public void clickHeadingText() {
        clickByJS(headingText);
    }

    public void clickShadowButton() {
        clickByJS(shadowButton);
    }

    public WebElement getColorInputField() {
        return colorInputField;
    }

    public int getLayersItemsCount() {
        return layersItems.size();
    }

    public String getChosenColorValue() {
        return chosenColorBox.getCssValue("background-color");
    }

    public WebElement getCanvasContainer() {
        return canvasContainer;
    }

    public boolean isContextMenuDisplayed() {
        return isDisplayed(contextMenu);
    }
}
