package com.cybertek.tests.day19_excel_io;

import com.cybertek.utilities.ConfigurationReader;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelExample {
    //path to the location of excel file
    private String filePath = "src/test/resources/vytrack_testusers.xlsx";
    //creates connection between java (jvm) and file
    private FileInputStream fileInputStream;
    //represents the excel file
    private Workbook workbook;
    //represents sheet (like page of excel file) that contains actual data of excel file
    private Sheet workSheet;

    @BeforeMethod
    public void setUp() throws IOException {
        //initialize input stream and goes to file's location
        fileInputStream = new FileInputStream(filePath);
        //create workbook from input stream
        //WorkbookFactory.create --> used to create workbook
        workbook = WorkbookFactory.create(fileInputStream);
        //get sheet from excel file based on index 5.
        workSheet = workbook.getSheetAt(5);
    }

    @Test
    public void rowAndColumnCount(){
        System.out.println(workSheet.getSheetName());




    }
}
