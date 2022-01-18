package com.cybertek.tests.day12_popups_tabs_alerts_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeExample {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome"); }

    @AfterMethod
    public void afterTest(){driver.quit(); }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        Thread.sleep(2000);

        /* Iframes are tags that are used to insert one html inside of the other one. Selenium cant interact with iframe
        * (1 html inside of other one). So in order to interact we have to switch to iframe
        *TODO driver.switchTo().frame("id of iframe");
        * Later if we want to come back to previous html (previous page) we need to type:
        *TODO driver.switchTo().defaultContent();
        * TODO driver.switchTo().parentFrame(); this method also switches to back to previous html (previous page) like the above method
        *  driver.switchTo().frame(0); this method allows you to find frames by index. If you have many frames (many htmls)
        * it helps you to find the ones you need by index. When we go from parent frame to frame index 3, you need first to go to 2nd frame then 3rd.
        * but it is easy to jump back from frame 6 drirectly  to parent */
        driver.switchTo().frame("mce_0_ifr"); // --> switches selenium's focus from default content to iframe//////////////////////////

        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("amazing");
        Thread.sleep(4000);

        //get out of the iframe back to default
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //if the element is hidden inside of the second html we find it by the tagname 'iframe'. Because iframe is not hidden
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("great, thanks for swtching back");
        Thread.sleep(4000);

        //get out of iframe again, to previous, 1st html
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.switchTo().frame(0);//find by index
        textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("great, thanks for swtching back");
        Thread.sleep(4000);

    }






}
