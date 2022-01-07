package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
         driver.get("https://cybertekschool.okta.com/");
        //write email in text box in cybertekschool
        /*1. First find ID (locator) of text box in webpage*/
        WebElement emailBox = driver.findElement(By.id("okta-signin-username"));//My first web element (web element is interface)
        //type your email in text box of cybertek webpage
        emailBox.sendKeys("mammadli.javid15@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("okta-signin-password"));
        //or driver.findElement(By.id("okta-signin-password")).sendKeys("Turkic14!/?");
        passwordBox.sendKeys("Turkic14!/?");
    }
}
