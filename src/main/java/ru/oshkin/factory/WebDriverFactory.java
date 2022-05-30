package ru.oshkin.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ru.oshkin.util.WebBrowserType;

public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class.getName());

    public static WebDriver create(WebBrowserType webDriverName, Capabilities options) {
        WebDriver driver;
        switch (webDriverName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOption = new ChromeOptions();
                chromeOption.merge(options);
                driver = options == null ? new ChromeDriver() : new ChromeDriver(chromeOption);
                logger.info("Создали драйвер для CHROME");
                return driver;
            case OPERA:
                WebDriverManager.operadriver().setup();
                OperaOptions operaOption = new OperaOptions();
                operaOption.merge(options);
                driver = options == null ? new OperaDriver() : new OperaDriver(operaOption);
                logger.info("Создали драйвер для OPERA");
                return driver;
            case MOZILLA:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOption = new FirefoxOptions();
                firefoxOption.merge(options);
                driver = options == null ? new FirefoxDriver() : new FirefoxDriver(firefoxOption);
                logger.info("Создали драйвер для MOZILLA");
                return driver;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverName);
        }
    }
}
