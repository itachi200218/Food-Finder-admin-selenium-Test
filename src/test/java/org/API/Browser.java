package org.API;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
    WebDriver driver;
    public Browser(WebDriver driver) {
        this.driver = driver ;
    }
    public  WebDriver chrome(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    public WebDriver edge(String url) {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}