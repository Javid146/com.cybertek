package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {
    public static void main(String[] args) {

        //binary the driver and browsers
        WebDriverManager.chromedriver().setup();

        // WebDriver object -> Interface
        WebDriver driver = new ChromeDriver();

        //open Google homepage by using get(); takes time to load
       // driver.get("https://www.google.com");

        //open a webpage: navigate().to();  loads right away
        //driver.navigate().to("https://www.google.com");


        //get back to previous webpage: navigate().back();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();

        //navigate().forward()
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().forward();


        //        driver.navigate().refresh(); JUST TO REFRESH THE PAGE


    }
}
