package com.cybertek.tests.day9_testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstNGtest {

    @Test
    public void test1(){
        System.out.println("TEST ONE");
    }

    @Ignore //IGNORES ONLY THE METHOD IT IS ATTACHED TO. METHOD WILL NOT EXECUTE. NOT THE REST.
    @Test
    public void test2(){
        System.out.println("TEST TWO");
    }

    @Test
    public void test3(){
        System.out.println("TEST THREE");

}}
