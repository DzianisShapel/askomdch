package org.senla.mix.qa.pages.components;

import org.senla.mix.qa.base.BasePage;
import org.senla.mix.qa.pages.ContactPage;
import org.senla.mix.qa.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppHeader extends BasePage {
    public AppHeader(WebDriver driver) {
        super(driver);
    }

    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    private final By contactUsLink = By.xpath("//a[text()='Contact Us']");


    public StorePage navigateToStorePage(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

    public ContactPage navigateToContactPage(){
        driver.findElement(contactUsLink).click();
        return new ContactPage(driver);
    }
}
