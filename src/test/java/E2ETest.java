import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.driverManger.DriverManger;
import Pages.*;

public class E2ETest extends BaseTest{

    // Instances of existing test logic classes
    SignIn signInTest;
    AddToCart addToCartTest;
    CartCheckout cartCheckoutTest;
    ContactUs contactUsTest;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetails productDetails;

    public E2ETest() {
        // Initialize instances of existing test logic classes
        homePage = new HomePage();
        this.signInTest = new SignIn();
        this.addToCartTest = new AddToCart();
        this.cartCheckoutTest = new CartCheckout();
        this.contactUsTest = new ContactUs();
        //this.homePage = new HomePage();
        this.productsPage = new ProductsPage();
        this.productDetails = new ProductDetails();
    }
    @Test
    public void fullUserJourneyE2E() {
        // Call test methods from existing test classes
        signInTest.signInWithDataProvider("samy97@gmail.com", "123456");
        //addToCartTest.addToCart();
        //cartCheckoutTest.CheckOutPayment();
        contactUsTest.contactUs("Samy","samy97@gmail.com","Feedback","This is a test message for feedback.");
    }


}
