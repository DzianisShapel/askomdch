package org.andersen.lab.pages;

import org.andersen.lab.base.BasePage;
import org.andersen.lab.pages.components.MyHeader;
import org.andersen.lab.pages.components.ProductThumbnail;
import org.openqa.selenium.WebDriver;



public class HomePage  extends BasePage {

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;


    public HomePage(WebDriver driver) {
        super(driver);
        myHeader= new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }


    public HomePage load(){
        load("/");
        return this;
    }

    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
}
