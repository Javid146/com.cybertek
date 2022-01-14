package com.cybertek.tests.day9_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeandAfterTest {

    /*beforeClass RUNS ONCE BEFORE EVERYTHING. NO MATTER WHAT RUNS ONLY ONCE//////////////////////////////////////*/
    @BeforeClass
    public void beforeClass(){
        System.out.println("\t BEFORE CLASS");
    }

    /*afterClass RUNS ONCE after EVERYTHING. NO MATTER WHAT RUNS ONLY ONCE//////////////////////////////////////*/
    @BeforeClass
    public void afterClass(){
        System.out.println("\t BEFORE CLASS");
    }

    /*BEFORE METHOD EXECUTES BEFORE ALL THE METHODS THAT HAVE ANNOTATION @TEST*
    WE SHOULD not CALL beforeMethod. IT IS NOT MEANT TO BE CALLED.
    BEFORE METHOD RUNS BEFORE EACH METHOD ONCE. it is used for setting variable, opening browser,
    making connection to database.*/
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }

    /*After METHOD EXECUTES BEFORE ALL THE METHODS THAT HAVE ANNOTATION @TEST*
    WE SHOULD Not CALL afterMethod. IT IS NOT MEANT TO BE CALLED.
    afterMethod RUNS BEFORE EACH METHOD ONCE. afterMethod executes even if test fails.
    Used for reporting, closing connection, closing browser.*/
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }


    @Test
    public void test1(){
        System.out.println("this is 1st test...");
    }

    @Test
    public void test2(){
        System.out.println("this is SECOND test...");
    }
}
