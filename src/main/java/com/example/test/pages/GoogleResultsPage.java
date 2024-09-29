package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class GoogleResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By firstResult = By.cssSelector("h3");

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickFirstResult() {
        WebElement result = wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        result.click();
    }
}