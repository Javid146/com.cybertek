package com.cybertek.utilities;

public class VerifyStartsWith {
    public static void verifyStartsWith(String actual, String expected) {
        if(actual.startsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
    }
}
