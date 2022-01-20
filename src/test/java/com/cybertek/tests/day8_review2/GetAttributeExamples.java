package com.cybertek.tests.day8_review2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttributeExamples {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        System.out.println(driver.getTitle());//GETS THE TITLE ON TOP OF THE PAGE

        //System.out.println(driver.getCurrentUrl());//GETS THE WEBSITEEEEEEEEEEEEEEE////////////////////

        System.out.println(driver.getPageSource());//TODO gives you HTML CODE OF THE PAGEEEEEEEEEEEEEEEEEEEEEE

        WebElement myEbayLink = driver.findElement(By.linkText("My eBay"));
        String classValue = myEbayLink.getAttribute("class");//GIVES THE VALUE OF THE ATTRIBUTE class
        System.out.println(classValue);

        String href = myEbayLink.getAttribute("href");//GIVES THE VALUE OF THE ATTRIBUTE href
        System.out.println(href);

        System.out.println("myEbayLink: "+myEbayLink.getText());

        //write wooden spoon in searchbox
        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("wooden spoon");
        //print whatever (wooden spoon) is written in the searchbox
        System.out.println(input.getAttribute("value"));//gets the value of attribute inside of element of input/////////

        //getAttribute("innerHTML") ALSO RETURNS TEXT/value OF THE ATTRIBUTE/////////////////////////////////////////////
        System.out.println("innerHTML of MyeBayLink : "+myEbayLink.getAttribute("innerHTML"));//My eBay


        System.out.println();
        //getAttribute("innerHTML") ALSO RETURNS TEXT/value OF THE ELEMENT/////////////////////////////////////////////
        System.out.println("outerHTML of MyeBayLink : "+myEbayLink.getAttribute("outerHTML"));//RETURNS THE WHOLE TEXT FULLY WRITTEN IN ELEMENT///////////
        System.out.println("outerHTML of input : "+input.getAttribute("outerHTML"));//RETURNS THE WHOLE TEXT FULLY WRITTEN IN ELEMENT//////////////////////

    }
}
