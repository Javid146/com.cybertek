package com.cybertek.tests.day8_review2;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.VerifyStartsWith;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class EbaySearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

        Thread.sleep(2000);
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        Thread.sleep(2000);
        input.sendKeys("wooden spoon"+Keys.ENTER);

        Thread.sleep(3000);
        WebElement countElem = driver.findElement(By.cssSelector("h1>span"));
        String count = countElem.getText();
        System.out.println(count);

        //CONVERT STRING INTO INT/////////////////////////////////////////////////////////////////
        int CountOne = Integer.parseInt(count.replace(",", ""));
        System.out.println("CountOne = " + CountOne);
        Thread.sleep(2000);
        WebElement all = driver.findElement(By.linkText("All"));
        Thread.sleep(2000);
        all.click();

        //reINITIALIZE the element that is throwing staleelementexception. Because we repeat it for the second time
        Thread.sleep(2000);
        countElem = driver.findElement(By.cssSelector("h1>span"));
        count = countElem.getText();
        System.out.println(count);

        int countTwo = Integer.parseInt(count.replace(",", ""));
        System.out.println("countTwo = " + countTwo);



        if(CountOne<countTwo) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");//BECAUSE COUNTTWO IS ALL. ALL CAN'T BE SMALLER
        }
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        input = driver.findElement(By.cssSelector("input[type='text']"));
        String woodspoon = input.getAttribute("value");//GETS THE VALUE OF THE ATTRIBUTE///////////////////////////////////
        System.out.println(woodspoon);

        VerifyStartsWith.verifyStartsWith(woodspoon, "wooden spoon");

        driver.navigate().back();
        input = driver.findElement(By.cssSelector("input[type='text']"));
        woodspoon = input.getAttribute("value");//GETS THE VALUE OF THE ATTRIBUTE///////////////////////////////////
        System.out.println("no sppon: "+woodspoon);

        System.out.println();
        Thread.sleep(2000);
        if(woodspoon.isEmpty()){
            System.out.println("PASS");
            System.out.println("Blank value as expected");
        }else{
            System.out.println("FAIL");
            System.out.println("actual value = " + woodspoon);
        }

    }
}
