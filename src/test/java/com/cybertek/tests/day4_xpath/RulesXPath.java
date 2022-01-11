package com.cybertek.tests.day4_xpath;

public class RulesXPath {


    /* Different ways of relative xpath
    E = element; A = attribute; t = value;

    //E[@A='t']
    //button[@onclick='button1()']
    BELOW MEANS YOU CAN USE ANY ATTRIBUTE.
     * MEANS IT REPRESENTS ALL ATTRIBUTES
    //*[@A='t']

    //E[@A='t' and @A='t']
    //button[@onclick='button1()' and @class='btn btn-primary']
     */

    /*DYNAMIC ATTRIBUTE
    *
    *A button whose id starts with button_
    * <button id="button_check">Button 3</button>
    * <button id="button_cool">Button 3</button>
    *  button_cool
    * button_check
    * button three
    *
    * //button[starts-with(@id, 'button_')]
    * //button[ends-with(@id, '_button')]
    * //button[contains(@id,'_button')]
    *
    *
    * EXACT TEXT
    * <button id="old button">Button 3</button>
    * Any element with certain exact text
    * //E[.='t']
    * //button[.='Button 3']
    * Any element with tag button and text button3
    *
    * PARTIAL TEXT
    *<button id="old button">Button 3</button>
    * ELEMENTS THAT CONTAIN CERTAIN EXACT TEXT PARTIALLY
    * //E[contains(text()/ 'h')];
    * //button[contains(text(), 'utton3')]

     * */




}
