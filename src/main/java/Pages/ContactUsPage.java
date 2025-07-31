package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.ElementHelper;
import utilities.driverManger.DriverManger;

public class ContactUsPage {

    WebDriver driver;
    Alert alert;


    By contactNameField = By.xpath("//input[@data-qa='name']");
    By contactEmailField = By.xpath("//input[@data-qa='email']");
    By contactSubjectField = By.xpath("//input[@data-qa='subject']");
    By contactMessageField = By.xpath("//textarea[@data-qa='message']");
    By submitButton = By.xpath("//input[@data-qa='submit-button']");
    By chooseFileButton = By.xpath("//input[@name='upload-file']");
    By contactSuccessMessage = By.xpath("//div[@class='status alert alert-success']");
    By homeBtn = By.xpath("//a[@class='btn btn-success']");
//    public ContactUsPage(WebDriver driver) {
//        this.driver = driver;
//    }

    public ContactUsPage() {
        this.driver = DriverManger.getDriver();
    }
    public void enterContactName(String name) {
        ElementHelper.sendText(name, driver, contactNameField);
    }
    public void enterContactEmail(String email) {
        ElementHelper.sendText(email, driver, contactEmailField);
    }
    public void enterContactSubject(String subject) {
        ElementHelper.sendText(subject, driver, contactSubjectField);
    }
    public void enterContactMessage(String message) {
        ElementHelper.sendText(message, driver, contactMessageField);
    }
    public void clickSubmitButton() {
        ElementHelper.click(driver, submitButton);
    }
    // Accept the alert
    public void acceptAlert(){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    public void uploadFile(String filePath) {
        ElementHelper.sendText(filePath, driver, chooseFileButton);
    }

    public void clickOnHomeButton() {
        ElementHelper.click(driver, homeBtn);
    }

    public void assertContactSuccessMessage(String expectedSuccessMessage){
        AssertionHelper.assertEqual(ElementHelper.getText(driver, contactSuccessMessage), expectedSuccessMessage);
    }



}
