package org.senla.mix.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.senla.mix.qa.base.BasePage;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    private final By contactEmail = By.xpath("//strong[normalize-space()='askomdch@gmail.com']");

    public Boolean checkContactEmailIsPresent(){
        return driver.findElement(contactEmail).isDisplayed();
    }
}
