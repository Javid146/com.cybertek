package com.cybertek.tests.day16_page_object_model;

import com.cybertek.pages.LoginPage;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginpage;

@BeforeMethod
public void setUp(){
    loginpage = new LoginPage();
    driver.get(ConfigurationReader.getProperty("url2"));

}


    /*in this TEST WE GET ALL THE VARIABLES FROM loginPage CLASS IN pages PACKAGE*/
    @Test
    public void wrongUsername(){
        loginpage.username.sendKeys("SalesManager");
        loginpage.password.sendKeys("UserUser123");
        loginpage.login.click();

        String actual = loginpage.errorMessage.getText();
        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginpage.errorMessage.isDisplayed());
        }


        @Test
    public void wrongPasswordTest(){
        loginpage.username.sendKeys("SalesManager110");
        loginpage.password.sendKeys("LC");
        loginpage.login.click();

        String actual = loginpage.errorMessage.getText();
        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginpage.errorMessage.isDisplayed());

        }


}
