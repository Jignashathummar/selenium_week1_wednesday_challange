package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * 1. RegisterTest
 * 2. LoginTest
 * 3. SaleTest
 * 3. Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userSholdRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Emai
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    Random random = new Random();
    int x;

    public RegisterTest() {
        this.x = this.random.nextInt(900);
    }

    String baseUrl = "https://magento.softwaretestingboard.com/";

    //Opening Browser
    @Before
    public void open() {
        openBrowser(baseUrl);
    }

    /**
     * 1. verifyThatSignInPageDisplay
     * * click on the ‘Create an Account’ link
     * * Verify the text ‘Create New Customer Account’
     */
    @Test
    public void verifyThatSignInPageDisplay() {
        driver.findElement(By.xpath("//header[@class='page-header']//a[text()='Create an Account']")).click();
        WebElement getCreateAnAccount = driver.findElement(By.xpath("//span[text()='Create New Customer Account']"));
        Assert.assertEquals("Create New Customer Account", getCreateAnAccount.getText());
    }

    //2. userSholdRegisterAccountSuccessfully
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // click on the ‘Create an Account’ link
        driver.findElement(By.xpath("//header[@class='page-header']//a[text()='Create an Account']")).click();
        //Enter First name
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Prime");
        //Enter Last name
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Test");
        // Enter Email
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(new CharSequence[]{"prime" + this.x + "@gmail.com"});
        System.out.println(x);
        // Enter Password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Prime@123");
        //Enter Confirm Password
        driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("Prime@123");
        // Click on Create an Account button
        driver.findElement(By.xpath("//button[@type='submit']//span[text()='Create an Account']")).click();
        //Verify the text 'Thank you for
        //registering with Main Website Store.’
        WebElement getCreatedAnAccount = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.']"));
        Assert.assertEquals("Thank you for registering with Main Website Store.", getCreatedAnAccount.getText());
        //Click on down aero near Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@class='action switch' and @type='button']")).click();
        //* Click on Sign Out link
        driver.findElement(By.xpath("//li[@class='customer-welcome active']//a[contains(text(),'Sign Out')]")).click();
        //* Verify the text ‘You are signed out’
        WebElement getSignedOutText = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']"));
        Assert.assertEquals("You are signed out", getSignedOutText.getText());

    }

    //Closing Browser
    @After
    public void close() {
        closeBrowser();
    }
}
