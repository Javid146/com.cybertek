package com.cybertek.tests.day13_waits_and_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    //@AfterMethod
    public void tearDown(){ driver.quit();}

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        /*Implicit wait is a conditional method which will not throw exception if it cannot find the element, It will keep
        * trying to locate the element. TODO It only works with findElement.
        * it does not matter where you put this method, it still works for last method even if it is located at beginning of class.
        * This method stops (no matter how much time you put) as soon as the element is found
        * So if you put 10
        * seconds, driver will make a call to browser and look for the element for 10 seconds. TODO IT IS CALLED POLLING */
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);//TODO IMPLICIT WAIT METHOD

        //TODO in CSS # MEANS ID, AS . (dot) MEANS CLASS
        WebElement message = driver.findElement(By.cssSelector("#finish>h4"));//ID WITH FINISH> ITS CHILD 'H4'
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());

        //here we do and load same page and procedures to see how implicit wait works
        //despite we had to find 2 elements in 2 pages, there was no any noSuchElement exception
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        message = driver.findElement(By.cssSelector("#finish>h4"));

        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.getText());




    }
}






