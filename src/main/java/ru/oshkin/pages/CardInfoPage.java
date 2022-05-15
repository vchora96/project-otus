package ru.oshkin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardInfoPage {

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

}
