package Pages;

import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.driverManger.DriverManger;

public class LogoutPage {

    WebDriver driver;

    public LogoutPage() {
        this.driver = DriverManger.getDriver();
    }

    public void logout() {
        HomePage homePage = new HomePage();
        homePage.clickOnLogoutBtn();
    }
    public void assertLogout(String URL){
        AssertionHelper.assertUrl(driver, URL);
    }
}
