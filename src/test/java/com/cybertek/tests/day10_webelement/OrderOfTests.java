package com.cybertek.tests.day10_webelement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderOfTests {
    String title;


    @Test (priority = 0, description = "test login functionality.")
    public void login(){
        System.out.println("Opening the browser");
        System.out.println("Capturing the title");
        title ="cbt";
        //Assert.fail(); FAILS THE TEST ON PURPOSE////////////////////////////////////////
        Assert.fail();
    }

    @Test (priority = 10, dependsOnMethods = "login")
    public void assertTitle(){
        System.out.println("verifying the title");
        Assert.assertEquals(title, "cbt");
    }

    @Test (priority = 50)
    public void verifyOtherThings(){
        System.out.println("VERIFYING STH ELSE.");
    }
}
