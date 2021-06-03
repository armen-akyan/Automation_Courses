import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class TextEditorTests {
    @BeforeMethod
    public void setUp() {
        DriverSetUp.getDriver();
    }

    @AfterMethod
    public void endDrive() {
        DriverSetUp.driver.quit();
    }


    @Test
    public void addHeadingTest() {
        TextEditorPage textEditorPage = new TextEditorPage();
        textEditorPage.clickHeadingText();
        assertEquals(textEditorPage.getLayersItemsCount(), 2, "text not clicked");
        textEditorPage.clickShadowButton();
        textEditorPage.typeJS(textEditorPage.getColorInputField(), "433444");
        textEditorPage.pressEnterOnElement(textEditorPage.getColorInputField());
        assertEquals(textEditorPage.getChosenColorValue(), "rgba(67, 52, 68, 1)", "color not set correctly");
    }

    @Test
    public void contextMenuTest() {
        TextEditorPage textEditorPage = new TextEditorPage();
        textEditorPage.rightClick(textEditorPage.getCanvasContainer());
        assertTrue(textEditorPage.isContextMenuDisplayed(), "Context menu is not dispayed");
    }
}
