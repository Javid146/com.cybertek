package com.cybertek.tests.day10_webelement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    /*TODO we do this so not to initialize WebDriver driver before every method*/
    WebDriver driver;

    /*TODO BeforeMethod will execute and launch before all new methods*/
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons"); }

    /*TODO AfterMethod will execute and quit after all new methods*/
    //@AfterMethod
    public void AfterMethod(){driver.quit();}


    /* go to page 'radio buttons' verify that none of the sports 'radio buttons are selected'*/
    @Test
    public void listOfRadioButtons(){

        //TODO findElements --> RETURNS LIST OF ELEMENTS with attribute that have value 'sport'
        List <WebElement> sports = driver.findElements(By.name("sport"));////////////////////////////////////////////////////////////////////////
        System.out.println(sports.size());

        for(WebElement radiobutton: sports){
            Assert.assertFalse(radiobutton.isSelected());
        }
    }

    @Test
    public void getLinksTest(){
        driver.get("http://practice.cybertekschool.com/");

        List <WebElement> links = driver.findElements(By.cssSelector(".list-group-item"));
        System.out.println(links.size());

        System.out.println();
        System.out.println("---------------LINKS--------------------");
        System.out.println();
        for(WebElement LinksOnebyOne : links){
            System.out.println(LinksOnebyOne.getText());  }
    }


    @Test
    public void amazonTest()throws InterruptedException{
        driver.get("http://amazon.com");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels"+ Keys.ENTER);

        List<WebElement>allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));
        Thread.sleep(3000);
        System.out.println("NUMBER OF RESULTS: "+allResults.size());
        System.out.println("First result: "+allResults.get(0).getText());//////////////////////////////////////////////////////////////
        System.out.println("Second result: "+allResults.get(1).getText());
        System.out.println("Last result: "+allResults.get(allResults.size()-1).getText());/////////////////////////////////////////////////////
    }


    @Test
    public void radioTest()throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> list = driver.findElements(By.name("sport"));
        System.out.println("number of sports: "+list.size());

        Thread.sleep(3000);
        //find out if any of sports checkbox checked
        for(int i=0; i<list.size();i++){
            Assert.assertFalse(list.get(i).isSelected());
        }

        Thread.sleep(2000);
        System.out.println("---------------START SELECTING RANDOM NUMBERs----------------");
        //randomly click and check sports 5 times. because q<5
        Random ran = new Random();

        for(int q=0; q<5; q++){
            Thread.sleep(2000);
            int num = ran.nextInt(4); //generates 4 random naumbers each time
            list.get(num).click();
            System.out.println("SELECTING BUTTON #: "+(num+1));//5 times.q<5

        for(int i=0; i<list.size(); i++){
            if(i==num){
                Assert.assertTrue(list.get(num).isSelected());
            } else {Assert.assertFalse(list.get(i).isSelected());
            }
        }

    }

}}
