package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import com.cybertek.base.VyTrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCalendarEventTests extends VyTrackTestBase {

    @Test
    public void allDayEventRadioTest(){
        //login to your profile
        loginPage.LoginPage(ConfigurationReader.getProperty("driver_username"),
                            ConfigurationReader.getProperty("driver_password"));
        //go to calendar events page
        driver.get("https://app.vytrack.com/calendar/event/create");
        //verify element from calendarEventPage class
        Assert.assertFalse(calendarEvntPg.allDayEventCheckBox.isSelected());
    }

    @Test
    public void repeatCheckBoxTest(){
        loginPage.LoginPage(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        //go to calendar events page
        driver.get("https://app.vytrack.com/calendar/event/create");
        Assert.assertFalse(calendarEvntPg.repeatheckbox.isSelected());


    }
}
