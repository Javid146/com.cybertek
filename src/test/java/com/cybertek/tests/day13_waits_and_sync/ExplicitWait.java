package com.cybertek.tests.day13_waits_and_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, 10);//TODO EXPLICIT WAIT //////////////////////////
    }

    //@AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //TODO EXPLICIT WAIT
    /*IT ALLOWS US TO WAIT FOR CERTAIN CONDITIONS. USING EXPLICIT WAITS WE CAN WAIT FOR SOME ACTIONS TO TAKE PLACE.
    * THINGS WE WAIT FOR CERTAIN CONDITIONS WITH EXPLICIT WAIT, WHICH ARE:
    * ELEMENT TO BE VISIBLE;  ELEMENTS TO DISAPPEAR
    * PAGE TO LOAD;           ELEMENTS TO BE CLICKABLE
    * TITLE TO HAVE TEXT
    * IT HAS TWO STEPS:
    * 1. CREATE WEBDRIVER WAIT CLASS: TODO WebDriverWait wait = new WebDriverWait(driver, 10)
    *2. kICK OFF THE WAIT BY PROVIDIGN THE EXPECTED CONDITION. TODO wait.until(ExpectedConditions.)method*/
    //explicit wait is like thread.sleep. We need to call it to wait, otherwise it won't happen.

    @Test
    public void testTitle() {
        driver.get("https://store.steampowered.com");

        //wait for the title to contain text
        wait.until(ExpectedConditions.titleContains("Steam"));//TODO remember this one/////////////////////////////////////////////

        System.out.println(driver.getTitle()); }


        @Test
    public void test2WaitForVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //don't give  enough time like in @BeforeMethod above and see how driver works
        //YOU GONNA GET TIMEOUT EXCEPTION
        wait.withTimeout(Duration.ofSeconds(2));//  TODO    REMEMBER THIS ONE TOO///////////////////////

        //driver waits until all features of website is visible
        wait.until(ExpectedConditions.visibilityOf(username));

        //make sure username is visible on page
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
    }

    @Test
    public void test4WaitForClickable() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");


        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement button = driver.findElement(By.tagName("button"));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        //wait until overlay element disappears
        WebElement overlay = driver.findElement(By.className("loadingoverlay"));
        wait.until(ExpectedConditions.invisibilityOf(overlay));                 //TODO LEARN THIS TOO////////////////////////////

        //DRIVER WILL WAIT UNTIL ELEMENT GETS CLICKABLE
        wait.until(ExpectedConditions.elementToBeClickable(button));          //TODO LEARN THIS TOO////////////////////////////
        button.click();
    }

    @Test
    public void test4WaitForInvisible(){
        driver.manage().window().fullscreen();
        driver.get("https://app.vytrack.com/user/login");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement myCalendar = driver.findElement(By.linkText("My Calendar"));

        //find the element with class loader mask and wait until it is not visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loader-mask")));
        myCalendar.click();
    }
}