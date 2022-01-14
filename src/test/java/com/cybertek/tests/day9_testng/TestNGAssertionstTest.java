package com.cybertek.tests.day9_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionstTest {
    /*Assert -- is a class in test ng that provides assertions.
     * Assertion -- is a method that does verification of expected and actual.
     * assertEquals --*/
    @Test
    public void test1() {
        String expected = "one";
        String actual = "two";

        System.out.println("Test 1 started to compare");

        Assert.assertEquals(actual, expected);
        Assert.assertEquals(1, 1);
        Assert.assertEquals(true, false);

        System.out.println("Test 1 completed");

    }

    @Test
    public void test2() {
        System.out.println("Test 2 started to compare");

        String expected = "one";
        String actual = "one";


        // Assertion -- is a method that does verification of expected and actual.
        Assert.assertEquals(actual, expected);
        /*If assertion (verification) fails, nothing below assert inside of this method will execute.
        (For ex:"System.out.println("Test to completed");" will not be printed */
        System.out.println("Test two completed");

    }

    @Test
    public void test3() {

        String expected = "one";
        String actual = "two";
//This assert makes sure that two values are not equal to each other////////////////
        Assert.assertNotEquals(expected, actual);
        Assert.assertNotEquals(1, 2);

        System.out.println("TEST THREE FINISHED SUCCESSFULLY...");
    }

    @Test
    public void test4() {

        String expected = "one";
        String actual = "one";
//This assert makes sure that THE given condition returns true or false. It is boolean method////////////////
        Assert.assertTrue(expected.equals(actual));

        int c = 5;
        int n = 6;
        Assert.assertTrue(c < n);
    }

    @Test
    public void test5() {

        String expected = "https://www.google.ca/";
        String actual = "https://www.google.ca/";
        Assert.assertEquals(expected, actual);

        String expected1 = "java";
        String actual1 = "java - Google search";
        //VERIFIES THAT ONE VALUE STARTS WITH OR CONTAINS THE OTHER ONE/////////////////////
        Assert.assertTrue(actual1.contains(expected1));
        Assert.assertTrue(actual1.startsWith(expected1));

    }


}
