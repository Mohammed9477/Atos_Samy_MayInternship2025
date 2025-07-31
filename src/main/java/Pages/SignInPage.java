package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

import java.time.Duration;

public class SignInPage {
    WebDriver driver;
    Alert alert;

    By SignIn_EmailAddress = By.xpath("//input[@data-qa='login-email']");
    By SignIn_Password = By.xpath("//input[@data-qa='login-password']");

    By LoginBtn = By.xpath("//button[text()='Login']");

    public SignInPage()
    {
        this.driver = DriverManger.getDriver();
    }

    public void enterEmail(String Email) {
        ElementHelper.sendText(Email,driver,SignIn_EmailAddress);
    }

    public void enterPassword(String password) {

        ElementHelper.sendText(password,driver,SignIn_Password);
    }
    public void clickLoginBtn() {
        ElementHelper.click(driver,LoginBtn);
    }
    // Accept the alert
    public void acceptAlert(){
        alert = driver.switchTo().alert();
        // add a wait to ensure the alert is present explicitly
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
