package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathPractice {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");

//locate elements and attributes with relative xpath
        WebElement Relativeusername = driver.findElement(By.xpath("//input[@type='text']"));

        WebElement Relativepassw = driver.findElement(By.xpath("//input[@type='password']"));
//locate elements and attributes with relative xpath
        //<input type="text" name="username">
        WebElement absoluteUsername = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div/input"));
        //<input type="password" name="password">
        absoluteUsername.sendKeys("mammadli@gmail.com");

        WebElement absolutePassw = driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[2]/div[1]/input"));
        absolutePassw.sendKeys("turkic14");
        WebElement clickbtn = driver.findElement(By.id("wooden_spoon"));
        clickbtn.click();

    }
}
