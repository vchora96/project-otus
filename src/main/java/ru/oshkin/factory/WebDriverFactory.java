package ru.oshkin.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.opera.OperaDriver;
import ru.oshkin.util.WebBrowserType;

public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class.getName());

    public static WebDriver create(WebBrowserType webBrowserType, MutableCapabilities options) {
        WebDriver driver;
        switch (webBrowserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = options == null ? new ChromeDriver() : new ChromeDriver(options);
                logger.info("Создали драйвер для CHROME");
                return driver;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = options == null ? new OperaDriver() : new OperaDriver(options);
                logger.info("Создали драйвер для OPERA");
                return driver;
            case MOZILLA:
                WebDriverManager.firefoxdriver().setup();
                driver = options == null ? new FirefoxDriver() : new FirefoxDriver(options);
                logger.info("Создали драйвер для MOZILLA");
                return driver;
            default:
                throw new IllegalStateException("Unexpected value: " + webBrowserType);
        }
    }
}
