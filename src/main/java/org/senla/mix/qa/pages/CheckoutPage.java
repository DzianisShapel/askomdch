package org.senla.mix.qa.pages;

import org.openqa.selenium.support.ui.Select;
import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By billingAddressFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmail = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    private final By alternateCountryDropdown = By.id("select2-billing_country-container");
    private final By alternateStateDropdown = By.id("select2-billing_state-container");
    private final By countryDropdown = By.id("billing_country");

    private final By stateDropdown = By.id("billing_state");

    private final By cashOnDeliveryTransferRadioBtn = By.id("payment_method_cod");

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");




    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage load(){
        load("/checkout/");
        return this;
    }

    public CheckoutPage setFirstNameFld(String firstName){
        WebElement e = waitForElementToBeVisible(firstNameFld);
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutPage setLastNameFld(String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckoutPage setBillingAddressFld(String billingAddress){
        driver.findElement(billingAddressFld).clear();
        driver.findElement(billingAddressFld).sendKeys(billingAddress);
        return this;
    }

    public CheckoutPage setBillingCityFld(String billingCity){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(billingCity);
        return this;
    }

    public CheckoutPage setBillingPostCodeFld(String postCode){
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckoutPage setBillingEmailFld(String email){
        driver.findElement(billingEmail).clear();
        driver.findElement(billingEmail).sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder(){;
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return  setFirstNameFld(billingAddress.getFirstName()).
                setLastNameFld(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                setBillingAddressFld(billingAddress.getAddressLineOne()).
                setBillingCityFld(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                setBillingPostCodeFld(billingAddress.getPostalCode()).
                setBillingEmailFld(billingAddress.getEmail());
    }

    public CheckoutPage selectCountry(String countryName){

        Select dropdown = new Select(driver.findElement(countryDropdown));
        dropdown.selectByVisibleText(countryName);
        /*wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//li[text()= '" + countryName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();*/
        return this;
    }

    public CheckoutPage selectState(String stateName){
        Select dropdown = new Select(driver.findElement(stateDropdown));
        dropdown.selectByVisibleText(stateName);
        /* wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text() = '" + stateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();*/
        return this;
    }

    public CheckoutPage selectCashOnDeliveryTransfer(){
        waitForOverlaysToDisappear(overlay);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(cashOnDeliveryTransferRadioBtn));
        if (!e.isSelected()) {
            e.click();
        }
        return this;
    }

}
