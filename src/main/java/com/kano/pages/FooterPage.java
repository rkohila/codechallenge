package com.kano.pages;


import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {

    @FindBy(css = ".connected")
    private WebElement connected;

    @FindBy(css = ".lines")
    private WebElement linesOfCode;

    @FindBy(css = ".creations")
    private WebElement creations;

    @FindBy(css = ".footer")
    private WebElement footer;

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public FooterPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30);

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".footer")));
    }


    public boolean isFooterDisplayed(){

        webDriver.switchTo().defaultContent();

        /*WebElement iFrame= webDriver.findElement(By.name("Trade Desk Tracking - TTD_KANO_KANOWORLD_20161027_PD_S"));

        webDriver.switchTo().frame(iFrame);

        webDriver.switchTo().defaultContent();

        WebElement element = webDriver.findElement(By.cssSelector("[page='projects']"));*/

        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,250)", "");

         webDriverWait.until(ExpectedConditions.visibilityOf(footer));
        return footer.isDisplayed();
    }



    public boolean isConnectedDisplayed(){
        return connected.isDisplayed();
    }

    public boolean isLineOfCodeDisplayed(){
        return linesOfCode.isDisplayed();
    }

    public boolean isCreationDisplayed(){
        return creations.isDisplayed();
    }



}
