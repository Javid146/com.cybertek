package com.cybertek.utilities;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    public static void wait(int seconds){
        try{Thread.sleep(1000*seconds);}
        catch (InterruptedException e){e.printStackTrace();}
    }

    /*take list of web elements and convert into String list*/
    public static List <String>getElementsText(List<WebElement>elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    public static void scrollTo(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /*takes screenshot, param name, takes name of test and returns a path to screenshot*/
    public static String getScreenshot(String name) throws IOException{
        //name screenshot with current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //TakesScreenshot--> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        //full path to screenshot location
        String target = System.getProperty("user.dir")+"/test-output/Screenshots/"+name+date+"png";
        File finalDestination = new File(target);
        //save screenshot to path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}
