package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {
    /*TODO we do this so not to initialize WebDriver driver before every method*/
    WebDriver driver;

    /*TODO BeforeMethod will execute and launch before all new methods*/
    @BeforeMethod
    public void beforeMethod(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.get("http://practice.cybertekschool.com/radio_buttons"); }

    /*TODO AfterMethod will execute and quit after all new methods*/
    @AfterMethod
    public void AfterMethod(){driver.quit();}


                                    //SELECT BLUE AND VERIFY IT
    @Test
    public void Test1(){
        WebElement blue = driver.findElement(By.id("blue"));
    //TODO prints true if the chosen item is selected in webpage////////////////////////////////////////
        System.out.println(blue.isSelected());
        //TODO verifies if the chosen item is selected in webpage////////////////////////////////////////
        Assert.assertTrue(blue.isSelected());

        //will return false because red is not selected
        WebElement red = driver.findElement(By.id("red"));
        System.out.println("is red selected? "+red.isSelected());

        //TODO verifies if the statement is false. If false it passes
        Assert.assertFalse(red.isSelected());
        //TODO verifies if the statement is TRUE. If TRUE it passes. same as above
        //Assert.assertTrue(red.isSelected());
    }


                                //SELECT RED AND VERIFY IT
    @Test
    public void Test2() throws InterruptedException {
        WebElement red = driver.findElement(By.id("red"));
        Thread.sleep(1000);
        red.click();
        System.out.println("RED SELECTED in second test");
        Assert.assertTrue(red.isSelected());
    }

    //TODO
    @Test
    public void disabledTest() throws InterruptedException{

        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));

        Thread.sleep(2000);
        //TODO CHECKS IS ELEMENT IS INTERACTABLE, ENABLED OR ACTIVE////////////////////////////////
        System.out.println("IS GREEN ENABLED? "+green.isEnabled());
        System.out.println("IS BLACK ENABLED? "+black.isEnabled());

        Assert.assertFalse(green.isEnabled());
        Assert.assertTrue(black.isEnabled());

    }

    @Test
    public void disabledTestWithAttributes() throws InterruptedException{

        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));

        Thread.sleep(2000);
        //TODO CHECKS IF ELEMENT IS INTERACTABLE, ENABLED OR ACTIVE////////////////////////////////
        System.out.println("GREEN: "+green.getAttribute("disabled"));
        System.out.println("black: "+black.getAttribute("disabled"));


        //TODO VERIFIES IF THE value IS equal to NULL. AND VERIFY IF ELEMENT IS ENABLED
        Assert.assertNull(black.getAttribute("disabled"));
        //TODO VERIFIES IF THE BLACK BUTTON IS DISABLED. WILL BE NULL BECAUSE BLACK IS ENABLED
        Assert.assertEquals(black.getAttribute("disabled"), null);

        Thread.sleep(1000);

        System.out.println("WHERE IS MY MISTAKE?");
        //TODO VERIFY THAT VALUE IS EQUAL TO TRUE, AND ELEMENT IS DISABLED
        //Assert.assertEquals(green.getAttribute("disabled"), true);
        System.out.println("value of disabled: "+green.getAttribute("disabled"));
        //BELOW BOOLEAN WAS CREATED OUT OF STRING
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled")));/////////////////////////////////////////////////////////////////
    }

    @Test
    public void testElementVisible() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));
        WebElement start = driver.findElement(By.tagName("button"));

        //TODO VERIFY IF USERNAME IS NOT VISIBLE
        //isDisplayed --> returns if element is visible on www
        System.out.println("Username is visible: "+ username.isDisplayed());
        Assert.assertFalse(username.isDisplayed());//NOT DISPLAYED YET


        System.out.println("click on start button on webpage");
        start.click();//WILL BE DISPLAYED AFTER CLICK ON PAGE
        Thread.sleep(6000);
        System.out.println("Username is visible: "+username.isDisplayed());
        Assert.assertTrue(username.isDisplayed());

    }

}
