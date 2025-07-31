import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.datareaders.DataProviderUtils;
import utilities.extentReport.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class ContactUs extends BaseTest{
    HomePage homepage;
    ContactUsPage contactUsPage;

    @BeforeTest
    public void setup() {
        homepage = new HomePage();
        contactUsPage = new ContactUsPage();
    }

    @Test(dataProvider = "contactusData", dataProviderClass = DataProviderUtils.class)
    public void contactUs(String name, String email, String subject, String message) {
        homepage.clickOnContactUs();
        contactUsPage.enterContactName(name);
        contactUsPage.enterContactEmail(email);
        contactUsPage.enterContactSubject(subject);
        contactUsPage.enterContactMessage(message);
        contactUsPage.clickSubmitButton();
        contactUsPage.acceptAlert();
        contactUsPage.assertContactSuccessMessage("Success! Your details have been submitted successfully.");
        contactUsPage.clickOnHomeButton();
    }
}
