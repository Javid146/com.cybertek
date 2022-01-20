package com.cybertek.tests.day4_xpath;

public class RulesXPath {


    /* Different ways of relative xpath
    E = element; A = attribute; t = value (text);

    //E[@A='t']
    //button[@onclick='button1()']
    BELOW MEANS YOU CAN USE ANY ATTRIBUTE.
     TODO (*) star MEANS IT REPRESENTS ALL ATTRIBUTES
    //*[@A='t']

    //E[@A='t' and @A='t']
    //button[@onclick='button1()' and @class='btn btn-primary']             //TODO
     */

    /*DYNAMIC ATTRIBUTE TODO //////////
    *
    *A button whose id starts, ends, contains button
    * <button id="button_check">Button 3</button>
    * <button id="button_cool">Button 3</button>
    *  button_check
    * button_cool
    *
    * //button[starts-with(@id, 'button_')]                      TODO///////////
    * //button[ends-with(@id, '_button')]
    * //button[contains(@id,'_button')]
    *
    *
    * EXACT TEXT
    *
    * Any element with certain exact text
    * <button id="old button">Button 3</button>
    * //E[.='text']    TODO dot means id
    * //button[.='Button 3']                         TODO
    * Any element with tagname 'button' and text 'button3'  TODO
    *
    *
    * PARTIAL TEXT
    *
    * ELEMENTS THAT CONTAINs CERTAIN EXACT TEXT PARTIALLY
    * <button id="old button">Button 3</button>
    * //E[contains(text(), 'h')];
    * //button[contains(text(), 'utton3')]        TODO
    *
    *   //TODO In css .(dot) means class. Just put . and write class name after it.
        //.nav-link"
        System.out.println(button.getText());
        //if element has multiple classes we do: .col-4.col-md-4
        WebElement butt2 = driver.findElement(By.cssSelector(".col-4.col-md-4"));

*    //button[1] -> this xpath works  if elements are siblings. so browser will find button[2], button[3] and etc.
            * But if elements are not siblings, then we do:
            * 1. Write xpath that matches similar elements. For ex: like below:
            //span[@class='a-size-base-plus a-color-base a-text-normal']
            2. TODO Wrap xpath in PARENTHESIS AND ADD INDEX AT THE END:
            * (//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]
            * THIS METHOD WILL FIND ALL THE SIMILAR ELEMENTS. ALL YOU NEED TO DO IS TO CHANGE THE INDEX
        * (//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]
                * (//span[@class='a-size-base-plus a-color-base a-text-normal'])[4]*/

    //TODO in CSS # MEANS ID, AS . MEANS CLASS///////////////////////////////////////////////////////////////////////////////





}
