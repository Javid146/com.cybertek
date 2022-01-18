package com.cybertek.tests.day12_popups_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsandWindowsExample {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod(){
        this.driver = WebDriverFactory.getDriver("chrome");
    }

    //@AfterMethod
    public void afterTest(){driver.quit(); }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        Thread.sleep(2000);

        //get all the available tabs (web pages).
        Set<String> windowHandles = driver.getWindowHandles();//TODO ///////////////////////////////////////////////////////////////////////////////////////////
       
        //print all the web pages
        for(String windowhandle : windowHandles){
            System.out.println(windowhandle);
        }
        
        //get id of current tab/page TODO////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);

        System.out.println("BEFORE SWITHCING THE TABS ------------------");
        //EVEN IF WE HAVE MANY TABS. TITLE OF FIRST PAGE WILL BE PRINTED
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //switch BETWEEN tabs
        for(String windowHandle : windowHandles){
            driver.switchTo().window(windowHandle);//TODO this method actually switches from current tab to new one
            if(driver.getTitle().equals("New Window")){//TODO CONDITION IS: IF THE NEW TAB'S TITLE IS New Window, stop in that tab. Title can be Facebook oe Google etc. Depends on the name of website
                break;
            }
        }
        System.out.println("AFTER SWITHCING THE TABS ------------------");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
