import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetails;
import Pages.ProductsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.datareaders.DataProviderUtils;

public class AddToCart extends BaseTest{
    //WebDriver driver;
    HomePage homePage;
    ProductDetails productDetails;
    CartPage cartPage;
    ProductsPage productsPage;


    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage();
        productDetails = new ProductDetails();
        cartPage = new CartPage();
        productsPage = new ProductsPage();
    }
//@Test(dependsOnMethods = {"SignIn.signIn"})
    @Test(dataProvider= "productData", dataProviderClass = DataProviderUtils.class)
    public void addToCart(String searchKeyword, String firstProductName, String fP_quantity,String secondProductName) {
        // add first product
        homePage.clickOnProductPage();
        productsPage.enterSearchKeyword(searchKeyword);
        productsPage.clickOnSubmitSearch();
        productsPage.assertSearchResultsContain(searchKeyword);
        productsPage.viewSpecificProductDetails(firstProductName);
        productDetails.assertProductName(firstProductName);
        productDetails.enterQuantity(fP_quantity);
        productDetails.clickOnAddToCart();
        productDetails.assertAddedMessage();
        productDetails.clickContinueShopping();

        // add second product
        homePage.clickOnProductPage();
        productsPage.viewSpecificProductDetails(secondProductName);
        productDetails.assertProductName(secondProductName);
        productDetails.clickOnAddToCart();
        productDetails.assertAddedMessage();
        productDetails.clickContinueShopping();

        // navigate to cart and assert products
        cartPage.navigateToCartPage();
        cartPage.assertProductNameAdded(firstProductName);
        cartPage.assertProductQuantity(fP_quantity);

    }


}
