package org.senla.mix.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.senla.mix.qa.constants.DriverType;

public class DriverManager {

    public WebDriver initializeDriver(String browser) {
        WebDriver driver;

        switch (DriverType.valueOf(browser)) {
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name: " + browser);
        }
        return driver;
    }
}
