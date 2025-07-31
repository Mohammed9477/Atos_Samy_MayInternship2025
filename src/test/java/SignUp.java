import Pages.HomePage;
import Pages.SignUpPage;

import org.testng.annotations.*;
import utilities.datareaders.DataProviderUtils;
import utilities.extentReport.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class SignUp extends BaseTest{
    HomePage homepage;
    SignUpPage signUpPage;
    @BeforeTest
    public void setup(){
        homepage=new HomePage();
        signUpPage =new SignUpPage();
    }

    @Test(dataProvider = "signUpData", dataProviderClass = DataProviderUtils.class)
    public void signUpWithDataProvider(String name,String email,String title,String password,
                       String day, String month, String year, String firstName,
                       String lastName, String address, String country, String state,
                       String city, String zipcode) {

        homepage.clickOnSignup_LoginBtn();
        signUpPage.enterName(name)
                .enterEmail(email)
                .clickSignupButton()
                .enterTitle(title)
                .enterPassword(password)
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
                .enterZipcode(zipcode)
                .enterMobileNumber()
                .clickCreateAccountBtn();

        signUpPage.assertAccountCreatedSuccessfully(
                "https://www.automationexercise.com/account_created",
                "ACCOUNT CREATED!"
        );
    }
}
