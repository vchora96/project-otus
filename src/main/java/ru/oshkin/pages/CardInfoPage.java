package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardInfoPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(CardInfoPage.class.getName());

    @FindBy(css = ".course-header2__title")
    private WebElement title; //Название

    @FindBy(css = ".course-header2__subtitle")
    private WebElement subtitle; //Описание

//    @FindBy(css = "div.course-header2-bottom__content-items > div:nth-child(1) div.course-header2-bottom__content-item-text" +
//            " p.course-header2-bottom__item-text")
//    private WebElement durationCourse; // Продолжительность курса

//    @FindBy(css = "course-header2-bottom__content-items > div:nth-child(2) div.course-header2-bottom__content-item-text" +
//            " p.course-header2-bottom__item-text")
//    private WebElement format; // Формат

    public CardInfoPage(WebDriver driver) {
        super(driver);
    }

    public EventsPage validateCardInfo(){
        final String titleText = title.getText();
        Assertions.assertNotEquals("", titleText);
        logger.info("Проверяем, что название заполнено");

        final String subtitleText = subtitle.getText();
        Assertions.assertNotEquals("", subtitleText);
        logger.info("Описание курса заполнено");

        return new EventsPage(driver);

//        final String durationCourseText = durationCourse.getText();
//        Assertions.assertNotEquals("", durationCourseText);
//        logger.info("Продолжительность курса заполнена");

//        final String formatText = format.getText();
//        Assertions.assertNotEquals("", formatText);
//        logger.info("Формат курса заполнен");
    }

}
