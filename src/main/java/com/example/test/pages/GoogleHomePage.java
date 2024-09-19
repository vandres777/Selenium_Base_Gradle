package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    private WebDriver driver;
    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(searchTerm);
    }

    public void submitSearch() {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.submit();
    }
}