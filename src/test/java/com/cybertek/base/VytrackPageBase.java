package com.cybertek.base;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class VytrackPageBase {

    public VytrackPageBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className ="oro-subtitle")
    public WebElement pageHeader;

    @FindBy(xpath = "//span[contains(text(), 'Fleet')] [@class='title title-level-1']")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles'] [@class='title title-level-2']")
    public WebElement vehicles;

    @FindBy (xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement accountHolderName;

    @FindBy (css = ".title-level-1")
    public List<WebElement> menu1Options;

    //FindAll alone has to find all the elements searched. All locators should match.
    //but if FindAll goes with Findby it means either all or one locator should match
    //@FindAll                                                           //todo/////////////////////////////////////////
    //@FindBy


    public void changeMenu(String menu1, String menu2) throws InterruptedException{
        //locate menu1 from vytrack website
        String menu1X = "//span[contains(text(), '"+menu1+"')] [@class='title title-level-1']";
        WebElement menu1El = Driver.getDriver().findElement(By.xpath(menu1X));
        //menu2 -> (dropdown menu on vytrack site)
        String menu2X = "//span[.='"+menu2+"'] [@class='title title-level-2']";
        WebElement menu2El = Driver.getDriver().findElement(By.xpath(menu2X));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        menu1El.click();
        wait.until(ExpectedConditions.elementToBeClickable(menu2El));
        //Thread.sleep(4000);
        menu2El.click();
    }






}
