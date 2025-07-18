import Pages.HomePage;
import Pages.SignInPage;
import org.testng.annotations.*;
import utilities.ExtentReport.ExtentReportListener;
import utilities.Global;

@Listeners(ExtentReportListener.class)
public class SignIn extends BaseTest {
    HomePage homepage;
    SignInPage signInPage;
    Global global ;
    @BeforeTest
    public void setup() {
        homepage = new HomePage();
        signInPage = new SignInPage();
        global=Global.getInstance();
    }
    @Test(testName = "login")
    public void signIn() {
        homepage.clickOnSignup_LoginBtn();
        signInPage.enterEmail(global.getEmail());
        signInPage.enterPassword(global.getPassword());
        signInPage.clickLoginBtn();
    }
}
