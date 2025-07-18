import Pages.HomePage;
import Pages.SignUpPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class SignUp extends BaseTest{
    HomePage homepage;
    SignUpPage signUpPage;
    @BeforeTest
    public void setup(){
        homepage=new HomePage();
        signUpPage =new SignUpPage();
    }
    @Test
    public void signUp() {

        /* Test Case steps */
        homepage.clickOnSignup_LoginBtn();
        signUpPage.enterName().enterEmail().
                clickSignupButton().
                enterTitle("Mrs").
                enterPassword().
                chooseDays("1").chooseMonth("May").chooseYear("2019").
                checkNewsletter().checkSpecialOffer().
                enterFirstName("ro").enterLastName("Araby").enterAddress("Address").
                selectCountry("India").enterState("cairo").enterCity("z").
                enterZipcode("020").enterMobileNumber().clickCreateAccountBtn();

        /* Test case Assertions
        * first way
        *         String ActualMessage = signUpPage.returnActualAccountCreatedMessage();
       AssertionHelper.assertEqual( ActualMessage , "Account Created!");
       AssertionHelper.assertUrl(DriverManger.getDriver(), "https://www.automationexercise.com/account_created");
        */
       // second way call assertion method from business class .

        signUpPage.assertAccountCreatedSuccessfully("https://www.automationexercise.com/account_created","ACCOUNT CREATED!");


    }

}
