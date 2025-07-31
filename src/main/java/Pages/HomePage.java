package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class HomePage {
    WebDriver driver ;
    By Signup_Login = By.linkText("Signup / Login");
    By Product_page = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    By contactUsBtn = By.xpath("//a[@href='/contact_us']");
    By logoutBtn = By.xpath("//a[@href='/logout']");

    public HomePage() {
        this.driver = DriverManger.getDriver();
    }
    public void clickOnSignup_LoginBtn(){
        ElementHelper.click(driver,Signup_Login);
    }
    public void clickOnContactUs() {
        ElementHelper.click(driver, contactUsBtn);
    }
    public void clickOnLogoutBtn() {
        ElementHelper.click(driver, logoutBtn);
    }
    public void clickOnProductPage()  {
        ElementHelper.click(driver,Product_page);
    }
}
