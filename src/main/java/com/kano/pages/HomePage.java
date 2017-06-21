package com.kano.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = ".ProductListingItem-title")
    private List<WebElement> productTitleElement;

    @FindBy(css = ".current-region.style-scope.kano-cart>span")
    private WebElement currentRegion;


    @FindBy(css = ".region-label.style-scope.kano-cart")
    private List<WebElement> otherRegionLabels;

     public HomePage(WebDriver webDriver){
         this.webDriver = webDriver;
         this.webDriverWait = new WebDriverWait(webDriver,30);
     }

    public void selectProduct(String productName){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(productTitleElement));
        for(WebElement webElement : productTitleElement){
            if(webElement.getText().equals(productName)){
                webElement.click();
            }
        }
    }


    public void changeRegion(String regionName){
        currentRegion.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(otherRegionLabels));
        for(WebElement webElement : otherRegionLabels) {
            if(webElement.getText().equals(regionName)){
                webElement.click();
            }
        }
    }

    public String getSelectedRegion(){
        return currentRegion.getText();
    }


}
