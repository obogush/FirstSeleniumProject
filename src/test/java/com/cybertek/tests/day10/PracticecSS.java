package com.cybertek.tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticecSS {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/registration_form");
    }

    @Test
    public void test1() {
        Select select = new Select(driver.findElement(By.cssSelector("[name='department']")));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }


    @Test
    public void test2(){
        WebElement elem = driver.findElement(By.cssSelector("[class='form-control selectpicker']"));

        Select select = new Select(elem);

        select.selectByValue("TO");

       // Select select = new Select(driver.findElement(By.cssSelector("[name='department']")));
        //System.out.println("")

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
