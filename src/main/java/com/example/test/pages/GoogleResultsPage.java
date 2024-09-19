package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleResultsPage {
    private WebDriver driver;
    private By resultsStats = By.id("result-stats");

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isResultsStatsDisplayed() {
        WebElement stats = driver.findElement(resultsStats);
        return stats.isDisplayed();
    }
}