package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class multiTest {
    static WebDriver driver;

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
        return sdf.format(date);
    }

    public static void selectFromDropDownVisibleText(By by, String textvalue) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(textvalue);

    }

    public static void selectFromDropDownindexvalue(By by, int indexvalue) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(indexvalue);

    }

    public static void waitForClickable(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForVisible(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    @BeforeMethod

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test

    public void userShouldBeAbleToRegisterSuccessfully() {
        //Click on register button
        clickOnElement(By.xpath("//a[@href=\"/register?returnUrl=%2F\"]"));
        //Click Radio Button
        clickOnElement(By.id("gender-female"));
        //type first name
        typeText(By.id("FirstName"), "Prarthiiii");
        //type LastName
        typeText(By.id("LastName"), "Patel");
        //Select Day from DropDown
        selectFromDropDownindexvalue(By.xpath("//select[@name='DateOfBirthDay']"), 6);
        //Select Month from DropDown
        selectFromDropDownVisibleText(By.xpath("//select[@name='DateOfBirthMonth']"), "September");
        //Select Year from DropDown
        selectFromDropDownVisibleText(By.xpath("//select[@name='DateOfBirthYear']"), "1996");
        //type email
        String email = "PrarthiZalavadiya+" + currentTimeStamp() + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(email);
        //newsletter
        clickOnElement(By.id("Newsletter"));
        //Password
        typeText(By.xpath("//input[@id='Password']"), "1234test");
        //ConfirmPassword
        typeText(By.id("ConfirmPassword"), "1234test");
        //Click Register Button
        clickOnElement(By.id("register-button"));
        //get text= registration completed
        String actualRegisterCompletionMessage = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        String expectedRegisterCompletedMessage = "Your registration completed";
        Assert.assertTrue(actualRegisterCompletionMessage.equals(expectedRegisterCompletedMessage));

    }

    @Test

    public void userShouldBeAbleToNavigateToDesktop() {

            //click on computers
            clickOnElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a"));
            //click on desktop
            clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/h2/a"));
            //Verifying that user has  navigated to the correct page "Desktops"
            String actualRegisterCompletionMessage = getTextFromElement(By.xpath("//div[@class=\"center-2\"]/div/div[1]/h1"));
            String expectedRegisterCompletedMessage = "Desktops";
            Assert.assertTrue(actualRegisterCompletionMessage.equals(expectedRegisterCompletedMessage));
    }

    @Test

    public void userShouldBeAbleToReferProductToFriend(){
        //Click on register button
        clickOnElement(By.xpath("//a[@href=\"/register?returnUrl=%2F\"]"));
        //Click Radio Button
        clickOnElement(By.id("gender-female"));
        //type first name
        typeText(By.id("FirstName"), "Prarthiiii");
        //type LastName
        typeText(By.id("LastName"), "Patel");
        //Select Day from DropDown
        selectFromDropDownindexvalue(By.xpath("//select[@name='DateOfBirthDay']"), 6);
        //Select Month from DropDown
        selectFromDropDownVisibleText(By.xpath("//select[@name='DateOfBirthMonth']"), "September");
        //Select Year from DropDown
        selectFromDropDownVisibleText(By.xpath("//select[@name='DateOfBirthYear']"), "1996");
        //type email
        String email = "PrarthiZalavadiya+" + currentTimeStamp() + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(email);
        //newsletter
        clickOnElement(By.id("Newsletter"));
        //Password
        typeText(By.xpath("//input[@id='Password']"), "1234test");
        //ConfirmPassword
        typeText(By.id("ConfirmPassword"), "1234test");
        //Click Register Button
        clickOnElement(By.id("register-button"));
        //click on computers
        clickOnElement(By.xpath("//div[@class=\"header-menu\"]/ul[1]/li[1]/a"));
        //click on desktop
        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/h2/a"));
        //click on add to chart button
        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/button[@class=\"button-2 product-box-add-to-cart-button\"]"));
        //click on Email Friend Button
        clickOnElement(By.xpath("//div[@class=\"overview-buttons\"]//div[3]"));
        //Input Friends Email
        typeText(By.id("FriendEmail"),"Prarthi+" +currentTimeStamp() + "@gmail.com");
        //Input your email address
       // typeText(By.id("YourEmailAddress"),"prarthizalava@gmail.com");
        //Input Personal Message
        typeText(By.id("PersonalMessage"),"Awesome Product!!!");
        //click send email Button
        clickOnElement(By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]"));
        // Verifying the message sent success
        String actualRegisterCompletionMessage = getTextFromElement(By.xpath("//div[@class=\"page email-a-friend-page\"]/div[2]/div[2]"));
        String expectedRegisterCompletedMessage = "Your message has been sent.";
        Assert.assertTrue(actualRegisterCompletionMessage.equals(expectedRegisterCompletedMessage));

    }

    @AfterTest
    public void closeBrowser() {
      driver.close();
  }
}


