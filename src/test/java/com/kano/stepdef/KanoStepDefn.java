package com.kano.stepdef;

import com.kano.pages.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class KanoStepDefn {


    private WebDriver driver;
    final static String HOME_PAGE_URL = "https://kano.me";
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private MenuPage menuPage;
    private ProjectPage projectPage;
    private FooterPage  footerPage;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("^the user is in the kano home page$")
    public void the_user_is_in_the_kano_home_page() throws Throwable {
        homePage = PageFactory.initElements(driver,HomePage.class);
        driver.get(HOME_PAGE_URL);

    }

    @When("^user selects a (.*)$")
    public void user_selects_a_Computer_Kit_Bundle(String productName) throws Throwable {
        homePage.selectProduct(productName);

    }

    @And("^user is in the product's page$")
    public void user_is_in_the_product_s_page() throws Throwable {
        productPage = PageFactory.initElements(driver,ProductPage.class);
        Assert.assertTrue("User is not in product page :",productPage.getCurrentUrl().contains("products"));
    }

    @And("^user decides to buy a (.*)$")
    public void user_decides_to_buy_a_computer_kit_bundle(String productName) throws Throwable {
       Assert.assertTrue("Product Name is not displayed Product's Page :",productPage.getBundleTitle().equals(productName));
       productPage.clickBuyNow();
    }

    @Then("^user is in the cart page$")
    public void user_is_in_the_cart_page() throws Throwable {
        cartPage = PageFactory.initElements(driver,CartPage.class);
        Assert.assertTrue("User is not in Cart page :",cartPage.getCurrentUrl().contains("cart"));
        Assert.assertTrue("Selected Product is not added to cart :",cartPage.getCartCount().contains("1"));
    }

    @And("^the (.*) should be added in the basket.$")
    public void the_Computer_Kit_Bundle_should_be_added_in_the_basket(String productName) throws Throwable {
        Assert.assertTrue("Cart doesn't displays selected product :",cartPage.getCartItemName().equals(productName));
    }


    @When("^user decides to change the country to (.*)$")
    public void user_decides_to_change_the_country_to_US(String regionName) throws Throwable {
        homePage.changeRegion(regionName);
    }

    @And("^user confirms the country$")
    public void user_confirms_the_country() throws Throwable {
        RegionModal regionModal = PageFactory.initElements(driver,RegionModal.class);
        Assert.assertTrue("Region Selection Modal is not displayed :",regionModal.isRegionSelectionModalDisplayed());
        regionModal.clickToContinueCountrySelection();
    }


    @Then("^(.*) displays in the country selection$")
    public void US_displays_in_the_country_selection(String regionName) throws Throwable {
        Assert.assertEquals("Region Name is not changed :", regionName, homePage.getSelectedRegion());

    }

    @Then("^the currency is shown in USD$")
    public void the_currency_is_shown_in_USD() throws Throwable {
        Assert.assertEquals("$", productPage.getProductPriceCurrency());
    }

    @And("^the currency should be in USD$")
    public void the_currency_should_be_in_USD() throws Throwable {
        Assert.assertTrue(" Price Currency doesn't contains USD Symbol :", cartPage.getProductPriceCurrency().contains("$"));

    }

    @Then("^user expected to view the menu items$")
    public void user_expected_to_view_the_menu_items(List<String> menuItems) throws Throwable {
        menuPage = PageFactory.initElements(driver,MenuPage.class);
        assertThat(menuItems, is(menuPage.getMenuItems()));

    }

    @And("^user click (.*) from menu$")
    public void user_click_Make_from_menu(String menuItem) throws Throwable {
        menuPage.selectMenu(menuItem);
//        menuPage.clickMake();

    }


    @Then("^user is in kano's project page$")
    public void user_is_in_kano_s_project_page() throws Throwable {
        projectPage = PageFactory.initElements(driver,ProjectPage.class);
    }

    @And("^user views Connected Kanos in footer$")
    public void user_views_Connected_Kanos_in_footer() throws Throwable {
        footerPage = PageFactory.initElements(driver,FooterPage.class);
        Assert.assertTrue("Footer is not displayed in Project Page :", footerPage.isFooterDisplayed());
        Assert.assertTrue("Connected Kanos is not displayed in footer :", footerPage.isConnectedDisplayed());
    }

    @And("^user views Lines of code in footer$")
    public void user_views_Lines_of_code_in_footer() throws Throwable {
        Assert.assertTrue("Lines of code is not displayed in footer :", footerPage.isLineOfCodeDisplayed());
    }

    @And("^user views Creations in footer$")
    public void user_views_Creations_in_footer() throws Throwable {
        Assert.assertTrue("Creations Shared  is not displayed in footer :", footerPage.isCreationDisplayed());

    }
}
