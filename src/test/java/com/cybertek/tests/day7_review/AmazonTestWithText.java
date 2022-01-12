package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestWithText {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

/*<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder=""
 class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">*/
        WebElement searchbox = driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/div/form/div[2]/div/input"));
        searchbox.sendKeys("selenium cookbook");

/*<input id="nav-search-submit-button" type="submit" class="nav-input nav-progressive-attribute" value="Go" tabindex="0">*/
        WebElement searchbttn = driver.findElement(By.id("nav-search-submit-button"));
        searchbttn.click();

/*<span class="a-size-medium a-color-base a-text-normal">Selenium Testing Tools Cookbook</span>*/
        WebElement title = driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook']"));//find xpath by using text
        System.out.println(title.getText());
        title.click();


    }
}
