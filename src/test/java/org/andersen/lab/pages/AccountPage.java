package org.andersen.lab.pages;

import org.andersen.lab.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    private final By usernameFld =  By.cssSelector("#username");
    private final By passwordFld =  By.cssSelector("#password");
    private final By loginBtn =  By.cssSelector("button[value='Log in']");
    private final By contentMsg = By.cssSelector("div[id='content'] li:nth-child(1)");
    private final By orders  = By.cssSelector("li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders'] a");


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage login(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(username);
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginBtn).click();
        return this;
    }

    public String getContentMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contentMsg)).getText();
    }

    public OrdersPage navigateToOrders(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orders)).click();
        return new OrdersPage(driver);
    }

    public AccountPage load(){
        load("/account/");
        return this;
    }
}
