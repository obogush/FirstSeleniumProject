package com.cybertek.tests.OfficeHours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class July_5 {
    public static void main(String[] args) {

        /*
        Today's topic:
                    1. Locators
                    2. WebLEment
                    3. Methods of WebElement

         */

        /*
            locators:   created by using By abstract class
                    1. id(str)
                    2. xpath.
                    3. cssSelector (faster than xpath)
                    4. name
                    5. classname
                    6. tagname
                    7. linktext
                    8. partiallinktext

                    all of them are static return method==> By

                    xpath formula:
                           basic:  //tagname[ @Attribute=' value of the attribute ']
                                 if it's not uniqe:   //tagname[ @Attribute=' value of the attribute ' and  @SecondAttribute='value'  and .. ]

                         webelemnt with visible text:  //tagname[contains(text(),'partial visible text')]

                                 <button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_0_y"> Sign Up </button>

                                 //button[@type='submit' and @name='websubmit' ]

                                 //button[contains(text(), 'Sign Up' )]



         */
        // id locator:
           By idLocator =   By.id("id goes here");
       // name locator:
              By nameLocator    =  By.name("name goes here");

                    /*
                    <button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_0_y">Sign Up</button>
                     */

            By CssLocator = By.cssSelector("css goes here");

            By xpathLocator = By.xpath(" xpath goes here");
                //       #u_0_y



        /*
            WebElement: interface
                  findElement(): we use it when the locator is unique,  returns a single elemnt
                  findElements():  we use it when the locator is not unique, returns list of Elements

         */

        WebDriver driver= new ChromeDriver();


        // webElement with name locator:  name needs to be unique
            WebElement name = driver.findElement(nameLocator);

            // if the locator is not unique:
                List<WebElement> all= driver.findElements (By.name("name"));



        /*
        Methods of WebELemnt:

            click(): clicks the webelement
            sendKeys(): used for entering inputs
            gettext(): returns the linktext of the webElement as String
            isDisplayed(); returns boolean, to verify if the WebElement is displayed or not
            isSelected(); returns boolean, used to verify check box or Radio buttons are selected or not
            getTagname(): returns the tagname of the WebElement.
            submit(): Keys.Enter
            isEnabled();    returns boolean expression, used to verify buttons
            getAttribute(Str): returns the value of the given attribute
            clear(): to clear the input box or search box



         */

        name.click();
        name.sendKeys(" inputs goes here");
        String str=name.getText();

        name.getTagName();

        /*
        <button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_0_y">Sign Up</button>
         */
        String str3 = name.getAttribute("type"); // ===> submi

        /*
        Test cases:
                1. verify the URL and Title
                2. verify the radio buttons can be selected ( by clicking radio button or visible text)
                3. verify the SignUp button is enabled
                4. veiry that warning is displayed

                break till: 7: 20
         */



    }



}
