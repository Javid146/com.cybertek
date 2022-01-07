package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerify {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String expectedTitle = "Etsy - store for all";
        String etsyTitle = "https://www.etsy.com/ca/";

        if(expectedTitle.equals(etsyTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("We failed again");
            System.out.println(expectedTitle+" vs "+etsyTitle);
        }






    }
}
