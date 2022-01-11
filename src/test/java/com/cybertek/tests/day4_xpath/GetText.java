package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("mammadli@gmail.com");
        WebElement login = driver.findElement(By.tagName("i"));
        login.click();

        WebElement emailConfirmation = driver.findElement(By.name("confirmation_message"));
        String emailSent = emailConfirmation.getText();
        //after locating you need to print the message
        System.out.println(emailSent);









    }
}
