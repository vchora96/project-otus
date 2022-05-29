package ru.oshkin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.oshkin.factory.WebDriverFactory;
import ru.oshkin.pages.LogInPage;
import ru.oshkin.util.WebBrowserType;

import java.util.Locale;

public class OtusHomeworkTest {
    private WebDriver driver;
    private WebBrowserType type;
    private final String login = System.getProperty("login", "macorax714@idurse.com");
    private final String pass = System.getProperty("pass", "Test12345"); //пароль от тестовой УЗ
    private final int amountCourses = 12;

    @BeforeEach
    public void startUp() {
        String envVariable = System.getProperty("browser", "CHROME");
        this.type = WebBrowserType.valueOf(envVariable.toUpperCase(Locale.ROOT));
    }

    @AfterEach
    public void finish() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void setPrivetDataOtusTest() {
        driver = WebDriverFactory.create(type, null);

        new LogInPage(driver, login, pass)
                .logInByUser()
                .openTesting(amountCourses)
                .validateCardInfo()
                .openEvents()
                .openEvent();
    }
}
