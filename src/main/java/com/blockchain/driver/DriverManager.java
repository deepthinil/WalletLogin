package com.blockchain.driver;

import com.blockchain.util.PropKey;
import com.blockchain.util.PropertyReader;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

class UnsupportedBrowserException extends Exception {
    public UnsupportedBrowserException(String message) {
        super(message);
    }
}

public class DriverManager {

    private static final String FIREFOX = "FIREFOX";
    private static final String CHROME = "CHROME";
    private static final String SAFARI = "SAFARI";
    public static PropertyReader prop;

    protected static WebDriver driver = null;

    @BeforeAll
    public static void setUp() {

        prop = PropertyReader.getInstance();
        driver = getDriver();
    }

    public static WebDriver getDriver() {
        try {
            if (driver == null)
                init();
        } catch (UnsupportedBrowserException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Driver initialize failure" + ex.getMessage());
        } finally {
            return driver;
        }
    }

    private static String getBrowserName() {
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            return prop.getProperty(PropKey.BROWSER.getPropVal());
        }
        return browserName;
    }

    @Before
    public static void init() throws UnsupportedBrowserException {

        if (getBrowserName().equalsIgnoreCase(FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
            driver = new FirefoxDriver();

        } else if (getBrowserName().equalsIgnoreCase(CHROME)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/macM1/chromedriver");

            ChromeOptions chromeOptions = new ChromeOptions();

            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.setAcceptInsecureCerts(true);

            driver = new ChromeDriver(chromeOptions);

        } else if (getBrowserName().equalsIgnoreCase(SAFARI)) {
            System.setProperty("webdriver.safari.driver", "src/test/resources/drivers/safaridriver");
            driver = new SafariDriver();

        } else {
            throw new UnsupportedBrowserException("Test run only support browser modes Chrome or Firefox");
        }
    }

    public static void quitDriver() {
        if (driver != null)
            driver.quit();
    }

    @AfterAll
    public static void tearDown() {
        quitDriver();
    }

    @BeforeEach
    public void beforeEachMethod() {
        getDriver().manage().deleteAllCookies();
    }

}
