package com.cybertek.tests.day14_test_base_props_driver;

import java.util.Properties;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;

public class PropertiesExample {

    @Test
    public void test(){

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

//Properties --> class from java that saves key value combinations
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "http://practice.cybertek.com");

        String browser = properties.getProperty("browser");
        System.out.println("browser name = " + browser);

        //get browser/url from properties file
        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String purl = ConfigurationReader.getProperty("url");
        System.out.println("purl = " + purl);

    }


@Test
public void test2(){
      //create driver object from WebDriverFactory class
    WebDriver driver = WebDriverFactory.getDriver("chrome");

     //get webpage from ConfigurationReader class
    String url = ConfigurationReader.getProperty("url");
    driver.get(url);
    driver.close();

    String str = Singleton.getInstance();
    System.out.println(str);
}

public void test3(){

    String str = Singleton.getInstance();
    System.out.println(str);
}



}