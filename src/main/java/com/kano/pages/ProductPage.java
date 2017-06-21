package com.kano.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = "#BundleDisplay-actionPrimary--kano-complete")
    private WebElement buyNowBtn;


    @FindBy(css = ".BundleDisplay-title")
    private WebElement bundleTitle;

    @FindBy(css = ".BundleDisplay-priceCurrency")
    private WebElement bundlePriceCurrency;



    public ProductPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,30);
        webDriverWait.until(new Predicate<WebDriver>() {
            @Override
            public boolean apply(org.openqa.selenium.WebDriver webDriver) {
                return webDriver.getCurrentUrl().contains("products");
            }
        });

    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void clickBuyNow(){
        buyNowBtn.click();
    }

    public String getBundleTitle(){
        return bundleTitle.getText();
    }

    public String getProductPriceCurrency(){
        return bundlePriceCurrency.getText();
    }

}
