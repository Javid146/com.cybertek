package com.cybertek.tests.day7_review;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        nameMatch();
        secondNameMatch();
    }

    public static void nameMatch(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com//");

        /*<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="
        " class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">*/
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("disinfectant wipes");//type words in searchbox

        /*<input id="nav-search-submit-button" type="submit" class="nav-input nav-progressive-attribute" value="Go" tabindex="0">*/
        WebElement click = driver.findElement(By.id("nav-search-submit-button"));//click button
        click.click();

        /*<span class="a-size-base-plus a-color-base a-text-normal">Amazon Brand - Solimo Disinfecting Wipes, Lemon Scent &amp; Fresh Scent,
         Sanitizes/Cleans/Disinfects/Deodorizes, 75 Count (Pack of 3)</span>*/
        WebElement firstitem = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        firstitem.click();


    }

    public static void secondNameMatch(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com//");

        /*<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="
        " class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">*/
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("disinfectant wipes");//type words in searchbox

        /*<input id="nav-search-submit-button" type="submit" class="nav-input nav-progressive-attribute" value="Go" tabindex="0">*/
        WebElement click = driver.findElement(By.id("nav-search-submit-button"));//click button
        click.click();

        /*//button[1] -> this xpath works  if elements are siblings. so browser will find button[2], button[3] and etc.
        * But if elements are not siblings, then we do:
        * 1. Write xpath that matches similar elements. For ex: like below:
        //span[@class='a-size-base-plus a-color-base a-text-normal']
        2. TODO Wrap xpath in PARENTHESIS AND ADD INDEX AT THE END:
        * (//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]
        * THIS METHOD WILL FIND ALL THE SIMILAR ELEMENTS. ALL YOU NEED TO DO IS TO CHANGE THE INDEX
        * (//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]
        * (//span[@class='a-size-base-plus a-color-base a-text-normal'])[4]*/

        /*<span class="a-size-base-plus a-color-base a-text-normal">Amazon Brand - Solimo Disinfecting Wipes, Lemon Scent &amp; Fresh Scent,
         Sanitizes/Cleans/Disinfects/Deodorizes, 75 Count (Pack of 3)</span>*/
        WebElement seconditem = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        seconditem.click();





    }}


