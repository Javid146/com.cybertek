package com.cybertek.tests.day4_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextMethodOfXpath {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

/*When there is no attribute in element we use text() method to find the element
instead of for ex://input[@type='password']. Here type is attribute
        tagname[text()='text']*/
        WebElement relativeXpathText = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        String expectedtext = "Forgot Password";
        String actualtext = relativeXpathText.getText();

        if(expectedtext.equals(actualtext)){
            System.out.println("Test passed");
        }else{
            System.out.println("test FAILED");
        }


    }
}
