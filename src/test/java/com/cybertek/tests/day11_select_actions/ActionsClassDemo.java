package com.cybertek.tests.day11_select_actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassDemo {
    /*TODO IN ORDER TO DO SOME ADVANCED INTERACTIONS IN SELENIUM WE USE ACTIONS CLASS:
     * HOVER OVER
     * DRAG AND DROP
     * RIGHT CLICK
     * DOUBLE CLICK*/
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        actions = new Actions(driver);
    }

    //@AfterMethod
    public void afterTest(){driver.quit(); }

    @Test
    public void hoerTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement target = driver.findElement(By.tagName("img"));

        //TODO moveToElement --> moves mouse on top of given web element
        actions.moveToElement(target).perform();
        Thread.sleep(3000);

    }

    @Test
    public void hover2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        ///////////////////////////TODO NEW METHODS BELOW. DAMN REMEMBER THEEEEEEEEEM
        //TODO when you have multiple actions to perform, we use build().perform();////////////////////////////////////////////
        //move mouse to enabled
        actions.
                moveToElement(enabled).
                pause(2000).
                moveToElement(downloads).
                pause(2000).
                moveToElement(pdf).
                click(pdf).
                build().perform();
    }


    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(3000);
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);
        actions.dragAndDrop(money, bank).perform();//TODO LEARN THIS METHOD TOOOOOO////////////////////////////////////
    }

    @Test
    public void dragDropAgain() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);
        actions.moveToElement(money).clickAndHold().moveToElement(bank).click().build().perform();
        Thread.sleep(2000);
    }



}
