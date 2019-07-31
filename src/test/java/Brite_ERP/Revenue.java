package Brite_ERP;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Revenue {

    //Create driver object to do the tasks
    WebDriver driver;

    //locator relative xpath(Tag and atribute)
    String emailButton = "//input[@id='login']";

    // xpart for password button
    String passwordButton = "//input[@id='password']";

    //// xpart for crmbutton
    String crmbutton = "//span[contains(text(),'CRM')]";

    //xpath for list Button
    String ListButton = "//button[@aria-label='list']";

    // xpath for expected revenue
    String expectedRevenue = "//tr[2]//td[9]";

    //css for pivot
    String pivot = "button[aria-label=pivot]";

    //css for newPivot element
    String newPivotLocatar = "td[class=o_pivot_header_cell_closed]";

    //xpath for
    String pivotOpportunityElement="//a[.='Opportunity']";


    //css selector for expectedValue in pivot view
    String pivotExpectedRevenue = "tr:nth-child(5) > td:nth-child(2)"; //css selector for expectedValue in pivot view



    @BeforeMethod
    public void setup() {

        // Setup for webdriver manager to access chrome driver
        WebDriverManager.chromedriver().setup();

        //Assign driver to chrome
        driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //if fail after 7 seconds, it throws exception
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        // lets get to the webpage
        driver.get("http://34.220.250.213/web/login");


        //input user login
        driver.findElement(By.xpath(emailButton)).sendKeys("eventscrmmanager36@info.com");

        //input password login
        driver.findElement(By.xpath(passwordButton)).sendKeys("eventscrmmanager", Keys.ENTER);


    }

    @Test
    public void Test1() {
        //click on Crm Element
        driver.findElement(By.xpath(crmbutton)).click();
        SeleniumUtils.waitPlease(3);

        //click on list element
        driver.findElement(By.xpath(ListButton)).click();

        //demo purpose wait
        SeleniumUtils.waitPlease(3);

        //get the value of the second opporunity
        String expectedValue = driver.findElement(By.xpath(expectedRevenue)).getText();


        // System.out.println(expectedValue); //retrieved 100.00

        // click on pivot table
        driver.findElement(By.cssSelector(pivot)).click();

        //demo purpose wait
        SeleniumUtils.waitPlease(3);

        // click on newPivot
        driver.findElement(By.cssSelector(newPivotLocatar)).click();

        //demo purpose wait
        SeleniumUtils.waitPlease(3);

        //click on "Opportunity, open table view
        driver.findElement(By.xpath(pivotOpportunityElement)).click();

        //demo purpose wait
        SeleniumUtils.waitPlease(3);

        //get value of same opportunity from pivot view
        String expectedValuePivot = driver.findElement(By.cssSelector(pivotExpectedRevenue)).getText();

        Assert.assertEquals(expectedValue,expectedValuePivot);







    }
}
