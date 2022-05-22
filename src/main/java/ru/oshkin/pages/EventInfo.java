package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventInfo extends BasePage {

    private static final Logger logger = LogManager.getLogger(EventInfo.class.getName());

    @FindBy(css = "span.dod_new-event__date-text")
    private List<WebElement> infoDateEvents;

    @FindBy(css = "span.dod_new-events-dropdown__input-selected")
    private WebElement allEvents;

    @FindBy(xpath = "//a[contains(text(), 'ДОД')]")
    private WebElement dayOfOpenDoors;

    public EventInfo(WebDriver driver) {
        super(driver);
    }

    public void openEvent(){
        for (WebElement infoDateEvent : infoDateEvents) {
            final String text = infoDateEvent.getText();
            System.out.println(text); //todo: добавить поверку
        }

        allEvents.click();
        logger.info("Кликаем на все мероприятия");

        dayOfOpenDoors.click();
        logger.info("Кликаем на ДОД"); //todo: события с типом ДОД на данный момент не представлены на https://otus.ru
    }



}
