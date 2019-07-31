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

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;
public class Events {


    //Create driver object to do the tasks
    WebDriver driver;

    //locator relative xpath(Tag and atribute)
    String emailButton = "//input[@name='login']";

    // xpart for password button
    String passwordButton = "//input[@name='password']";

    // xpath for login button
    String loginBox = "//button[@type='submit']";

    // xpath for events button
    String eventsButton = "//a[@class='oe_menu_toggler']//span[@class='oe_menu_text'][contains(text(),'Events')]";

    // xpath for Events categories button
    String EventsCategories= "//span[contains(text(),'Event Categories')]";

    // xpath for Click button button
    String ClickButton="//tr[1]//td[1]//div[1]//input[1]";

    // xpath for Action Button button
    String ActionButton="//button[contains(text(),'Action')]";

    // xpath for Delete button
    String DeleteButton="//a[contains(text(),'Delete')]";

    // xpath for ok button
    String OkButton="//span[contains(text(),'Ok')]";

    // xpath for create button
    String CreateButton ="//button[@class='btn btn-primary btn-sm o_list_button_add']";

    // xpath for EventCategory button
    String EventCategory ="//input[@name='name']";

    // xpath for Save button
    String SaveButton="//button[@class='btn btn-primary btn-sm o_form_button_save']";


    //@BeforeMethod- Method with this annotation will always run once before every test method
    @BeforeMethod

    public void login() {

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

        //demo purpose wait
        SeleniumUtils.waitPlease(2);

        //input password Button
        driver.findElement(By.xpath(passwordButton)).sendKeys("eventscrmmanager");
        SeleniumUtils.waitPlease(2);
    }

    @Test (description = "Events manager should be able to delete an event" )
    public void test1() {

        //click the login box module
        driver.findElement(By.xpath(loginBox)).click();
        SeleniumUtils.waitPlease(2);

        //click the events button module
        driver.findElement(By.xpath(eventsButton)).click();
        SeleniumUtils.waitPlease(2);

        //click the events categories module
        driver.findElement(By.xpath(EventsCategories)).click();
        SeleniumUtils.waitPlease(2);

        // click on the check box
        driver.findElement(By.xpath(ClickButton)).click();
        SeleniumUtils.waitPlease(2);

        // click on the action button
        driver.findElement(By.xpath(ActionButton)).click();
        SeleniumUtils.waitPlease(2);

        //click on the delete button
        driver.findElement(By.xpath(DeleteButton)).click();
        SeleniumUtils.waitPlease(2);

        //click on the ok button
        driver.findElement(By.xpath(OkButton)).click();
        SeleniumUtils.waitPlease(2);
    }

    @Test (description = "Event manager should be able ta add event")
     public void test2(){

        //click the login box module
        driver.findElement(By.xpath(loginBox)).click();
        SeleniumUtils.waitPlease(2);

        //click the login events module
        driver.findElement(By.xpath(eventsButton)).click();
        SeleniumUtils.waitPlease(2);

        //click the loginEvents Categories module
        driver.findElement(By.xpath(EventsCategories)).click();
        SeleniumUtils.waitPlease(2);

        //click the Create Button module
        driver.findElement(By.xpath(CreateButton)).click();
        SeleniumUtils.waitPlease(2);

        //click the Event Category module
        driver.findElement(By.xpath(EventCategory)).sendKeys("Dinner");
        SeleniumUtils.waitPlease(2);

        //click the Save Button module
        driver.findElement(By.xpath(SaveButton)).click();
        SeleniumUtils.waitPlease(2);

        //Actual event name
       String Actual = driver.findElement(By.xpath("//span[@name='name']")).getText();

       //Actual event name printed
        System.out.println("Actual: "+Actual);

        //Expected event name
        String Expected = "Dinner";

        //Expected event name printed
        System.out.println("Expected: "+Expected);


        //verify that actual and expected
        Assert.assertEquals(Actual,Expected);
    }


     //After method performs after every method.
    @AfterMethod

    public void TearDown(){

        //exit/close all open tabs, / webpages
        driver.quit();
    }
}


