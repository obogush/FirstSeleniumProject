package com.cybertek.tests.day14_properties_singleton_driver_test_base;

import com.cybertek.pages.vytrack.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class LoginTests {
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTests1(){
        //DEMO for reading credentials from properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.login(username, password);
    }
}