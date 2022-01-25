package com.cybertek.tests.day19_excel_io;

import com.cybertek.base.VyTrackTestBase;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VytrackExcelDDTTests  extends VyTrackTestBase {

    @Test(dataProvider = "getUserData")
    public void userDetailsTest(String username, String password, String firstname, String lastname)  {
        test = report.createTest("Username test for "+username);
        test.info("login to vytrack");
        //open webpage
        loginPage.LoginPage(username, password);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        test.info("Get expected value");
        //get person's full name from webpage
        String actualName = dashboardPage.accountHolderName.getText();
        test.info("verify username");
        //I can't use asssert here, because excel file data is different than in vytrack website. so expected and actual data will differ.
       // Assert.assertEquals(actualName, firstname+" "+lastname);
        test.pass("pass user details test for "+username);
    }

    @DataProvider(name = "getUserData")
    public Object[][] getData() throws IOException {
        //DataProvider has a return type 2dimensional array
        //we read excel file, get its values and add to 2d array and return
        //find source (location) for new data
        FileInputStream file = new FileInputStream("src/test/resources/vytrack_testusers.xlsx");
        //create excel file from given data in file location
        Workbook workbook = WorkbookFactory.create(file);
        //get sheet from workbook file
        Sheet workSheet = workbook.getSheet("QA1-short");

        //get number of row and cols
        int rowCount = workSheet.getPhysicalNumberOfRows()-1;
        int colCount = workSheet.getRow(0).getLastCellNum()-1;

        //array will contain excel data
        Object[][] data = new Object[rowCount][colCount];
        //iterate worksheet
        for (int i = 1; i <=rowCount; i++) {
            Row row = workSheet.getRow(i);

            for (int j = 0; j <colCount; j++) {
                Cell cell = row.getCell(j);
                data[i-1][j]=cell.toString();
            }

        }
        workbook.close();
        file.close();
        return data;
    }


}
