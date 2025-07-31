import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.SignInPage;
import org.testng.annotations.*;
import utilities.datareaders.DataProviderUtils;
import utilities.extentReport.ExtentReportListener;
import utilities.commonHelper.Global;

@Listeners(ExtentReportListener.class)
public class SignIn extends BaseTest {
    HomePage homepage;
    SignInPage signInPage;
    Global global ;
    ContactUsPage contactUsPage;
    @BeforeTest
    public void setup() {
        homepage = new HomePage();
        signInPage = new SignInPage();
        global=Global.getInstance();
        contactUsPage = new ContactUsPage();
    }
//    @Test(testName = "login")
//    public void signIn() {
//        homepage.clickOnSignup_LoginBtn();
//        signInPage.enterEmail(global.getEmail());
//        signInPage.enterPassword(global.getPassword());
//        signInPage.clickLoginBtn();
//    }


    @Test(dataProvider = "signinData", dataProviderClass = DataProviderUtils.class)
    public void signInWithDataProvider(String email, String password) {

        homepage.clickOnSignup_LoginBtn();

        signInPage.enterEmail(email);

        signInPage.enterPassword(password);

        signInPage.clickLoginBtn();

    }

}
