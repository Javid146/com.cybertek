package com.cybertek.tests.day16_page_object_model;

import com.cybertek.pages.LoginPage;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PositiveLoginTests extends TestBase {
    LoginPage Login;

    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        Login = new LoginPage();
        driver.get(ConfigurationReader.getProperty("url2"));
         this.wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void loginAsDrivers(){
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        Login.LoginPage(username,password);


        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actual = driver.getTitle();

        assertEquals(actual, "Dashboard");
    }

     @Test
    public void loginAsSalesManager(){
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");
         Login.LoginPage(username,password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actual =driver.getTitle();
        assertEquals(actual, "Dashboard");
    }

    @Test
    public void LoginAsStoreManager(){
        String user = ConfigurationReader.getProperty("store_manager_username");
        String pass = ConfigurationReader.getProperty("store_manager_password");
        Login.LoginPage(user,pass);

        wait.until(ExpectedConditions.titleIs("Dashboard"));
        assertEquals(driver.getTitle(), "Dashboard");
    }

}
