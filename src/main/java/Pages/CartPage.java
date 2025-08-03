package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.ElementHelper;
import utilities.driverManger.DriverManger;

public class CartPage {

    WebDriver driver;
    By cart_page = By.linkText("Cart");
    By checkout_btn = By.linkText("Proceed To Checkout");
    By product_Name =   By.xpath("//table[@id='cart_info_table']//tr[1]//td[@class='cart_description']/h4/a");
    By productQuantity = By.xpath("//table[@id='cart_info_table']//tr[1]//td[@class='cart_quantity']/button");
    By commentTextBox = By.xpath("//textarea[@class='form-control']");
    By placeOrder_btn = By.linkText("Place Order");


    public CartPage(){
        this.driver= DriverManger.getDriver();
    }

    public void navigateToCartPage(){
        ElementHelper.click(driver,cart_page);
    }

    public void clickOnCheckout(){
        ElementHelper.click(driver,checkout_btn);
    }

    public void enterComment(String comment){
        ElementHelper.sendText(comment,driver,commentTextBox);
    }

    public void clickOnPlaceOrder(){
        ElementHelper.click(driver,placeOrder_btn);
    }

    public void assertProductNameAdded(String productName){
        ElementHelper.scrollToElement(driver,product_Name);
        String ActualName = ElementHelper.getText(driver,product_Name).replaceAll("\\s+", " ").trim();
        AssertionHelper.assertEqual(ActualName,productName);
    }

    public void assertProductQuantity(String quantity){
        ElementHelper.scrollToElement(driver,productQuantity);
        String ActualQuantity = ElementHelper.getText(driver,productQuantity).replaceAll("\\s+", " ").trim();
        AssertionHelper.assertEqual(ActualQuantity,quantity);
    }




}
