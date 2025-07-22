package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverManger;
import utilities.ElementHelper;

public class HomePage {
    WebDriver driver ;
    By Signup_Login = By.linkText("Signup / Login");
    By Logout = By.linkText("Logout");

    public HomePage() {
        this.driver = DriverManger.getDriver();
    }
    public void clickOnSignup_LoginBtn(){
        ElementHelper.click(driver,Signup_Login);
    }
    public void clickLogout() {
        ElementHelper.click(driver,Logout); // تأكد من الـ locator
    }
}
