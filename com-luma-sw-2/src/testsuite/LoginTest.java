package testsuite;
/**
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    //open Browser
    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    //userShouldLoginSuccessfullyWithValid
    //Credentials()
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        //Enter valid Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prime521@gmail.com");
        //Enter valid Password
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Prime@123");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
        //* Verify the ‘Welcome’ text is display
        WebElement getWelcomeMessage = driver.findElement(By.xpath(("//span[@class='logged-in'])[1]")));
        Assert.assertEquals("Welcome, Prime Test!", getWelcomeMessage.getText());
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        //Enter valid Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prime1@gmail.com");
        //Enter valid Password
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Prime@123");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
        //Verify the error message ‘The account sign-in was
        //incorrect or your account is disabled temporarily. Please wait and try again
        //later.’
        WebElement getTextInccorect = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", getTextInccorect.getText());

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Click on ‘Sign In’ link
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']")).click();
        //Enter valid Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prime521@gmail.com");
        //Enter valid Password
        driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Prime@123");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
        //* Verify the ‘Welcome’ text is display
        WebElement getWelcomeMessage = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in']"));
        Assert.assertEquals("Welcome, Prime Test!", getWelcomeMessage.getText());
        // Click on down aero near Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@class='action switch' and @type='button']")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("//li[@class='customer-welcome active']//a[contains(text(),'Sign Out')]")).click();
        //Verify the text ‘You are signed out’
        WebElement getSignedOutText = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']"));
        Assert.assertEquals("You are signed out", getSignedOutText.getText());
    }

    //Close Browser
    public void close() {
        closeBrowser();
    }

}
