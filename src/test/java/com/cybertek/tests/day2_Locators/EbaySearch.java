package com.cybertek.tests.day2_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbaySearch {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.ca/");
        driver.navigate().to("https://www.ebay.ca/");

        WebElement searchBox = driver.findElement(By.name("_nkw"));
        searchBox.sendKeys("Laptop"+ Keys.ENTER);

        /*IF class attributes' values have space or spaces driver will not be able to locate them

        OR AS BELOW. IF WE USE ''Keys.ENTER'' then we dont need to use seacrhButton.click(); to press
        the button in website. It automatically enters. Otherwise we need method below:
        WebElement seacrhButton = driver.findElement(By.id("gh-btn"));
        seacrhButton.click();*/



    }
}
