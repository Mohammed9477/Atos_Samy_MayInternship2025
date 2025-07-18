package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Main {
  public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.automationexercise.com/");
    driver.manage().window().maximize();

    WebElement Signup_Login = driver.findElement(By.linkText("Signup / Login"));
    Signup_Login.click();

    WebElement Signup_EmailAddress = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
    Signup_EmailAddress.sendKeys("rofidaAraby123@gmail.com");


    WebElement Signup_Name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
    Signup_Name.sendKeys("Maged");

    WebElement SignupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
    SignupButton.click();

    //***********************************************************//


    WebElement radioButton = driver.findElement(By.id("id_gender1"));
    radioButton.click();

    WebElement Password = driver.findElement(By.xpath("//input[@data-qa='password']"));
    Password.sendKeys("P@ssw0rd");
    Select DaysDropDown = new Select(driver.findElement(By.id("days")));
    DaysDropDown.selectByIndex(0);
    Select MonthDropDown = new Select(driver.findElement(By.id("months")));
    MonthDropDown.selectByValue("4");
    Select YearDropDown = new Select(driver.findElement(By.id("years")));
    YearDropDown.selectByVisibleText("2019");

    WebElement newsLetter = driver.findElement(By.xpath("//label[text()='Sign up for our newsletter!']"));
    newsLetter.click();

    WebElement specialOffer = driver.findElement(By.xpath("//label[text()='Receive special offers from our partners!']"));
    specialOffer.click();
    WebElement SignUp_Firstname = driver.findElement(By.xpath("//input[@data-qa='first_name']"));
    SignUp_Firstname.sendKeys("Moamen");
    WebElement SignUp_Lastname = driver.findElement(By.xpath("//input[@data-qa='last_name']"));
    SignUp_Lastname.sendKeys("Radwa");

    WebElement Signup_address = driver.findElement(By.id("address1"));
    Signup_address.sendKeys("nasr st, ca. 2, atos, 0");

    Select country = new Select(driver.findElement(By.id("country")));
    country.selectByValue("United States");

    WebElement SignUp_State = driver.findElement(By.xpath("//input[@data-qa='state']"));
    SignUp_State.sendKeys("Cairo");
    WebElement SignUp_City = driver.findElement(By.xpath("//input[@data-qa='city']"));
    SignUp_City.sendKeys("Quesna");

    WebElement ZipCode = driver.findElement(By.xpath("//input[@data-qa='zipcode']"));
    ZipCode.sendKeys("020");
    WebElement mobile = driver.findElement(By.xpath("//input[@data-qa='mobile_number']"));
    mobile.sendKeys("01154789536");
    WebElement createAccount = driver.findElement(By.xpath("//button[text()='Create Account']"));
    createAccount.click();

    String ActualURL=driver.getCurrentUrl();
    String ExpectedURL = "https://www.automationexercise.com/account_created";



        //driver.quit();
    }
}