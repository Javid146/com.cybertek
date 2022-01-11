package com.cybertek.tests.day3_locators2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");


        //we need to get value of type attribute.
        //type="text" -> getAttribute("attribute name") method needs to be used.

        //locate username box, username is element. type is attribute of username
        WebElement username = driver.findElement(By.name("username"));

        //<input type="text" name="username"> type is attribute here
        String valueOfType = username.getAttribute("type");
        System.out.println(valueOfType);

        /*with getAttribute():
         * we locate element 1st: findElement():
         * later with that element we find the value of attribute*/
        WebElement login = driver.findElement(By.id("wooden_spoon"));
        String valueOfClass = login.getAttribute("class");
        System.out.println(valueOfClass);
//<div style="text-align: center;">Powered by <a target="_blank" href="https://cybertekschool.com/">Cybertek School</a></div>
// get attribute value
        WebElement text = driver.findElement(By.tagName("h4"));
        String valueOfText = text.getAttribute("class");
        System.out.println(valueOfText);






    }
}
