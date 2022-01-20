package com.cybertek.tests.day15_webtables;

import com.cybertek.test_base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class WebtablesTest extends TestBase {

    @Test
    public void printTable(){
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.linkText("Sortable Data Tables")).click();
        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println(myTable.getText());
    }

    @Test
    public void getHeaders(){
        String url = ConfigurationReader.getProperty("url");
        driver.get("http://practice.cybertekschool.com/tables");
        WebElement header = driver.findElement(By.tagName("thead"));
        System.out.println(header.getText());

        //get all headers in table 1
        List<WebElement> headerList = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("---------EACH HEADER WITH EACH LOOP------------");
        //in order print list we use for each loop or get same loop from util
         /*for(WebElement eachHeader : headerList){
            System.out.println(eachHeader.getText());}*/
        System.out.println(BrowserUtils.getElementsText(headerList));
    }

    @Test
    public void getTatbleSize(){
        driver.get("http://practice.cybertekschool.com/tables");
        //get number of columns
        List<WebElement> headerList = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns: "+ headerList.size());

        //get number of rows including header
        List<WebElement> rowsWithHeader=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows with header: "+ rowsWithHeader.size());

        //get number of rows without header
        List<WebElement> rowsWithOutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows without header: "+ rowsWithOutHeader.size());
    }

    @Test
    public void getSingleRowByIndex(){
        driver.get("http://practice.cybertekschool.com/tables");

        //get single row by index
        WebElement Row= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]")); /*OR: //table/tbody//tr[1])[1] */
        System.out.println(Row.getText());

        //get first row in the body by dynamic xpath
        String xpath = getTableRowXpath(2);
        Row = driver.findElement(By.xpath(xpath));
        System.out.println("ROW: "+Row.getText());
    }
    //getTableRowXpath based on index
    //use below method to get values with call above
    public static String getTableRowXpath(int index){
        String xpath = "//table[@id='table1']/tbody/tr["+index+"]";
                return xpath;
    }


    @Test
    public void getSingleCellbyIndex(){
        driver.get("http://practice.cybertekschool.com/tables");
        //get single cell based on index
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println(cell.getText());

        String xpath = getCellXpathbyIndex(2,3);
        WebElement rowandcell = driver.findElement(By.xpath(xpath));
        System.out.println("rowandcell: "+rowandcell.getText());
    }

    //use below method to get values with call above
    public static String getCellXpathbyIndex(int row, int column){
        String xpath = "//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        return xpath;
    }

    @Test
    public void iterateTableUsingLoops(){
        driver.get("http://practice.cybertekschool.com/tables");

        int rowCount = getRowCount();
        int colCount = getColCount();

        for (int i=1; i<=rowCount; i++){
            for(int j = 1; j<=colCount; j++){
            String xpath = getCellXpathbyIndex(i, j);
            WebElement cells = driver.findElement(By.xpath(xpath));
                System.out.println(cells.getText());
                 } }



    }
    //return number of rows excluding table header
    public int getRowCount(){
        return driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
    }
    public int getColCount(){
        return driver.findElements(By.xpath("//table[@id='table1']//th")).size();
    }
}
