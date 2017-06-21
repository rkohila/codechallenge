package com.kano.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jey
 * Date: 21/06/17
 * Time: 00:30
 * To change this template use File | Settings | File Templates.
 */
public class RegionModal {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = ".LocationModal-optionButton>a")
    private List<WebElement> locationOptions;

    @FindBy(css = ".Modal")
    private WebElement regionModal;

    public RegionModal(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver,30);
    }



    public boolean isRegionSelectionModalDisplayed(){
        return regionModal.isDisplayed();
    }

    public void clickToContinueCountrySelection(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(locationOptions));
        for(WebElement webElement : locationOptions){
            if(webElement.getText().contains("CONTINUE TO THE US STORE")){
                webElement.click();
            }

        }
    }
}
