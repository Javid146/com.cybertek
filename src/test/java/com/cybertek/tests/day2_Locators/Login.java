package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Store Manager50");

        WebElement Username = driver.findElement(By.id("prependedInput2"));
        Username.sendKeys("turkic14");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();// clicks the login button on webpage








    }
}
