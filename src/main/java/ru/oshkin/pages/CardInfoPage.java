package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardInfoPage {

    private static final Logger logger = LogManager.getLogger(CardInfoPage.class.getName());

    @FindBy(css = ".course-header2__title")
    private WebElement title; //Название

    @FindBy(css = ".course-header2__subtitle")
    private WebElement subtitle; //Описание

    @FindBy(css = "course-header2-bottom__content-items > div:nth-child(1) div.course-header2-bottom__content-item-text" +
            " p.course-header2-bottom__item-text")
    private WebElement durationCourse; // Продолжительность курса

    @FindBy(css = "course-header2-bottom__content-items > div:nth-child(2) div.course-header2-bottom__content-item-text" +
            " p.course-header2-bottom__item-text")
    private WebElement format; // Формат

    public void setCardInfo(){
        title.click();
        logger.info("кликаем на название ");

    }

}
