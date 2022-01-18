package com.cybertek.tests.day14_test_base_props_driver;

import com.cybertek.test_base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);

        WebElement file_upload = driver.findElement(By.linkText("File Upload"));
        file_upload.click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys("C:/Users/mamma/Desktop/my_file.txt");

        WebElement submit = driver.findElement(By.id("file-submit"));
        submit.click();

        WebElement uploadFile = driver.findElement(By.id("upload-files"));
        Assert.assertEquals(uploadFile.getText(), "my_file.txt");
    }
}
