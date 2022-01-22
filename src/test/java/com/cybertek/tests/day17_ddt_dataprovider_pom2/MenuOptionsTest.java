package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.base.VyTrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MenuOptionsTest extends VyTrackTestBase {

    @Test
    public void test() throws InterruptedException{
        //open the website by calling username and password
        loginPage.LoginPage(ConfigurationReader.getProperty("driver_username"),
                            ConfigurationReader.getProperty("driver_password"));
        //dropdowns on vytrack website
        dashboardPage.changeMenu("Activities","Calendar Events");

        wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
        assertEquals(driver.getTitle(), "Calendar Events - Activities");
    }

    //DOT test
    @Test(dataProvider = "test-data")
    public void ddtTest(String menu1, String menu2, String expectedTitle) throws InterruptedException {
        //open the website by calling username and password
        loginPage.LoginPage(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        //todo for for menu1 and menu2 and expectedTitle we get info from dataProvider below.
        dashboardPage.changeMenu(menu1, menu2);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));

    }



    @DataProvider (name="test-data")
    public Object [][] getData(){
        return new Object[][]{
                {"Fleet", "Vehicles", "Car"},
                {"Fleet", "Vehicle Costs", "Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events", "Calendar Events - Activities"},
                 {"System", "System Calendars", "System Calendars - System"}
        };
    }

    //login as driver and verify that if driver can see menu options Fleet, Customer, Activities, System
    @Test
    public void testAllOptionsDriver(){
        loginPage.LoginPage(ConfigurationReader.getProperty("driver_username"),
             ConfigurationReader.getProperty("driver_password"));

        List<String> expectedList = Arrays.asList("Fleet", "Customers", "Activities", "System");
        //BrowserUtils class takes webelement list and turns it into String list
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        Assert.assertEquals(expectedList, actualList);
    }

}
