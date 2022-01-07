package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        /*
        *http://practice.cybertekschool.com/
        *
        *
        * */

        WebDriverManager.chromedriver().setup();// connects browser to driver and sets up browser
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().fullscreen();// page is full screen


        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else{
            System.out.println("Failure");
            System.out.println("I expected "+expectedTitle);
            System.out.println("The Actual title is "+actualTitle);}

        driver.close();
    }
}
