package com.cybertek.tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cybertek.utilities.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeTagname  {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        //here we will execute our tests
        //we will create separate method for every test
        test1();

    }
    //TASK: FIND ALL BUTTONS, put them in the list, and click on them one by one.

    public static void test1() throws Exception {
        driver.manage().window().maximize();
        //selenium will waitPlease up to 30 seconds to find element
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //HOW TO FIND ALL BUTTONS?
        //we use findElements to find multiple elements
        //Then, we have to store them in the list

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Size: "+buttons.size());// to get how many elements in the list

        for (WebElement button : buttons) {
            System.out.println(button.getText());
            button.click();
            Thread.sleep(1000);
        }
        driver.close();
    }

}




