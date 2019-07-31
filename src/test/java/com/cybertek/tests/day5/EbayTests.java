package com.cybertek.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class EbayTests {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
//        driver.findElement(By.id("gh-ac")).sendKeys("Java Book", Keys.ENTER);
        driver.findElement(By.id("gh-ac")).sendKeys("Java Book");
        driver.findElement(By.id("gh-btn")).click();
        String results = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(results);
        driver.close();

    }
}

