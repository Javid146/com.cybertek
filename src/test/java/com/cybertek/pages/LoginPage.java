package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /*  TODO Object repository -->
     COllection of web elements used in testing, way of storing elements in framework
    *   TODO Page Object model -->
    * is a design pattern in selenium used to create object repository.
    * Page object model is creating a mirror of each page of our application in a special class by
    * creating variable and methods for elements and actions of this class*/
    public LoginPage(){
        //page object classes need constructor. Here we need to call initElements
        //from selenium and pass a webdriver object and this class as parameter
        PageFactory.initElements(Driver.getDriver(), this);
    }

//FindBy --> IS USED to provide LOCATORS for web element
    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement login;

    @FindBy(css=".alert-error>div")
    public WebElement errorMessage;


    public void LoginPage(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
    }
}
