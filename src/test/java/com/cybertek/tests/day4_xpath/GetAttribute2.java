package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

       WebElement site = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        System.out.println(site.getAttribute("href"));
       /* or this method instead of above:
        WebElement tag = driver.findElement(By.tagName("a"));
        System.out.println(tag.getAttribute("href"));*/

        WebElement exmple2 = driver.findElement(By.partialLinkText("Example 2"));
        System.out.println(exmple2.getText());






    }
}
