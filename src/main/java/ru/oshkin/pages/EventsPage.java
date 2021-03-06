package ru.oshkin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventsPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(EventsPage.class.getName());

    @FindBy(xpath = "//p[contains(text(), 'События')]")
    private WebElement events;

    @FindBy(xpath = "//a[contains(@title, 'Календарь мероприятий')]")
    private WebElement calendar;

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public EventInfo openEvents() {
        events.click();
        logger.info("Кликаем на события");
        wait.until(ExpectedConditions.textToBePresentInElement(calendar, "Календарь мероприятий"));

        calendar.click();
        logger.info("Кликаем на календарь событий");
        return new EventInfo(driver);
    }
}
