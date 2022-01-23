package com.cybertek.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.CreateCalendarEventPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class VyTrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclePage vehiclePage;
    protected CreateCalendarEventPage calendarEvntPg;
    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    @BeforeSuite            //todo suite is the biggest collection. it will run before all methods, classes and everything.
    public void setUpSuite(){
        report = new ExtentReports();
        //TODO this will get the exact location of report folder
        String path = System.getProperty("user.dir")+"/test-output/report.html";

        //initialize html reporter with given path
        htmlReporter = new ExtentHtmlReporter(path);

        //set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");

        //attach html reporter to report object
        report.attachReporter(htmlReporter);

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    }

    @AfterSuite
    public void tearDownSuite(){report.flush();}


    @Parameters ("url3") //name ("url") should be exactly like in xml. TODO Parameters MEANS WE GET PARAMETERS FROM TESTNG_RUNNER.XML or SMOKE_TEST_RUNNER.XML FILE. IF THERE IS NO PARAMETERS, IT WILL NOT RUN
    @BeforeMethod ()
    public void setUpMethod(@Optional String url) {
        System.out.println("url3 = " + url);
        driver = Driver.getDriver();

        //todo means if url is not shown take parameters from testng_runnner.xml
        if(url==null){driver.get(ConfigurationReader.getProperty("url3"));
        }else {driver.get(url);}

        wait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclePage = new VehiclePage();
        calendarEvntPg = new CreateCalendarEventPage();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        //TODO ITestResult gives information about current test, name, status
        if(iTestResult.getStatus()== ITestResult.FAILURE){
            //tell extent report that test failed. (for practice)
            test.fail(iTestResult.getName());

            //TODO take screen shot of the screen and save location of failed test
           String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());

           //show path to screenshot
           test.addScreenCaptureFromPath(screenshot);
        }

        Thread.sleep(2000);
        Driver.closeDriver();





    }
}
