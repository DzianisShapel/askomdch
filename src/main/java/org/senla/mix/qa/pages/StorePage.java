package org.senla.mix.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");

    private final By title = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");

    private final By filterBtn = By.xpath("//button[text()='Filter']");

    private final By leftSliderLocator = By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]");
    private final By productTitle = By.xpath("//h2[@class='woocommerce-loop-product__title']");

    private final By categoryDropdown = By.id("product_cat");

    private ProductThumbnail productThumbnail;


    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    public StorePage enterTextInSearchFld(String txt) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    public StorePage load() {
        load("/store");
        return this;
    }

    public ProductPage searchExactProduct(String txt) {
        enterTextInSearchFld(txt).clickSearchBtn();
        return new ProductPage(driver);
    }

    public StorePage clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    public StorePage increaseStartPriceTo(double value) {

        if (value < 10 ) throw new RuntimeException("Start price is 10");
        int width = driver.findElement(By.xpath("//div[@class='ui-slider-range ui-corner-all ui-widget-header']")).getSize().getWidth();
        double percent = value / 150;
        int xOffset = (int) (width * percent);
        Actions action = new Actions(driver);
        action.dragAndDropBy(driver.findElement(leftSliderLocator), xOffset, 0).build().perform();
        return this;
    }

    public StorePage clickFilterButton() {
        driver.findElement(filterBtn).click();
        wait.until(ExpectedConditions.urlContains("min_price="));
        return this;
    }

    public List<WebElement> getListOfProducts(){
        return driver.findElements(productTitle);
    }

    public StorePage selectCategory(String value){
        Select dropdown = new Select(driver.findElement(categoryDropdown));
        dropdown.selectByValue(value);
        return this;
    }
}
