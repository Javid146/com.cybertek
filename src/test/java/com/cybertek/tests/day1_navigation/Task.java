package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String URL = "https://www.google.ca/";
        String expectedURL = "https://www.etsy.com/ca/c/clothing-and-shoes?ref=catnav-10923";
        driver.get(URL);
        driver.navigate().to(expectedURL);
        driver.navigate().back();











    }
}
