package com.cybertek.tests.day8_review2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackTest {
    public static void main(String[] args) throws InterruptedException {
        titleTest();


    }
    private static void titleTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");

        //finds and writes usern
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");

        //finds and writes passw
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        //locates/clicks profilename
        WebElement profileName = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        Thread.sleep(2000);
        profileName.click();

        //locates/presses my configuration on dropdown menu
//FIND PARENT TAG AND CLASS THEN FIND CHILD ATTRIBUTE AND CLASS AND FINALLY LOCATE NEEDED TAG/CLASS AND CLASS' NAME/////////////////////////////////////////
        WebElement myconfig= driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
       Thread.sleep(3000);
        myconfig.click();

        Thread.sleep(3000);
        String expected = profileName.getText();//John Doe
        String actual = driver.getTitle();///////////////////////////////////////////////////////////

        if(actual.startsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        System.out.println("expected = " + expected);//John Doe
        System.out.println("actual = " + actual);}
}