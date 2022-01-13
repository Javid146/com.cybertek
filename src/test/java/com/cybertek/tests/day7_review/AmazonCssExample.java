package com.cybertek.tests.day7_review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AmazonCssExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.traderjoes.com/home");


WebElement q = driver.findElement(By.cssSelector(".Search_action__text__3niGG"));//dot means any element with class names Search_action__text__3niGG

        q.click();
        WebElement searchinput = driver.findElement(By.xpath("//input[@class='SearchField_searchField__inputText__2IH6E']"));
        searchinput.sendKeys("yummy");

        Thread.sleep(1000);
        WebElement link = driver.findElement(By.xpath("//div[@class='Suggestion_suggestionResult__item__CCOLh']"));
        link.click();
/*<a class="Link_link__1AZfr Suggestion_suggestionResult__title__35HXu" href="/home/products/pdp/everything-but-the-bagel-sesame-seasoning-blend-059137">Everything But The Bagel Sesame Seasoning Blend</a>*/
//WebElement select = driver.findElement(By.xpath("//a[@class='Link_link__1AZfr Suggestion_suggestionResult__category__1bSBC']"));
//select.submit();
    }
}
