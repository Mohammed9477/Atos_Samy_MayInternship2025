package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.ElementHelper;
import utilities.driverManger.DriverManger;

public class PaymentDetails {

    WebDriver driver;

    By cardNameField = By.name("name_on_card");
    By cardNumberField = By.name("card_number");
    By cvcField = By.xpath("//input[@name='cvc']");
    By expiryMonthField = By.xpath("//input[@class='form-control card-expiry-month']");
    By expiryYearField = By.xpath("//input[@name='expiry_year']");
    By submitButton = By.xpath("//button[@class='form-control btn btn-primary submit-button']");
    By paymentSuccessMessage = By.xpath("//h2[@data-qa='order-placed']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public PaymentDetails() {
        this.driver = DriverManger.getDriver();
    }

    public void enterCardName(String cardName) {
        ElementHelper.sendText(cardName,driver, cardNameField);
    }

    public void enterCardNumber(String cardNumber) {
        ElementHelper.sendText(cardNumber, driver, cardNumberField);
    }

    public void enterCVC(String cvc) {
        ElementHelper.sendText(cvc, driver, cvcField);
    }
    public void enterExpiryMonth(String month) {
        ElementHelper.sendText(month, driver, expiryMonthField);
    }
    public void enterExpiryYear(String year) {
        ElementHelper.sendText(year, driver, expiryYearField);
    }
    public void clickSubmitButton() {
        ElementHelper.click(driver, submitButton);
    }
    public void clickContinueButton() {
        ElementHelper.click(driver, continueButton);
    }

    // assert success message or payment confirmation
    public void assertPaymentSuccess() {
        //AssertionHelper.assertUrl(driver,URL);
        AssertionHelper.assertEqual(ElementHelper.getText(driver,paymentSuccessMessage), "ORDER PLACED!");
    }
}
