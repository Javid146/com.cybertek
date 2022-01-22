package com.cybertek.tests.day16_page_object_model;

import com.cybertek.base.VyTrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PageHeadersTest extends VyTrackTestBase {


   @Test
   public void dashboardPageTest(){

        String username =ConfigurationReader.getProperty("driver_username");
       String password =ConfigurationReader.getProperty("driver_password");
       loginPage.LoginPage(username,password);


       wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, "Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        assertEquals(actual, "Quick Launchpad");
    }


    @Test
    public void fleetVehiclesTest()throws InterruptedException{
        String username =ConfigurationReader.getProperty("driver_username");
        String password =ConfigurationReader.getProperty("driver_password");
        loginPage.LoginPage(username,password);

        //change page
         Thread.sleep(4000);
         dashboardPage.fleet.click();
         wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        //Thread.sleep(5000);
         dashboardPage.vehicles.click();

         wait.until(ExpectedConditions.textToBePresentInElement(vehiclePage.pageHeader, "Cars"));

         String actual = vehiclePage.pageHeader.getText();
         assertEquals(actual, "Cars");


    }
}
