package com.example.test.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverConfig {

    public static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
        //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // sirve para evitar el mensaje de Chrome que indica que se está controlando el navegador
        options.addArguments("--headless");
        options.addArguments("--disable-gpu"); // Opcional, pero recomendado para evitar problemas en algunas configuraciones
        //options.addArguments("--window-size=1920,1080"); // Opcional, para establecer el tamaño de la ventana
        return new ChromeDriver(options);
    }

    public static WebDriver getEdgeDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // sirve para evitar el mensaje de Chrome que indica que se está controlando el navegador
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu"); // Opcional, pero recomendado para evitar problemas en algunas configuraciones
        //options.addArguments("--window-size=1920,1080"); // Opcional, para establecer el tamaño de la ventana
        return new EdgeDriver(options);
    }

    public static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        //options.addArguments("--window-size=1920,1080");
        return new FirefoxDriver(options);
    }
}
//dejo solo lienas de modi headless para ejecutar en jenkins
