package org.andersen.lab.pages;

import org.andersen.lab.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");
    private final By applyCouponBtn = By.cssSelector("button[value='Apply coupon']");
    private final By couponCodeFld = By.cssSelector("#coupon_code");
    private final By subTotal = By.cssSelector("tr[class='cart-subtotal'] bdi:nth-child(1)");
    private final By total = By.cssSelector("tr[class='order-total'] bdi:nth-child(1)");
    private final By shippingAmount = By.cssSelector("tr[class='woocommerce-shipping-totals shipping'] bdi:nth-child(1)");
    private final By stateTax = By.cssSelector("td[data-title='CA State Tax'] span[class='woocommerce-Price-amount amount']");

    private final By alertFld = By.cssSelector("div[role='alert']");

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartPage load(){
        load("/cart/");
        return this;
    }

    public String getProductName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public List<String> getProductsFromCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        List<WebElement> orderProducts = driver.findElements(productName);
        List<String> orderProductsName = new ArrayList<>();
        for (WebElement  orderProduct: orderProducts) {
            orderProductsName.add(orderProduct.getText());
        }
        return orderProductsName;
    }

    public String getCouponName(String coupon){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr[class='cart-discount coupon-" + coupon + "'] th"))).getText();
    }

    public  String getShippingAmount() {
        String shippingAmountString = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAmount)).getText();
        String formattedShippingAmount = shippingAmountString.replace("$","");
        return formattedShippingAmount;
    }

    public String getTotal(){
        String totalString = wait.until(ExpectedConditions.visibilityOfElementLocated(total)).getText();
        String formattedTotal = totalString.replace("$","");
        return formattedTotal;
    }

    public String getSubTotal(){
        String subTotalString = wait.until(ExpectedConditions.visibilityOfElementLocated(subTotal)).getText();
        String formattedSubTotal = subTotalString.replace("$","");
        return formattedSubTotal;
    }

    public String getStateTax(){
        String stateTaxString = wait.until(ExpectedConditions.visibilityOfElementLocated(stateTax)).getText();
        String formattedStateTax = stateTaxString.replace("$","");
        return formattedStateTax;
    }



    public String getAlertFld() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertFld)).getText();
    }

    public CartPage applyCoupon(String coupon) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponCodeFld)).sendKeys(coupon);
        driver.findElement(applyCouponBtn).click();
        return this;
    }

    public CheckoutPage checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        return new CheckoutPage(driver);
    }
}
