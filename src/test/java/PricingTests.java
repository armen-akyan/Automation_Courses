import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverSetUp;

public class PricingTests {
    @BeforeMethod
    public void setUp(){
        DriverSetUp.getDriver();
    }
    @Test
    public void scrollCarousel() throws InterruptedException {
        PricingPage pricingPage = new PricingPage();
        pricingPage.swipeTestimonials();
    }
}
