package com.cybertek.tests.day19_excel_io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteExample {
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
        //gets sheet from excel file based on index 5.
        //workSheet = workbook.getSheetAt(5);
        //gets sheet from excel file based on its name.
        workSheet = workbook.getSheet("QA2-short");
    }


    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }

    @Test
    public void readAndWrite() throws IOException {
            //iterate and get all rows
        for (int i = 0; i < workSheet.getPhysicalNumberOfRows(); i++) {
            Row currentRow = workSheet.getRow(i);
            //get cell values from each row
            String username = currentRow.getCell(0).toString();
            String password = currentRow.getCell(1).toString();
            String firstname = currentRow.getCell(2).toString();
            String lastname = currentRow.getCell(3).toString();
            String result = currentRow.getCell(4).toString();
            //print rows and cells
            System.out.println("ROW "+i);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("firstname = " + firstname);
            System.out.println("lastname = " + lastname);
            System.out.println("result = " + result);
            //we will write some things on excel cells
            currentRow.getCell(4).setCellValue("Pass");//todo this line should write on excel file, but as I am not authorized to use excel, it will not work
            //get updated value of cells
            System.out.println("new result= "+result);
        }

        //TODO FileOutputStream -> writes data on excel file. AGAIN, THESE LINES SHOULD CREATE ANOTHER FILE
        //TODO IN RESOURCES (CALLEDVUTRACK_TESTUSERS2.XLSX) WHICH CONTAINS ALL DATA IN NEW EXCEL FILE AND THIS KEEPS
        //TODO ORIGINAL EXCEL FILE WE USED INTACT
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/vytrack_testusers.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }

}