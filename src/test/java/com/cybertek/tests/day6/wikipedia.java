package com.cybertek.tests.day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class wikipedia {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys("selenium webdriver");
        search.click();
        driver.findElement(By.linkText("\"Selenium (software)\" ")).click();
        driver.getCurrentUrl();

        if (driver.getCurrentUrl().endsWith("x")) {

            System.out.println("passsed");

        } else {

            System.out.println("failed");
        }

    }
}