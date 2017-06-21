package com.kano.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jey
 * Date: 21/06/17
 * Time: 01:15
 * To change this template use File | Settings | File Templates.
 */
public class MenuPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = "#primary-nav-items")
    private WebElement primaryNavMenu;


    @FindBy(css = ".menu-item>a>span")
    private List<WebElement> menuItems;

    public MenuPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30);
    }

    public boolean isPrimaryMenuDisplayed(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#primary-nav-items")));
        return primaryNavMenu.isDisplayed();
    }

    public List<String> getMenuItems(){
        List<String> menuItemList = new ArrayList<String>();
        for(WebElement webElement : menuItems){
            menuItemList.add(webElement.getText());
        }
        return menuItemList;
    }
    
    public void selectMenu(String menuItem){
        for(WebElement webElement : menuItems){
            if(webElement.getText().contains(menuItem)){
                webElement.click();
                break;
            }
        }
    }

    public void clickMake(){
        webDriver.findElement(By.cssSelector(".nav-menu-items>li:nth-child(2)")).click();
    }


}
