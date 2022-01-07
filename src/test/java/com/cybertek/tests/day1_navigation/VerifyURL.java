package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURL {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/ca/");
        driver.manage().window().fullscreen();

        /*for title we use getTitle();
        * for current URL we use getCurrentUrl(); method*/
        String expectedURL = "https://www.etsy.com/ca/";
        String actualURL = driver.getCurrentUrl();
    if(expectedURL.equals(actualURL)){
        System.out.println("PASS");}
    else{ System.out.println("FAILURE");
        System.out.println("I expected: "+ expectedURL);
        System.out.println("The actual URL is: "+actualURL);
    }






    }
}
