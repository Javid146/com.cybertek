package com.cybertek.base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclePage extends VytrackPageBase{

    public VehiclePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //header for dashboard and fleet
   // @FindBy(className ="oro-subtitle")
    //public WebElement pageHeader;
}
