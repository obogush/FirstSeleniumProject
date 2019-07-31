package VyTrackProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFunctionality {

    public static void main(String[] args) throws Exception {
        //create webdriver manager to access google chrome
        WebDriverManager.chromedriver().setup();
        //create a ChromeDriver object to utilize available methods
        WebDriver driver = new ChromeDriver();
        //make the page maximized when it opens
        driver.manage().window().maximize();
        //use driver object to go to vyTrack login page
        driver.get("http://qa2.vytrack.com/user/login") ;
        //stay on page for 3 seconds, use Thread.sleep method
        //don't forget to use try/catch or "throws Exception after method signature
        Thread.sleep(3000)  ;
        //Create three elements; one for UserNameBox, one for passwordBox and submitButton
        //We will implement two locaters. They are "id" and "name" locaters.
        WebElement UserNameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        WebElement submitButton= driver.findElement(By.id("_submit"));

        //first let's type in the user name in the "Username" field
        UserNameBox.sendKeys("user39");
        //second let's type in the password in the "Password" field
        passwordBox.sendKeys("UserUser123");
        //stay on the page for another two seconds
        Thread.sleep(2000);

        //click on "LOG IN" button to access vyTrack modules
        submitButton.submit();

        //create a text if login is unsuccessful
        String failed = "Invalid user name or password.";


        //Create if else condition to check whether the title of webpage is correct
        if(driver.getTitle().contains("Dashboard"))

        {
            //print out if title equals expected result: Dashboard
            System.out.println("passed\nExpected "+ driver.getTitle());
        }

        //print out the failed message that was stored above
        else
        {

         // print out the failed mesage that was stored above
            System.out.println(failed);

         //print out the actual result that failed the verification
            System.out.println("Actual: "+ driver.getTitle());

        }


        driver.close();

    }

}
