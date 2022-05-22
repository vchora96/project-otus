package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LogInPage.class.getName());
    private final String login;
    private final String pass;

    @FindBy(xpath = "//input[@type='text' and @placeholder='Электронная почта']")
    private WebElement mail;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Введите пароль']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement button;

    @FindBy(css = "p.header2-menu__item-text.header2-menu__item-text__username")
    private WebElement userButton;

    @FindBy(xpath = "//a[@title ='Личный кабинет']")
    private WebElement personalAccountButton;

    @FindBy(xpath = "//a[@title ='О себе']")
    private WebElement aboutUserButton;

    @FindBy(css = "jdiv.closeIcon_f9a1")
    private WebElement chatCross;

    public LogInPage(WebDriver driver, String login, String pass) {
        super(driver);
        this.login = login;
        this.pass = pass;
    }

    public TestingCoursesInfoPage logInByUser() {
        openSite();

        closeChat();

        setLogin();
        setPassword();
        authorize();

        return new TestingCoursesInfoPage(driver);
    }

    private void closeChat() {
        try {
            if (chatCross.isDisplayed()) {
                chatCross.click();
                logger.info("Закрываем всплывающее окно чата");
            }
        } catch (Exception ex) {
            logger.error("Не удалось закрыть чат", ex);
        }
    }

    private void setLogin() {
        mail.click();
        mail.sendKeys(login);
        logger.info("Ввели почту");
    }

    private void setPassword() {
        password.click();
        password.sendKeys(pass);
        logger.info("Ввели пароль");
    }

    private void authorize() {
        button.submit();
        logger.info("Попытка авторизации");
    }
}
