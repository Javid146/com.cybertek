package com.cybertek.tests.day19_excel_io;
import com.cybertek.utilities.ConfigurationReader;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
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
        //gets sheet from excel file based on index 5.
        //workSheet = workbook.getSheetAt(5);
        //gets sheet from excel file based on its name.
        workSheet = workbook.getSheet("QA3-short");
    }

    @Test
    public void rowAndColumnCount(){
        System.out.println(workSheet.getSheetName());
        //returns last row's number
        int lasRowIndex = workSheet.getLastRowNum();
        System.out.println("lasRowIndex = " + lasRowIndex);

        int rowCount = workSheet.getPhysicalNumberOfRows();
        System.out.println("rowCount = " + rowCount);

        //to get number of columns we need to get:
        // workSheet.getRow(0) -> one row and count cells in it.
        //getLastCellNum()-> based on cell num we can find columns
        int colCount = workSheet.getRow(0).getLastCellNum();
        System.out.println("colCount = " + colCount);


    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }


    @Test
    public void readSingleCell(){
        //read data from cell
        //get row;
        Row row =workSheet.getRow(7);
        //get specific cell from row;
        Cell cell = row.getCell(2);
        //get data from cell
        String value = cell.toString();
        System.out.println("cell value = " + value);
    }


    @Test
    public void printWholeRow(){
        //get row
        Row row = workSheet.getRow(0);
        int colCount = row.getLastCellNum();
        System.out.println("colCount = " + colCount);

        for (int i = 0; i < colCount; i++) {
            Cell cell = row.getCell(i);
            System.out.println("cell "+i+" = " + cell.toString());

        }}


        @Test
        public void readWholeSheet(){
        int rowsCount = workSheet.getPhysicalNumberOfRows();
        int colCount = workSheet.getRow(0).getLastCellNum();
            System.out.println("rowsCount = " + rowsCount);
            System.out.println("colCount = " + colCount);

            for (int i = 0; i < rowsCount; i++) {
                Row currentRow = workSheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = currentRow.getCell(j);
                    String value = cell.toString();
                    System.out.print("row: "+i+", col: "+j+" - " + value+"\t\t\t");
                }
                System.out.println();}

        }






}
