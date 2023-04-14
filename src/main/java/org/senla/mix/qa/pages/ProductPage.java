package org.senla.mix.qa.pages;

import org.senla.mix.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private final By productTitle = By.cssSelector(".product_title.entry-title");


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public ProductPage load(){
        load("/product/dark-grey-jeans/");
        return this;
    }

}
