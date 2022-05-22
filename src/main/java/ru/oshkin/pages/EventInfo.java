package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;

public class EventInfo extends BasePage {

    private static final Logger logger = LogManager.getLogger(EventInfo.class.getName());

    private final int currentYear = LocalDate.now().get(ChronoField.YEAR);//2022
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy").withLocale(new Locale("ru"));

    @FindBy(css = "div.dod_new-event__time > span.dod_new-event__time-item:nth-child(1) > span.dod_new-event__date-text")
    private List<WebElement> infoDateEvents;

    @FindBy(css = "span.dod_new-events-dropdown__input-selected")
    private WebElement allEvents;

    @FindBy(xpath = "//a[contains(text(), 'ДОД')]")
    private WebElement dayOfOpenDoors;

    public EventInfo(WebDriver driver) {
        super(driver);
    }

    public void openEvent() {
        checkEventDates();

        allEvents.click();
        logger.info("Кликаем на все мероприятия");

        dayOfOpenDoors.click();
        logger.info("Кликаем на ДОД"); //todo: события с типом ДОД на данный момент не представлены на https://otus.ru
    }

    private void checkEventDates() {
        for (WebElement infoDateEvent : infoDateEvents) {
            String text = infoDateEvent.getText();
            boolean result = checkDate(text);
            if (!result) {
                throw new RuntimeException("Дата мероприятия не прошла проверку");
            }
        }
        logger.info("Все даты мероприятий прошли проверку");
    }

    /*
    Проверяем, что дата превышает текущую
     */
    private boolean checkDate(String date) { //date "19 мая"
        String text = date + " " + currentYear;//"19 мая 2022"
        LocalDate dodDate = LocalDate.parse(text, dateTimeFormatter);
        return dodDate.isAfter(LocalDate.now());
    }
}
