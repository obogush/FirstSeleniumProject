package Brite_ERP;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Revenue1 {

    WebDriver driver;
    String username = "//input[@id='login']";
    String password = "//input[@id='password']";
    String crmbutton= "//span[contains(text(),'CRM')]";
    String listViewButton ="//button[@aria-label='list']";
    String expectedRevenue = "//tr[2]//td[9]";
    String pivot = "button[aria-label=pivot]"; //css selector
    String pivotNew = "td[class=o_pivot_header_cell_closed]"; //css for New button
    String opportunityLocator = "//a[.='Opportunity']";
    String pivotExpectedRevenue = "tr:nth-child(5) > td:nth-child(2)"; //css selector for expectedValue in pivot view
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
        driver.findElement(By.xpath(username)).sendKeys("eventscrmmanager36@info.com");
        driver.findElement(By.xpath(password)).sendKeys("eventscrmmanager", Keys.ENTER);
    }
    @Test
    public void test1(){
        //after landing page, click crm button to see opportunities
        driver.findElement(By.xpath(crmbutton)).click();
        SeleniumUtils.waitPlease(3);
        //go to list view
        driver.findElement(By.xpath(listViewButton)).click();
        // go to get expected value of the 2nd opportunity
        String expectedValue = driver.findElement(By.xpath(expectedRevenue)).getText();
        //System.out.println(expectedValue); retrieves 100.00 for verification
        //click pivot to see table view of the opportunities
        driver.findElement(By.cssSelector(pivot)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector(pivotNew)).click(); // click on NEW element table view opens
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(opportunityLocator)).click(); //click on opportunity element to see table view
        SeleniumUtils.waitPlease(2);
        //get value of the same opportunity in pivot view
        String expectedValuePivot = driver.findElement(By.cssSelector(pivotExpectedRevenue)).getText();
        Assert.assertEquals(expectedValue,expectedValuePivot);
        if(expectedValue.equals(expectedValuePivot)){
            System.out.println("Values are equal!");
        }else{
            System.out.println("Values don't match!");
        }
    }
    @Test
    public void test2(){
        //after landing page, click crm button to see opportunities
        driver.findElement(By.xpath(crmbutton)).click();
        SeleniumUtils.waitPlease(3);
        //click pivot to see table view of the opportunities
        driver.findElement(By.cssSelector(pivot)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector(pivotNew)).click(); // click on NEW element table view opens
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(opportunityLocator)).click(); //click on opportunity element to see table view
        SeleniumUtils.waitPlease(2);
        String value1 = "tr:nth-child(3) > td:nth-child(2)"; //book brand new
        String value2 = "tr:nth-child(4) > td:nth-child(2)"; //book sale
        String value3 = "tr:nth-child(5) > td:nth-child(2)"; //testing
        //get value of the testing, new book, book sale  opportunities in pivot view
        String valueTesting = driver.findElement(By.cssSelector(value3)).getText(); // get value of Testing
        String valueBookNew = driver.findElement(By.cssSelector(value1)).getText(); // get value of Testing
        String valueBookSale = driver.findElement(By.cssSelector(value2)).getText(); // get value of book sale
        double testingValue = Double.valueOf(valueTesting);
        double NewBookValue = Double.valueOf(valueBookNew);
        double BookSaleValue = Double.valueOf(valueBookSale);
        //System.out.println(testingValue+NewBookValue+BookSaleValue); //should print 750.00 for verification purposes
        String totalRevenueLocator = "tr:nth-child(1) > td:nth-child(2)";
        String totalRevenue = driver.findElement(By.cssSelector(totalRevenueLocator)).getText();
        double expected = Double.valueOf(totalRevenue);
        double actual = testingValue+NewBookValue+BookSaleValue;
        String verify = expected == actual ? "Values are equal" : "Value equality failed";
        System.out.println(verify);
    }
    @AfterMethod
    public void shutdown(){
        driver.quit();
    }

}
