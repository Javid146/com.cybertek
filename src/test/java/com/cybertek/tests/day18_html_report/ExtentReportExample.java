package com.cybertek.tests.day18_html_report;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportExample {

    //set up new report
    ExtentReports report;       //TODO /////////////////
    //create html reporter
    ExtentHtmlReporter htmlReporter;      //TODO /////////////////
    //used to define part of test in a report. does login, marks test results //TODO /////////////////
    ExtentTest test;


    @BeforeMethod
    public void setUp(){
        report = new ExtentReports();

        //I need to show location for these reports' folder
        //System.getProperty("user.dir")  --> gets the folder of project
        //+ "test-output/report.html" --> create folder test-output and in it create file report.html
        //TODO this will get the exact location of report folder
        String path = System.getProperty("user.dir")+"/test-output/report.html";
        //initialize html reporter with given path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach html reporter to report object
        report.attachReporter(htmlReporter);

        //set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", "Chrome");
    }


    @Test(description = "title test")
    public void test(){
        //test should be created for every test case
        test = report.createTest("VYT-123 Title verification test");
        test.info("Opening browser");
        //driver = new Chromedriver
        test.info("going to website");
        //driver.get(google.com)
        test.info("verifying title");
        //assertEquals(google, google)
        test.pass("VYT-123 Title verification test");
    }



    @AfterMethod
    public void tearDown(){
        //report will be created when we call this. report will not be generated
        //if we dont call flush. we do it at end of everything.
        report.flush();
    }
}


