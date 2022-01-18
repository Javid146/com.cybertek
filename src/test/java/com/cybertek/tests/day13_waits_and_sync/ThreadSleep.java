package com.cybertek.tests.day13_waits_and_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleep {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){ driver.quit();}

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        Thread.sleep(16000);
        //TODO in CSS # MEANS ID, AS . MEANS CLASS///////////////////////////////////////////////////////////////////////////////
        WebElement message = driver.findElement(By.cssSelector("#finish>h4"));//ID WITH FINISH> ITS CHILD 'H4'
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());

    }












}
