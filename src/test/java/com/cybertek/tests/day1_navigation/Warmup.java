package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Warmup {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String bookitPage = "https://cybertek-reservation-api-docs.herokuapp.com/#introduction";
        String expectedTitle = "Bookit login";

       /* if(bookitPage.equals(expectedTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("actual Bookit page: "+bookitPage);
            driver.get(bookitPage);}*/
        driver.get(bookitPage);
    if(bookitPage.contains("cybertek-reservation")){
        System.out.println("Titles are similar.");
    }else{
        System.out.println("Titles are far more different!");
    }




    }
}
