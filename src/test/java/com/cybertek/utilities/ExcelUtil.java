package com.cybertek.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import javax.xml.transform.sax.SAXResult;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private Sheet workSheet;
    private Workbook workbook;
    private String path;

    public ExcelUtil(String path, String sheetName){
        this.path = path;
        try{
            FileInputStream ExcelFile = new FileInputStream(path);
            //make workbook of excel file
            workbook= WorkbookFactory.create(ExcelFile);
            //get sheet from excel file
            workSheet=workbook.getSheet(sheetName);
            //check if sheet name is null. null means wrong name
            Assert.assertNotNull(workSheet,"Sheet: \""+sheetName+"\" does not exist");
        }catch (Exception e){throw new RuntimeException(e);}
    }

    public String getCellData(int rowNum, int colNum){
        Cell cell;
        try{
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        }catch (Exception e){throw new RuntimeException();}

    }

    public String [][] getDataArray(){
        String [][]data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i,j);
                data[i][j]=value;
            }
        }
        return data;
    }

    public List<Map<String, String>>getDataList(){
        List<String>columns = getColumnsNames();
        List<Map<String, String>>data = new ArrayList<>();

        for (int i = 0; i < rowCount(); i++) {
            //get rows
            Row row = workSheet.getRow(i);
            Map<String, String>rowMap = new HashMap<>();
            for (Cell cell:row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }

    public List<String>getColumnsNames(){
        List<String>columns = new ArrayList<>();

        for (Cell cell:workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }


    public void setCellData (String value, int rowNum, int colNum){
        Cell cell;
        Row row;

        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        }catch (Exception e){e.printStackTrace();}
}

public void setCellData(String value, String columnName, int row){
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value,row,column);
}
public int columnCount(){return  workSheet.getRow(0).getLastCellNum();}
public int rowCount(){return workSheet.getLastRowNum()+1;}

}
