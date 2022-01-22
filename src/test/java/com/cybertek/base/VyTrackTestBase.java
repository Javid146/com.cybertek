package com.cybertek.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.pages.CreateCalendarEventPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class VyTrackTestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclePage vehiclePage;
    protected CreateCalendarEventPage calendarEvntPg;
    private ExtentReports report;
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


    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("url2"));
        wait = new WebDriverWait(driver, 10);
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        vehiclePage = new VehiclePage();
        calendarEvntPg = new CreateCalendarEventPage();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Driver.closeDriver();
        Thread.sleep(2000);
    }
}
