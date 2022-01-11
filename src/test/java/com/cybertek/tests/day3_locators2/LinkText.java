package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        //LinkText locator does not need to be inspected. just take text of website
        //and paste in By.linkText() method
        WebElement example3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        String textVersionOfexample3 = example3.getText();
        System.out.println(textVersionOfexample3);

        /*difference of linkText and partialLinkText is that the 2nd one can
        * find element with only part of the text of the link*/
        WebElement example3_2 = driver.findElement(By.partialLinkText("Example 3: Element on page"));
        String textVersionOfexample3_2 = example3_2.getText();
        System.out.println(textVersionOfexample3_2);









    }
}
