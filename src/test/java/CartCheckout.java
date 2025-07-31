import Pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.datareaders.DataProviderUtils;

public class CartCheckout extends BaseTest{
    //WebDriver driver;
    HomePage homePage;
    PaymentDetails paymentDetails;
    CartPage cartPage;
    ProductDetails productDetails;
    ProductsPage productsPage;

    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage();
        paymentDetails = new PaymentDetails();
        cartPage = new CartPage();
        productDetails = new ProductDetails();
        productsPage = new ProductsPage();
    }

    @Test(dataProvider = "paymentData", dataProviderClass = DataProviderUtils.class)
    public void CheckOutPayment(String comment, String cardName, String cardNumber, String cvc, String expiryMonth, String expiryYear) {

        //cartPage.navigateToCartPage();
        cartPage.clickOnCheckout();
        cartPage.enterComment(comment);
        cartPage.clickOnPlaceOrder();
        paymentDetails.enterCardName(cardName);
        paymentDetails.enterCardNumber(cardNumber);
        paymentDetails.enterCVC(cvc);
        paymentDetails.enterExpiryMonth(expiryMonth);
        paymentDetails.enterExpiryYear(expiryYear);
        paymentDetails.clickSubmitButton();
        paymentDetails.assertPaymentSuccess();
        paymentDetails.clickContinueButton();
    }
}
