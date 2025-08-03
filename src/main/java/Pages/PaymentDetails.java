package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.ElementHelper;
import utilities.config.LoadProperties;
import utilities.driverManger.DriverManger;

public class PaymentDetails {

    WebDriver driver;

    By cardOnName = By.name("name_on_card");
    By cardOnNumber = By.name("card_number");
    By cvcOnCard = By.xpath("//input[@name='cvc']");
    By cardExpiryMonth = By.xpath("//input[@class='form-control card-expiry-month']");
    By cardExpiryYear = By.xpath("//input[@name='expiry_year']");
    By submitButton = By.xpath("//button[@class='form-control btn btn-primary submit-button']");
    By paymentSuccessMessage = By.xpath("//h2[@data-qa='order-placed']");
    By downloadInvoiceButton = By.xpath("//a[@class='btn btn-default check_out']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    static String downloadDirectory = LoadProperties.downloadPath;
    public PaymentDetails() {
        this.driver = DriverManger.getDriver();
    }

    public void enterCardName(String cardName) {
        ElementHelper.sendText(cardName,driver, cardOnName);
    }

    public void enterCardNumber(String cardNumber) {
        ElementHelper.sendText(cardNumber, driver, cardOnNumber);
    }

    public void enterCVC(String cvc) {
        ElementHelper.sendText(cvc, driver, cvcOnCard);
    }
    public void enterExpiryMonth(String month) {
        ElementHelper.sendText(month, driver, cardExpiryMonth);
    }
    public void enterExpiryYear(String year) {
        ElementHelper.sendText(year, driver, cardExpiryYear);
    }
    public void clickSubmitButton() {
        ElementHelper.click(driver, submitButton);
    }
    public void clickDownloadInvoiceButton() {
        ElementHelper.click(driver, downloadInvoiceButton);
    }
    public void clickContinueButton() {
        ElementHelper.click(driver, continueButton);
    }

    // assert success message or payment confirmation
    public void assertPaymentSuccess() {
        //AssertionHelper.assertUrl(driver,URL);
        AssertionHelper.assertEqual(ElementHelper.getText(driver,paymentSuccessMessage), "ORDER PLACED!");
    }

    public void assertInvoiceDownloaded(String fileName) {
        AssertionHelper.assertFileExists(fileName,".txt", 10,false);
        AssertionHelper.assertFileExists(fileName);
    }

}
