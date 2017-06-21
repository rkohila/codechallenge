package com.kano.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;


    @FindBy(css = ".cart-count.style-scope.kano-cart")
    private WebElement kanoCart;

    @FindBy(css = ".CartPage-itemNameLink")
    private WebElement cartItemName;

    @FindBy(css = ".CartPage-summaryItemValue.CartPage-summaryItemValue--total")
    private WebElement productPriceCurrency;


    public CartPage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver,30);
    }

    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public String getCartCount(){
        webDriverWait.until(ExpectedConditions.visibilityOf(kanoCart));
        return kanoCart.getText();
    }

    public String getCartItemName(){
        return cartItemName.getText();
    }

    public String getProductPriceCurrency(){
        return productPriceCurrency.getText();
    }

}
