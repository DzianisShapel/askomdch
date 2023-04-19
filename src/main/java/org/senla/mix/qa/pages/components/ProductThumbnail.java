package org.senla.mix.qa.pages.components;

import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductThumbnail  extends BasePage {

    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    private final By productPrice = By.xpath("//span[@class='price']");

    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    public ProductThumbnail clickAddToCartBtn(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
        return this;
    }

    private By getAddToCartBtnElement(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public String getPrice(){
        return driver.findElement(productPrice).getText().substring(1,3);
    }

    public CartPage clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage(driver);
    }
}
