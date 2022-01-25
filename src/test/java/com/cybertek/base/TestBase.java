package com.cybertek.base;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    protected WebDriver driver;

    /*Let's say there is a new class and it needs a browser. So it gets browser from TestBase
     * And TestBase gets the driver from Driver class.
     * Driver class actually created the driver.
     * Driver gets browser version from configuration.properties file using ConfigurationReader class*/
    @BeforeMethod
    public void setUpTest(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(6000);
        Driver.closeDriver();

    }



}
