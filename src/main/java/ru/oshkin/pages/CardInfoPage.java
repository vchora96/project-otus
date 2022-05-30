package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardInfoPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CardInfoPage.class.getName());

    @FindBy(css = ".course-header2__title")
    private WebElement title; //Название

    @FindBy(css = ".course-header2__subtitle")
    private WebElement subtitle; //Описание

    @FindBy(css = "div.course-header2-bottom__content-items > div:nth-child(1) > div:nth-child(2) p.course-header2-bottom__item-text")
    private WebElement durationCourse; // Продолжительность курса

    @FindBy(css = "div.course-header2-bottom__content-items > div:nth-child(2) > div:nth-child(2) p.course-header2-bottom__item-text")
    private WebElement format; // Формат

    public CardInfoPage(WebDriver driver) {
        super(driver);
    }

    public EventsPage validateCardInfo() {
        readTitle();
        readSubTitle();
        readDuration();
        readFormat();
        return new EventsPage(driver);
    }

    private void readTitle() {
        String titleText = title.getText();
        Assertions.assertNotEquals("", titleText);
        logger.info("Проверяем, что название заполнено");
    }

    private void readSubTitle() {
        String subtitleText = subtitle.getText();
        Assertions.assertNotEquals("", subtitleText);
        logger.info("Описание курса заполнено");
    }

    private void readDuration() {
        String durationCourseText = durationCourse.getText();
        Assertions.assertNotEquals("", durationCourseText);
        logger.info("Продолжительность курса заполнена");
    }

    private void readFormat() {
        String formatText = format.getText();
        Assertions.assertNotEquals("", formatText);
        logger.info("Формат курса указан");
    }
}
