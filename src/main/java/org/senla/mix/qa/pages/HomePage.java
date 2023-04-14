package org.senla.mix.qa.pages;

import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.pages.components.AppHeader;
import org.senla.mix.qa.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;


public class HomePage  extends BasePage {

    private AppHeader myHeader;
    private ProductThumbnail productThumbnail;


    public HomePage(WebDriver driver) {
        super(driver);
        myHeader= new AppHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }


    public HomePage load(){
        load("/");
        return this;
    }

    public AppHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
}
