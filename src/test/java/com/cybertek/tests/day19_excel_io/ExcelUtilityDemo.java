package com.cybertek.tests.day19_excel_io;

import org.testng.annotations.Test;
import com.cybertek.utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class ExcelUtilityDemo {
    private String filePath = "src/test/resources/vytrack_testusers.xlsx";
    private String sheetName = "QA2-short";

    @Test
    public void test(){

        ExcelUtil qa2Short = new ExcelUtil(filePath, sheetName);
        System.out.println(qa2Short.getColumnsNames());

        String data [][]=qa2Short.getDataArray();
        qa2Short.getDataList();
        List<Map<String, String>>datalist = qa2Short.getDataList();
        System.out.println(datalist);


    }
}
