package VyTrackProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPracticeCyberTek {
    public static void main(String[] args) throws Exception {
        //create webdriver manager to access google chrome
        WebDriverManager.chromedriver().setup();

        //create a ChromeDriver object to utilize available methods
        WebDriver driver = new ChromeDriver();

        //make the page maximized when it opens
        driver.manage().window().maximize();

        //use driver object to go to vyTrack login page
        driver.get("http://practice.cybertekschool.com/login");

        //stay on page for 3 seconds, use Thread.sleep method
        Thread.sleep(3000);

        //Create three elements; one for userNameBox, one for passwordBox and submitButton
        //We will implement two locaters. They are "id" and "name" locaters.
        WebElement userNameBox = driver.findElement(By.name("storemanagerusername"));
        WebElement passwordBox = driver.findElement(By.name("storemanagerpassword"));
        WebElement submitButton = driver.findElement(By.id("wooden_spoon"));

        //first let's type in the user name in the "Username" field
        userNameBox.sendKeys("Zlmblt");
        //second let's type in the password in the "Password" field
        passwordBox.sendKeys("98765");

        //stay on the page for another two seconds
        Thread.sleep(2000);

        //click on "LOG IN" button to access website modules
        submitButton.click();



        WebElement confirmationLogged = driver.findElement(By.id("flash-messages"));
        WebElement confirmationNOTlogged = driver.findElement(By.id("flash"));

        //I try to find out how to setup my if condition
        // If I search using id locator, look for "flash", it will print a message with method getText();
        // Then I will look in the console to copy it into if condition.
        //this print statement was to test a condition, commented out now, no further use.
        //System.out.println(confirmationNOTlogged.getText());


        //Actual : User logged in; test failed!!!
        //Expected: User cannot log in; test passed!!!
        // Create if else condition to first print " Test passsed; and some message
        if(confirmationNOTlogged.getText().contains("Your username is invalid!")){
            System.out.println("Test Passed; user should not be able to login with invalid user name and password");

        }
        else{

            System.out.println("Test Failed: "+confirmationLogged.getText());
           
        }

        driver.close();
    }
}