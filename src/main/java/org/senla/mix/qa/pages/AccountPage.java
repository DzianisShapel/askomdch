package org.senla.mix.qa.pages;

import org.senla.mix.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.senla.mix.qa.objects.User;

public class AccountPage extends BasePage {
    private final By usernameForLogin =  By.cssSelector("#username");
    private final By usernameForRegistration = By.cssSelector("#reg_username");
    private final By emailForRegistration = By.cssSelector("#reg_email");
    private final By passwordForRegistration = By.cssSelector("#reg_password");
    private final By passwordForLogin =  By.cssSelector("#password");
    private final By registerButton = By.xpath("//button[@value='Register']");
    private final By loginBtn =  By.cssSelector("button[value='Log in']");
    private final By orders  = By.cssSelector("li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders'] a");

    private final By accountContent = By.cssSelector(".woocommerce-MyAccount-content");

    private final By errorMessage = By.cssSelector("div[id='content'] li:nth-child(1)");



    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage login(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameForLogin)).sendKeys(username);
        driver.findElement(passwordForLogin).sendKeys(password);
        driver.findElement(loginBtn).click();
        return this;
    }

    public AccountPage register(User user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameForRegistration)).sendKeys(user.getUsername());
        driver.findElement(passwordForRegistration).sendKeys(user.getPassword());
        driver.findElement(emailForRegistration).sendKeys(user.getEmail());
        driver.findElement(registerButton).click();
        return this;
    }

    public String getAccountContent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountContent)).getText();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
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
