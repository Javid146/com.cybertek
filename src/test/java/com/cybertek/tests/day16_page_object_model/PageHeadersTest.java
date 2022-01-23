package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.VyTrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PageHeadersTest extends VyTrackTestBase {


   @Test
   public void dashboardPageTest(){

       test = report.createTest("Dashboard page title test");

        String username =ConfigurationReader.getProperty("driver_username");
        String password =ConfigurationReader.getProperty("driver_password");
        test.info("log in to app");
        loginPage.LoginPage(username,password);

       wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, "Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        test.info("verifying page header text");
        assertEquals(actual, "Quick Launchpad");
        test.pass("Pass: Dashboard page title test");
    }


    @Test
    public void fleetVehiclesTest()throws InterruptedException{

        test = report.createTest("Vehicles page title test");

        String username =ConfigurationReader.getProperty("driver_username");
        String password =ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        test.info("Username: "+username);
        test.info("Password: "+password);
        loginPage.LoginPage(username,password);
        //change page
        test.info("Going to Fleet page -> Vehicles");
         Thread.sleep(4000);
         dashboardPage.fleet.click();
         wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        //Thread.sleep(5000);
         dashboardPage.vehicles.click();

         wait.until(ExpectedConditions.textToBePresentInElement(vehiclePage.pageHeader, "Cars"));
         test.pass("Pass: Vehicles page title test");
         String actual = vehiclePage.pageHeader.getText();
         assertEquals(actual, "Cars");


    }
}
