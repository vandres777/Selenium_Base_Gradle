package com.example.test;

import com.example.test.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverConfig.getChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testSearchWikipedia() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("wikipedia");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement resultsStats = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

        //Assert.assertTrue(resultsStats.isDisplayed(), "Results page is not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(10000); // Espera de 10 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}