package com.cybertek.tests.day11_select_actions;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectClassTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        this.driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown"); }

//TODO soooooooo THIS METHOD WILL MAKE WWEBPAGE QUIT AFTER EVERY METHOD IS FINISHED
   @AfterMethod
   public void afterTest(){driver.quit(); }

    @Test
    public void getSelectedOption(){
        //TODO find element that has tag called select
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        //TODO create a select class object using the dropdown web element from above
        //Select only works with elements that have "select" tag
        Select dropdownList = new Select(dropdown);

        //get selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();//TODO
        System.out.println(selectedOption.getText());

        //TODO compare expected to actual
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
}

    @Test
    public void selectFromList() throws InterruptedException {
        //get element with select tag
    WebElement dropdown = driver.findElement(By.id("state"));
    //create select class
    Select states = new Select(dropdown);


//TODO selectByVisibleText --> selects by text of the dropdown option of webpage
    states.selectByVisibleText("Iowa");
    Thread.sleep(1000);
    states.selectByVisibleText("Vermont");
   Thread.sleep(1000);
    states.selectByVisibleText("Kentucky");
    Thread.sleep(1000);

    //TODO selects values based on the index near in on webpage
        states.selectByIndex(0);
        Thread.sleep(1000);
        states.selectByIndex(20);
        Thread.sleep(1000);
        states.selectByIndex(15);

//TODO selectbyValue --> selects based on the value of value attribute (in html) of the option
//TODO selectbyValue --> it is not select text
        //EXAMPLE: <option value="AZ">Arizona</option>:  <option value="CA">California</option>
        states.selectByValue("VA");//selects Virginia
        Thread.sleep(1000);
        states.selectByValue("Ca");//selects California
        states.selectByValue("SC");
        Thread.sleep(1000);
        states.selectByValue("NE");



    }

    @Test
    public void getAvailableOptions(){
        Select monthList = new Select(driver.findElement(By.id("month")));

        //print current option:
        System.out.println(monthList.getFirstSelectedOption().getText());

        //TODO returns all of the available options from dropdown
        List<WebElement> allOptions = monthList.getOptions();                                   //TODO


        System.out.println("--------GET MONTHS--------");
        for(WebElement months : allOptions){
            System.out.println(months.getText());
        }

        //TODO THIS METHOD SHOWS THE CURRENT MONTH OF THE YEAR
        System.out.println("CURRENT MONTH IS: "+LocalDate.now().getMonth().name());           //TODO

        //verify months dropdown always shows current month
        String expected = LocalDate.now().getMonth().name();
        String actual = monthList.getFirstSelectedOption().getText();
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());

        //TODO we cant compare allOptions and expectedMonths above because,1st is WebElement
        //second is String list. that's why we create String array list from allOptions
        //by using for each loop and after compare them
        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May","June","July", "August", "September", "October", "November", "December");
        List<String>actualMonths = new ArrayList<>();// 1. create 'option' String array list

        for(WebElement option : allOptions){
            actualMonths.add(option.getText());//2. add allOptions webelement inside of 'option'
        }
        Assert.assertEquals(actualMonths,expectedMonths);//3. compare expected and actual
    }



    @Test
    public void verifyOptions(){
        Select LISt = new Select(driver.findElement(By.id("dropdown")));
        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");
        List<String> actualValues = new ArrayList<>();

        //for each loop does not work with Select class. So I make for each loop webelement list out of 'LISt'
        for(WebElement option: LISt.getOptions()){
           actualValues.add(option.getText()); }

        Assert.assertEquals(actualValues, expectedValues);

        int expectedSize = 3;
        int actualSize = LISt.getOptions().size();//TODO so get options mostly work with array List of webelement


    }
}
