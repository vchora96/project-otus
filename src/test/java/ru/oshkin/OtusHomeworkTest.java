package ru.oshkin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.oshkin.pages.LogInPage;
import ru.oshkin.util.WebBrowserType;
import ru.oshkin.factory.WebDriverFactory;

import java.util.Locale;

public class OtusHomeworkTest {
    private WebDriver driver;
    private WebBrowserType type;


    @BeforeEach
    public void startUp() {
        //  clean test -Dbrowser=CHROME -Dlogin=macorax714@idurse.com -Dpass=Test12345
        String envVariable = System.getProperty("browser", "CHROME");
        this.type = WebBrowserType.valueOf(envVariable.toUpperCase(Locale.ROOT));
    }

//    @AfterEach
//    public void finish() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void setPrivetDataOtusTest() {
        driver = WebDriverFactory.create(type, null);

        new LogInPage(driver)
                .logInByUser()
                .openTesting()
                .validateCardInfo()
                .setEvents();

//        driver.quit();
//        driver = WebDriverFactory.create(type);
//        new LogInPage(driver).logInByUser();
    }

  /*  @Test
    public void setPrivetDataOtusWithOptionsTest() {
        driver = WebDriverFactory.create(type, options);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = WebDriverFactory.create(type, options);

        new LogInPage(driver)
                .logInByUser();
        driver.close();
        driver
    }*/
}
