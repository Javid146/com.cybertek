package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        //gets the website
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        //finds element with partial text and assigns to WebElement CybertekSchool
       WebElement CybertekSchool = driver.findElement(By.partialLinkText("Cybertek"));

       //turns partial text above into String, because we cannot print WebElement
        String partialLink = CybertekSchool.getText();
        System.out.println(partialLink);




    }
}
