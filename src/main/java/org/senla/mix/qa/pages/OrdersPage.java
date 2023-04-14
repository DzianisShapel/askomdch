package org.senla.mix.qa.pages;

import org.senla.mix.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class OrdersPage extends BasePage {
    private final By viewOrdersBtn = By.cssSelector(".woocommerce-button.button.view");
    private final By orderDetails = By.cssSelector(".woocommerce-order-details__title");


    public OrdersPage(WebDriver driver) {
        super(driver);
    }
    public  OrdersPage viewOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewOrdersBtn)).click();
        return this;
    }

    public String getOrderDetailsTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails)).getText();
    }

    public OrdersPage load(){
        load("/account/orders");
        return this;
    }
}
