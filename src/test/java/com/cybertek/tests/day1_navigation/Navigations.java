package com.cybertek.tests.day1_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String practiceWebURL = "https://www.youtube.com/";
        driver.get(practiceWebURL);

        driver.navigate().to("https://www.tradingview.com/chart/tWYdFR37/?symbol=BINANCE%3ACRVUSDT");

        //will go to youtube, then tradingview and back to youtube again
        driver.navigate().back();

        //will go to youtube, then tradingview and back to youtube and forward to tradingview again
        driver.navigate().forward();

        //WEBPAGE WILL BE FULLSCREEN
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();


        //CLOSE DRIVER
        //CLOSE THE WEB BROWSER ONLY
        driver.close();

        //CLOSE ALL THE WINDOWS IN BROWSER
        driver.quit();




    }
}
