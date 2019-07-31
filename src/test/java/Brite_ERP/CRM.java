package Brite_ERP;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CRM {
    /*
    User Story => As a user, when I already created an opportunity in CRM module of Brite ERP application,
            I want to be able to delete it.
    Acceptance Criteria :
            1.Verify that user should be able to see the list view.
            2.Verify that user should be able to delete the opportunity from action drop down list .
     */
    // WebDriver is an interface. It uses abstraction:Hiding implementation hiding locators from tests
    //there is inheritance because I use SeleniumUtils class
    //There is polymorphism when webDriver calls chromedriver




    //Create driver object to do the tasks
    WebDriver driver;// interface it uses abstract

    //locator relative xpath(Tag and atribute)
    String emailButton = "//input[@name='login']";

    // xpath for password button
    String passwordButton = "//input[@name='password']";

    // xpath for login button
    String loginBox = "//button[@type='submit']";





    //@BeforeMethod- Method with this annotation will always run once before every test method

    @BeforeMethod
    public void login() {
        // Setup for webdriver manager to access chrome driver
        WebDriverManager.chromedriver().setup();//web

        //Assign driver to chrome
        driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //I use do implicitly wait because method runs 10 seconds
        //if fail after 10 seconds, it throws exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // lets get to the webpage
        driver.get("http://34.220.250.213/web/login");

        //input user login
        driver.findElement(By.xpath(emailButton)).sendKeys("Lunch_InvoicingManager3@info.com");

        //input password login
        driver.findElement(By.xpath(passwordButton)).sendKeys("LD686gfX24");

        //then click the login button to enter webpage
        driver.findElement(By.xpath(loginBox)).click();

    }

    @Test
    public void Crm(){


        //This is CRM module (relative)
        driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'CRM')]")).click();

        //demo purpose wait
        SeleniumUtils.waitPlease(3);

        // Click the list button to see product in a list view.
        driver.findElement(By.xpath("//button[@aria-label='list']")).click();

        //demo purpose wait
        SeleniumUtils.waitPlease(3);


        //getText() gets total number of products showing in string format
        String listFirst=driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText();

        //Printing the total nmber of the products, before it is deleted
        System.out.println("total products before deletion "+ driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText());

        //Change the string format into integer
        int listNum=Integer.parseInt(listFirst);

        //verify total number is greater than 0
        Assert.assertTrue(listNum>0);

        //Select a checkbox for the product
        driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//input[1]")).click();
        SeleniumUtils.waitPlease(2);

        //Click on the action button to see delete button
        driver.findElement(By.xpath("//button[@data-toggle='dropdown' and contains(text(),'Action')] ")).click();
        SeleniumUtils.waitPlease(2);

        //Click on the delete element
        driver.findElement(By.xpath("//a[@data-index='3']")).click();
        SeleniumUtils.waitPlease(2);

        //Click on the ok element
        driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();
        SeleniumUtils.waitPlease(2);

        //getText() gets total number of products showing in string format
        String listSec=driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText();

        //Printing the total nmber of the products, after it is deleted
        System.out.println("total products after deletion "+driver.findElement(By.xpath("//span[@class='o_pager_limit']")).getText());

        //Change the string format into integer
        int listNum1=Integer.parseInt(listSec);

        //verify total number is not greater than previous total number
        Assert.assertTrue(listNum>listNum1);
    }

        //After method performs after every method.
    @AfterMethod

    public void TearDown(){

        //exit/close all open tabs, / webpages
        driver.quit();
    }



}
