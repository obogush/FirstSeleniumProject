package com.cybertek.tests.OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomateFaceBook {


    /*
        Test cases:
                1. verify the URL and Title  ( done)
                2. verify the radio buttons can be selected ( by clicking radio button or visible text)
                3. verify the SignUp button is enabled
                4. veiry that warning is displayed  HW

                break till: 7: 20
         */


    public static void main(String[] args) {
        Test3();
    }

    public static void Test1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   // opens the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        // excepted conditon:  titile should have facebook,  URL should have facebook.com

        boolean title =  driver.getTitle().contains("Facebook");
        boolean URL = driver.getCurrentUrl().equals("https://www.facebook.com/");

        System.out.println(title);
        System.out.println(URL);

        driver.quit();

    }

    public static void Test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   // opens the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // if the element is located in 2 seocnds , implicity wait does not wait for the remaining 8 seconds

                // Thread.sleep(10000);

        driver.get("https://www.facebook.com");

        /*
        <input type="radio" name="sex" value="1" id="u_0_8">

        //input[@type='radio' and  @value='1']

         */

        List<WebElement> allRadioButton = driver.findElements(By.xpath("//input[@type='radio']")); // all radio buttons' webelemnts

            WebElement FemaleRadioButton = allRadioButton.get(0);
            WebElement MaleRadioButton =  allRadioButton.get(1);
            WebElement custom = allRadioButton.get(2);

                 FemaleRadioButton.click();
               boolean A =  FemaleRadioButton.isSelected();
               library.sleep(3);

        MaleRadioButton.click();
        boolean B = MaleRadioButton.isSelected();
        library.sleep(3);

        custom.click();
        boolean C = custom.isSelected();
        library.sleep(3);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);


        // visible text of the WbeElement: Female, Male, Custom
         //         female visible text:   //*[contains(text(),'Female')]      if the webelement has linktext or visible text, we can give * for tagname to write xpath without looking at HTML
        //           male visible text:  //*[contains(text(),'Male')]


        //     custom:    //*[contains(text(),'Custom')]   3 matching

            WebElement customText= driver.findElements(By.xpath("//*[contains(text(),'Custom')]")).get(0);
            WebElement femaleText = driver.findElement(By.xpath("//*[contains(text(),'Female')]"));
            WebElement maleText = driver.findElement(By.xpath("//*[contains(text(),'Male')]"));



            femaleText.click();
            boolean D = FemaleRadioButton.isSelected();
        library.sleep(3);

        maleText.click();
        boolean E = MaleRadioButton.isSelected();
        library.sleep(3);

        customText.click();
        boolean F = custom.isSelected();


        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        library.sleep(3);


        driver.quit();





    }

    public static void Test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   // opens the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");


        WebElement signUp = driver.findElement(By.name("websubmit"));
        System.out.println(signUp.isEnabled());
        driver.quit();

    }

}
