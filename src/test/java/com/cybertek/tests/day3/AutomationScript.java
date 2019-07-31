package com.cybertek.tests.day3;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScript {

    public static void main(String[] args) throws InterruptedException {
        //public static void main(String[] args) throws Exception {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("http://amazon.com");

            Thread.sleep(2000);

            WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
            inputBox.sendKeys("laptop");

            WebElement submitButton = driver.findElement(By.name("field-keywords"));
            Thread.sleep(2000);
            submitButton.submit();

            driver.navigate().back();
            WebElement inputBox2 = driver.findElement(By.id("twotabsearchtextbox"));
            WebElement submitButton2 = driver.findElement(By.id("nav-search-submit-text"));
            inputBox2.sendKeys("java book");


            submitButton2.submit();
            Thread.sleep(3000);
        driver.navigate().back();
        Faker faker = new Faker();
        WebElement inputBox3 = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement submitButton3 = driver.findElement(By.id("nav-search-submit-text"));
        String name= faker.funnyName().name();


        inputBox3.sendKeys(name);
        submitButton3.submit();
        Thread.sleep(2000);

            driver.close();

        }
    }