package ru.oshkin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestingCoursesInfoPage {
    @FindBy(css = "div[id='categories_id'] a[title='Тестирование']")
    private WebElement buttonTesting;

    @FindBy(css = "div.lessons a")
    private List<WebElement> lessons;


}
