package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.ElementHelper;
import utilities.driverManger.DriverManger;

import java.util.List;

public class ProductsPage {
    WebDriver driver ;

    By Search_textBox = By.xpath("//input[@id='search_product']");
    By Search_icon = By.xpath("//button[@id='submit_search']");
    By productTitles = By.cssSelector(".product-overlay .overlay-content p");
    By productCards = By.cssSelector(".product-image-wrapper");

    public ProductsPage(){
        this.driver= DriverManger.getDriver();
    }

    public void enterSearchKeyword(String keyword){
        ElementHelper.sendText(keyword,driver,Search_textBox);
    }

    public void clickOnSubmitSearch(){
        ElementHelper.click(driver,Search_icon);
    }

    public void viewSpecificProductDetails(String productName){
        By viewProductDetails = RelativeLocator.with(By.linkText("View Product")).below(By.xpath("//*[text()='"+ productName + "']"));
        ElementHelper.scrollToElement(driver,viewProductDetails);
        ElementHelper.click(driver,viewProductDetails);
    }
    public void assertSearchResultsContain(String keyword) {
        AssertionHelper.assertAllElementsContainKeyword(driver,productCards, productTitles, keyword);
    }

}
