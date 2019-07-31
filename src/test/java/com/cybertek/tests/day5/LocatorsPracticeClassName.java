package com.cybertek.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cybertek.utilities.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeClassName {

        static WebDriver driver = BrowserFactory.getDriver("chrome");
        //got ot practice.cybertekschool.com
        //assignment: Get a list of examples  based on the class name list-group-item
        //then use for loop to get every element and print the text of this element.
        //check how many elements you will get, it must be 48.
        public static void main(String[] args) {
            test1();
        }

        public static void test1(){
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/");
            List<WebElement> examples = driver.findElements(By.className("list-group-item"));
            for(WebElement element: examples){
                System.out.println(element.getText());
            }
            driver.close();
        }

    }

