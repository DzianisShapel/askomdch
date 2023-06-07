package org.senla.mix.qa.base;


import io.qameta.allure.Muted;
import org.senla.mix.qa.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;


public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public synchronized void startDriver() {
        String browser = System.getProperty("browser");
        setDriver(new DriverManager().initializeDriver(browser));
    }

    @AfterMethod
    public synchronized void quitDriver() throws InterruptedException, IOException {
       /* Thread.sleep(100);
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
        }*/
        getDriver().quit();
    }

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }
}
