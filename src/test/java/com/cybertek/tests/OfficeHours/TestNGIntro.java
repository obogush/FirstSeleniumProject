package com.cybertek.tests.OfficeHours;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class TestNGIntro {
    private WebDriver driver; // because we will use it only inside thi class

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test (priority = 1)
    public void openEtsyTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Etsy")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.etsy.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 2)
    public void openGoogleTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Google")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.google.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority = 5)
    public void openYahooTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Yahoo")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.yahoo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test (priority =4)
    public void openFacebookTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Facebook")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.facebook.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority = 3)
    public void openAmazonTest(){
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        SeleniumUtils.waitPlease(2);
        String expectedURL = "https://www.amazon.com/";
        Set<String> windows = driver.getWindowHandles();
        for(String w: windows){
            if(!currentWindow.equals(w)){
                driver.switchTo().window(w);
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
