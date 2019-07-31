package com.cybertek.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.BrowserFactory;

public class WayFairPractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws InterruptedException {
        test();
    }


    public static void test() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        driver.findElement(By.id("search-query")).sendKeys("Decorative Large Wooden Spoon Decor, Wood Spoon, Kitchen Decor, Spoon Decor, Farmhouse Spoon, Rustic Spoon, Gift, Spoon, kitchen Decoration");

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@class='v2-listing-card__shop']")).click();

        Thread.sleep(2000);

//last xpath seems not working, we need to test it carefully next time.
        //driver.findElement(By.xpath("//button[@*='btn-text']")).click();
        driver.close();
    }

}
