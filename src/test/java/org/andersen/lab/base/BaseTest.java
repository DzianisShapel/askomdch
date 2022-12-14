package org.andersen.lab.base;

import org.andersen.lab.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public synchronized void startDriver(@Optional String browser) {
        browser = System.getProperty("browser", browser);
        setDriver(new DriverManager().initializeDriver(browser));
    }

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
        Thread.sleep(100);
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0) {
            File logs = new File("logs.txt");
            FileWriter logWriter = new FileWriter(logs, true);
            for (LogEntry allLogRow : allLogRows) {
                logWriter.write(allLogRow.toString());
            }
            logWriter.flush();
            logWriter.close();
        }
        getDriver().quit();
    }

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }
}
