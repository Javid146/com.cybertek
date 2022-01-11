package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CLickVSSubmit {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mammadli.javid@gmail.com");
        WebElement click = driver.findElement(By.tagName("i"));
        click.submit();
        //driver.get("http://practice.cybertekschool.com/email_sent");

        String expectedURL = "http://practice.cybertekschool.com/email_sent";
                String actualURL = driver.getCurrentUrl();

                if(expectedURL.equals(actualURL)){
                    System.out.println("Test passed");
                }






    }
}
