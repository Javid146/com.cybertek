package com.cybertek.tests.day5_more_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //tag, attribute and value
        WebElement buttOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        String text = buttOne.getText();
        System.out.println(text);
        //tag (h3) and sibling tag. h3 and button[2] are siblings
        WebElement butttwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(butttwo.getText());
        //just a sibling tag
        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());
        //tag name and attribute
        WebElement butt4 = driver.findElement(By.xpath("//div/button[4]"));
        System.out.println(butt4.getText());
        //any element with button tag and text button 5 (no attribute)
        WebElement butt5 = driver.findElement(By.xpath("//button[.='Button 5']"));
        System.out.println(butt5.getText());
        WebElement butt6 = driver.findElement(By.xpath("//button[@name='button6']"));
        System.out.println(butt6.getAttribute("innerHTML"));
    }
}
