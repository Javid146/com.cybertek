package com.cybertek.tests.day4_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");

        WebElement signInBut = driver.findElement(By.tagName("button"));
//<button _ngcontent-c1="" class="button is-dark" type="submit" disabled="">sign in</button>
        //when you write the attribute its value will be printed
        String type = signInBut.getAttribute("type");//submit
        System.out.println(type);
        System.out.println(signInBut.getAttribute("class"));//button is-dark


    }
}
