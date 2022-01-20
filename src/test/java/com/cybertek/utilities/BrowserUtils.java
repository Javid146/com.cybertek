package com.cybertek.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*take list of web elements and convert into String list*/
    public static List<String>getElementsText(List<WebElement>ListEl){
        //given list web elements, extract the text of the elements into list of String
    List<String>listSt = new ArrayList<>();
    for(WebElement element :ListEl){
        listSt.add(element.getText());
    }
    return listSt;
    }


}
