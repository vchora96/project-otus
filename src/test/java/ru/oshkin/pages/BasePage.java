package ru.oshkin.pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
}
