package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestingCoursesInfoPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(TestingCoursesInfoPage.class.getName());

    @FindBy(css = "div[id='categories_id'] a[title='Тестирование']")
    private WebElement buttonTesting;

    @FindBy(css = "div.lessons a")
    private List<WebElement> lessons;

    public TestingCoursesInfoPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
    }

    public void openTesting(){
        final WebElement until = wait.until(ExpectedConditions.elementToBeClickable(buttonTesting));
        until.click();
        logger.info("Кликаем на раздел Тестирование");

        final int size = lessons.size();
        logger.info("");

    }



}
