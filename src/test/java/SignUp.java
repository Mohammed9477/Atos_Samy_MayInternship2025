import Pages.HomePage;
import Pages.SignUpPage;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import utilities.ExtentReport.ExtentReportListener;


@Listeners(ExtentReportListener.class)
public class SignUp extends BaseTest {
    HomePage homepage;
    SignUpPage signUpPage;

    @BeforeTest
    public void setup() {
        homepage = new HomePage();
        signUpPage = new SignUpPage();
    }


    @Test(dataProvider = "usersData", dataProviderClass = utilities.TestDataProvider.class)
    public void signUp(String title, String day, String month, String year, String firstName, String lastName, String address, String country, String state, String city, String zip) {

        homepage.clickOnSignup_LoginBtn();

        signUpPage.enterName(firstName)
                .enterEmail()
                .clickSignupButton()
                .enterTitle(title)
                .enterPassword()
                .chooseDays(day)
                .chooseMonth(month)
                .chooseYear(year)
                .checkNewsletter()
                .checkSpecialOffer()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterAddress(address)
                .selectCountry(country)
                .enterState(state)
                .enterCity(city)
                .enterZipcode(zip)
                .enterMobileNumber()
                .clickCreateAccountBtn();

        /* Test case Assertions
        * first way
        *         String ActualMessage = signUpPage.returnActualAccountCreatedMessage();
       AssertionHelper.assertEqual( ActualMessage , "Account Created!");
       AssertionHelper.assertUrl(DriverManger.getDriver(), "https://www.automationexercise.com/account_created");
        */
// second way call assertion method from business class .

        signUpPage.assertAccountCreatedSuccessfully(
                "https://www.automationexercise.com/account_created",
                "ACCOUNT CREATED!"
        );
        signUpPage.clickContinueAfterAccountCreated();
        homepage.clickLogout();
        homepage.clickOnSignup_LoginBtn();
    }

    /*@AfterMethod
    public void afterMethod() {

        homepage.clickLogout();
    }*/
}


