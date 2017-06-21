package com.kano.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: Jey
 * Date: 21/06/17
 * Time: 01:32
 * To change this template use File | Settings | File Templates.
 */
public class ProjectPage {


    private WebDriver webDriver;
    private WebDriverWait webDriverWait;



    public ProjectPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30);
        webDriverWait.until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(org.openqa.selenium.WebDriver webDriver) {
                System.out.println("webDriver.getCurrentUrl() = " + webDriver.getCurrentUrl());
                return webDriver.getCurrentUrl().contains("projects");
            }
        });





    }


}
