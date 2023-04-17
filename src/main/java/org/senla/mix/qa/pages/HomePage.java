package org.senla.mix.qa.pages;

import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.pages.components.AppHeader;
import org.senla.mix.qa.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;


public class HomePage  extends BasePage {

    private AppHeader appHeader;
    private ProductThumbnail productThumbnail;


    public HomePage(WebDriver driver) {
        super(driver);
        appHeader = new AppHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }


    public HomePage load(){
        load("/");
        return this;
    }

    public AppHeader getAppHeader() {
        return appHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
}
