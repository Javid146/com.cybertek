package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    /*Let's say there is a new class and it needs a browser. So it gets browser from TestBase
     * And TestBase gets the driver from Driver class.
     * Driver class actually created the driver.
     * Driver gets browser version from configuration.properties file using ConfigurationReader class*/

private static Properties properties;

static{
    try {
        //reads file in java. we need to pass the path of the file
        FileInputStream fileInputStream = new FileInputStream("configuration.properties");

        //initialize the object
        properties = new Properties();
        //load the contents of file to properties object
        properties.load(fileInputStream);
        fileInputStream.close();

    } catch (IOException e){
        e.printStackTrace();}
}

public static String getProperty(String key){
    return properties.getProperty(key);
}

}
