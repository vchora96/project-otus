package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestingCoursesInfoPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(TestingCoursesInfoPage.class.getName());

    private final int amountCourses = 12;

    @FindBy(css = "div[id='categories_id'] a[title='Тестирование']")
    private WebElement buttonTesting;

    @FindBy(css = "div.lessons a")
    private List<WebElement> lessons;

    public TestingCoursesInfoPage(WebDriver driver) {
        super(driver);
    }

    public CardInfoPage openTesting() {
        openTestingBlock();
        checkCards(this.amountCourses);
        clickFirstCard();
        return new CardInfoPage(driver);
    }

    private void clickFirstCard() {
        lessons.get(0).click();
        logger.info("Кликаем на первую карточку");
    }

    private void openTestingBlock() {
        driver.navigate().refresh();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonTesting));
        button.click();
        logger.info("Кликаем на раздел Тестирование");
    }

    private void checkCards(int expectedAmount) {
        int size = lessons.size();
        assertEquals(expectedAmount, size);
        logger.info(String.format("Отобразилось %s карточек", amountCourses));

    }
}
