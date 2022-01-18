package com.cybertek.tests.day10_webelement;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxes {
    /*TODO we do this so not to initialize WebDriver driver before every method*/
    WebDriver driver;

    /*TODO BeforeMethod will execute and launch before all new methods*/
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes"); }

    /*TODO AfterMethod will execute and quit after all new methods*/
    //@AfterMethod
    //public void AfterMethod(){driver.quit();}

    @Test
    public void test() throws InterruptedException {
        //finds checkboxes from website
        WebElement inputOne = driver.findElement(By.xpath("//input[1]"));
        WebElement inputTwo = driver.findElement(By.xpath("//input[2]"));

        //checks if they are selected
        System.out.println("IS ONE SELECTED? "+inputOne.isSelected());
        System.out.println("IS TWO SELECTED? "+inputTwo.isSelected());

        //TODO same as methods above, this one verifies true or false, above one checks and prints true/false
        //Assert.assertFalse(inputOne.isSelected());
        //Assert.assertFalse(inputTwo.isSelected());

        System.out.println();
        System.out.println("CHECK FIRST CHECKBOX");
        inputOne.click();
        Thread.sleep(1000);

        System.out.println();
        System.out.println("second check: IS ONE SELECTED? "+inputOne.isSelected());
        System.out.println("second check: IS TWO SELECTED? "+inputTwo.isSelected());



    }

}
