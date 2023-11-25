package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 5.Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */
public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() throws InterruptedException {

        // Click on sale menu tab
        driver.findElement(By.xpath("//a[@id='ui-id-8']")).click();

        // Click on jackets link on left side under womens category
        driver.findElement(By.linkText("Jackets")).click();

        // verify text jackets
        WebElement getJacket = driver.findElement(By.xpath("//span[@class='base' or @data-ui-id='page-title-wrapper']"));
        Assert.assertEquals("Jackets", getJacket.getText());
       // count the total items displayed on page and print the name of all items
        List<WebElement> item = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Total item : " + item.size());
        System.out.println("-----------------");

        for(WebElement e : item){
            System.out.println(e.getText());
        }
    }

//Close Browser
    @After
    public void tearDown () {
        closeBrowser();
    }
}
