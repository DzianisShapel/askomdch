package org.andersen.lab.pages;

import org.andersen.lab.base.BasePage;
import org.andersen.lab.objects.Product;
import org.andersen.lab.pages.components.MyHeader;
import org.andersen.lab.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage  extends BasePage {

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;


    public HomePage(WebDriver driver) {
        super(driver);
        myHeader= new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public ProductPage navigateToProductPage(int id) throws IOException {
        driver.findElement(By.xpath("//h2[normalize-space()='"+ new Product(id).getName() + "']")).click();
        return new ProductPage(driver);
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
