package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptExecutorTest {
    WebDriver driver;
    JavascriptExecutor jse;//////////////////////////////////////////////////////////////////////////////////////////////

    /*JavascriptExecutor is a class that is used to inject */
    @BeforeMethod
    public void beforeMethod(){
        this.driver = WebDriverFactory.getDriver("chrome");
        jse = (JavascriptExecutor) driver; /////////////////////////////////////////////////////////////////////////////////////////////////
       }

    @AfterMethod
    public void afterTest(){driver.quit(); }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        Thread.sleep(4000);
        jse.executeScript("arguments[0].scrollIntoView(true);", link);//TODO this is used to scroll the page down//////////////////////////////////////////////////////////////
        Thread.sleep(4000);
    }


    @Test
    public void sendKeysWithJs(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement input = driver.findElement(By.cssSelector("Input[disabled]"));

        String text = "hi world";

        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')", input);//TODO this is used to set string value for attribute//////////////////////////////////////////////////////////////




    }



}
