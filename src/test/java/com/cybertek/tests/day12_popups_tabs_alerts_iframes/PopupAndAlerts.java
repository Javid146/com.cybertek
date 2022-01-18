package com.cybertek.tests.day12_popups_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlerts {

    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterTest(){driver.quit(); }

    @Test
public void htmlPopup() throws InterruptedException {
    driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //WebElement button = driver.findElement(By.xpath("//span[text()='Destroy The World']"));
        WebElement button = driver.findElement(By.cssSelector("span[class='ui-button-text ui-c']"));
        button.click();

        Thread.sleep(1000);
        WebElement no = driver.findElement(By.id("j_idt311:j_idt315"));
        no.click();
        Thread.sleep(1000);


    }

    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[1]"));
        button1.click();

       /*IN WEBPAGES WE SOMETIMES MEET JAVASCRIPT WHICH CANT BE CONTROLLED BY HTML METHODS. THERE WE
        * START TO USE ALERT. WE CREATE OBJECT OF ALERT CLASS AND USE IT.*/
        Alert alert = driver.switchTo().alert();//TODO //////////////////////////////////////////////////////////////////////////////////////////////////
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void jsAlertsCancel() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button2 = driver.findElement(By.xpath("//button[2]"));
        button2.click();

        /*IN WEBPAGES WE SOMETIMES MEET JAVASCRIPT WHICH CANT BE CONTROLLED BY HTML METHODS. THERE WE
         * START TO USE ALERT. WE CREATE OBJECT OF ALERT CLASS AND USE IT.*/
        Alert alert = driver.switchTo().alert();//TODO //////////////////////////////////////////////////////////////////////////////////////////////////
        alert.dismiss();}

    @Test
    public void jsAlertsSendKeys() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button3 = driver.findElement(By.xpath("//button[3]"));
        button3.click();

        /*IN WEBPAGES WE SOMETIMES MEET JAVASCRIPT WHICH CANT BE CONTROLLED BY HTML METHODS. THERE WE
         * START TO USE ALERT. WE CREATE OBJECT OF ALERT CLASS AND USE IT.*/

        Alert alert;
        try {
            alert = driver.switchTo().alert();//TODO //////////////////////////////////////////////////////////////////////////////////////////////////
            alert.sendKeys("Admiral Kunkka");
            alert.accept();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }



}

