package com.cybertek.tests.OfficeHours;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class July_29PageObjectModelDemo {
    //AmazonPage page = new AmazonPage();

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.navigate().to("https://www.amazon.com");
        driver.get("https://www.amazon.com");
        WebElement searchItem = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchItem.sendKeys("iPhone" + Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("iPhone"));
    }

    @Test
    public void test2() {

        Driver.getDriver().get("https://www.amazon.com");

        //page.searchTerm.sendKeys("iPhone" + Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("iPhone"));




    }

}
