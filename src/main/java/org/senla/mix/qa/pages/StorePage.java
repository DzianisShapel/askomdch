package org.senla.mix.qa.pages;

import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");

    private final By title = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");

    private ProductThumbnail productThumbnail;


    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public StorePage enterTextInSearchFld(String txt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    public StorePage load() {
        load("/store");
        return this;
    }

    public ProductPage searchExactProduct(String txt) {
        enterTextInSearchFld(txt).clickSearchBtn();
        return new ProductPage(driver);
    }

    public StorePage clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

}
