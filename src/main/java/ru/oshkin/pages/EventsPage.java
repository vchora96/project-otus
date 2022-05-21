package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(CardInfoPage.class.getName());

    @FindBy(xpath= "//p[contains(text(), 'События')]")
    private WebElement events;

    @FindBy (xpath = "//a[contains(@title, 'Календарь мероприятий')]")
    private WebElement calendar;

    @FindBy(css = "section.dod_new-events a")
    private List<WebElement> lessons;

    @FindBy(css = "span.dod_new-event__date-text")
    private List<WebElement> infoDateEvents;

    public EventsPage(WebDriver driver) {
        super(driver);
    }

   public void setEvents(){
        events.click();
        logger.info("Кликаем на события");

        calendar.click();
        logger.info("Кликаем на календарь событий");

        for (WebElement infoDateEvent : infoDateEvents) {
            final String text = infoDateEvent.getText();
            System.out.println(text);
        }
    }
}
