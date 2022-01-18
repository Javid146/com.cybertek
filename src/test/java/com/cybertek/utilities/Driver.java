package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    /*Let's say there is a new class and it needs a browser. So it gets browser from TestBase
     * And TestBase gets the driver from Driver class.
     * Driver class actually created the driver.
     * Driver gets browser version from configuration.properties file using ConfigurationReader class*/
    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            //get the driver from properties file
          String browser = ConfigurationReader.getProperty("browser");

          switch (browser){
              case "chrome":
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
                  break;
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver = new FirefoxDriver(); }

        }
        return driver;
    }


}
