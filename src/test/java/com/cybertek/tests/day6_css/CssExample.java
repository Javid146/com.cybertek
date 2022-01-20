package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssExample {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//<button class="btn btn-primary" onclick="button6()" name="button6" id="disappearing_button">Don't click!</button>
        //WebElement button = driver.findElement(By.cssSelector("#disappearing_button"));
        WebElement button = driver.findElement(By.cssSelector(".nav-link"));
        //<a class="nav-link" href="/">Home</a>

        //TODO In css .(dot) means class. Just put . and write class name after it.
        //.nav-link"
        System.out.println(button.getText());
        //if element has multiple classes we do: .col-4.col-md-4
        WebElement butt2 = driver.findElement(By.cssSelector(".col-4.col-md-4"));
        System.out.println(butt2.getText());
        //FOR TAGNAMES IN CSS, JUST WRITE AND THAT'S IT.
        WebElement butt3 = driver.findElement(By.cssSelector("h4"));
        System.out.println(butt3.getText());
        //space means grand child in css. > means child in css. a is grandch.
        WebElement butt4 = driver.findElement(By.cssSelector("html>body>nav>ul a"));
        System.out.println(butt4.getText());







    }

}
