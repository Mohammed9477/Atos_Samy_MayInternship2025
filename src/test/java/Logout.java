import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.driverManger.DriverManger;

public class Logout extends BaseTest{

    WebDriver driver;
    LogoutPage logoutPage;
    HomePage homePage;
    @BeforeTest
    public void beforeTest(){
        homePage = new HomePage();
        logoutPage = new LogoutPage();
    }
    @Test
    public void logout(){
        logoutPage.logout();
        logoutPage.assertLogout("https://www.automationexercise.com/login");
    }
}
