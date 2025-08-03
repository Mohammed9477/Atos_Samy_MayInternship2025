package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.ElementHelper;
import utilities.driverManger.DriverManger;

public class ProductDetails {
    WebDriver driver;
    By addToCartButton = By.xpath("//button[@type='button']");
    By quantity = By.id("quantity");
    By Added_msg = By.xpath("//*[text()='Your product has been added to cart.']");
    By continueShopping_btn = By.xpath("//button[@class='btn btn-success close-modal btn-block']");



    public ProductDetails(){
        this.driver = DriverManger.getDriver();
    }

    public void assertProductName(String productName){
        By ProductName = By.xpath("//div[@class='product-information']//h2");
        ElementHelper.scrollToElement(driver,ProductName);
        String ActualName = ElementHelper.getText(driver,ProductName).replaceAll("\\s+", " ").trim();
        AssertionHelper.assertEqual(ActualName,productName);
    }

    public void enterQuantity(String productQuantity){
        //ElementHelper.clearInput(driver,quantity);
        ElementHelper.sendText(productQuantity,driver,quantity);
    }
    public void verifySearchResults(String keyword) {
        boolean allMatch = ElementHelper.verifyElementsContainNormalizedText(driver, By.cssSelector(".product-title"), keyword);
        assert allMatch : "One or more search results do not match: " + keyword;
    }

    public void clickOnAddToCart(){
        ElementHelper.click(driver,addToCartButton);
    }

    public void assertAddedMessage(){
        String Actual = ElementHelper.getText(driver,Added_msg);
        AssertionHelper.assertEqual(Actual,"Your product has been added to cart.");
    }

    public void clickContinueShopping(){
        ElementHelper.click(driver,continueShopping_btn);
    }




}
