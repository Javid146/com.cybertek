package com.cybertek.tests.day17_ddt_dataprovider_pom2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*DATA DRIVEN test is executing same test case using different value/inputs. There are 2 steps:
* 1. Test Steps
* 2. Test data
* Class below is usually used to provide data from DataProvider method to tests. So DataProvider method below can be
* in same class with tests it provides data to. Here test should show name of DataProvider:
* todo @Test(dataProvider = "users")
 * Or they can be in different classes. In that case test should show name of dataProvider, and the class that dataProvider gives data from:
* todo @Test(dataProvider = "users", dataProviderClass = Login.class) */
public class UserInfoDataDriven {

    @Test(dataProvider = "users") //todo this (dataProvider = "users") is essential in order to connect it to  public  public Object [][] getUsers()

    public void test(String username, String email, int number){
        System.out.println("ongoing application");
        System.out.println("opening application");
        System.out.println("Login as: "+username);
        System.out.println("number is: "+number);
        System.out.println("verify info");
    }


    @DataProvider(name= "users") //todo this name on left is essential in order to connect it to  test(String username, String email) above
    public Object [][] getUsers() {
        return new Object[][]
                {
                {"user1", "UserUser123", 25},
                {"salesmanager355", "UserUser123", 26},
                        {"salesmanager355", "UserUser123", 236},
                        {"salesmanager4000", "UserUser123", 262},
                };

    }
}
