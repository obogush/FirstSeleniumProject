package com.cybertek.tests.OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp1(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        library.sleep(3);

    }


    @Test(
            priority = 2 ,
            description = "Verify the URL",
            timeOut =  4000,
            enabled = false
    )
    public void test1(){
       String URL = driver.getCurrentUrl();
        System.out.println( URL.contains("www.facebook.com") );

    }

    @Test( priority = -100,
            description = "Verify the Title",
    timeOut = 4000,
            enabled = false
    )
    public void test2(){

       String title =  driver.getTitle().toLowerCase();
        System.out.println( title.contains("facebook") );

    }
/*
tagname: button
linktext: Sign Up
//button[text()='Sign Up']
// button[contains(text(),'Sign')]
 */

        @Test(description = "Verify Sign up Button")
        public void TestCase4(){
            WebElement SignUp = driver.findElement(By.xpath("//button[text()='Sign Up']"));
            System.out.println( SignUp.isEnabled());

        }




    @AfterMethod
    public void teardown(){
        library.sleep(2.5);
        driver.quit();

    }





}
