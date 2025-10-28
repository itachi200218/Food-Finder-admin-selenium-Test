package org.API;

import org.openqa.selenium.*;
import java.io.File;
import java.util.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Boots {
    WebDriver driver;
    WebDriverWait wait;

    public Boots(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void id(String id, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(value);
    }

    public void xpath(String xpath, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(value);
    }

    public void cssSelector(String cssSelector, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).sendKeys(value);
    }

    public void name(String name, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name))).sendKeys(value);
    }

    public void click(String locatorType, String locatorValue) {
        By locator;

        if (locatorType.equalsIgnoreCase("id")) {
            locator = By.id(locatorValue);
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            locator = By.xpath(locatorValue);
        } else if (locatorType.equalsIgnoreCase("cssSelector")) {
            locator = By.cssSelector(locatorValue);
        } else if (locatorType.equalsIgnoreCase("name")) {
            locator = By.name(locatorValue);
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void action(String locatorType, String locatorValue, int xOffset) {
        WebElement slider = null;

        if (locatorType.equalsIgnoreCase("id")) {
            slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
        } else if (locatorType.equalsIgnoreCase("name")) {
            slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
        } else if (locatorType.equalsIgnoreCase("css")) {
            slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, xOffset, 0).perform();
    }

    public void jsexe(String locatorType, String locatorValue, int value) {
        String selector = "";

        if (locatorType.equalsIgnoreCase("id")) {
            selector = "#" + locatorValue;
        } else if (locatorType.equalsIgnoreCase("name")) {
            selector = "[name='" + locatorValue + "']";
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            throw new IllegalArgumentException("JavaScript cannot use XPath directly. Use CSS selectors instead.");
        } else if (locatorType.equalsIgnoreCase("cssSelector")) {
            selector = locatorValue;
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('" + selector + "').noUiSlider.set(" + value + ");");
    }

    public void TextRadio(String locatorType, String groupLocator, String visibleText) {
        List<WebElement> radioButtons;

        if (locatorType.equalsIgnoreCase("cssSelector")) {
            radioButtons = driver.findElements(By.cssSelector(groupLocator));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            radioButtons = driver.findElements(By.xpath(groupLocator));
        } else if (locatorType.equalsIgnoreCase("name")) {
            radioButtons = driver.findElements(By.name(groupLocator));
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }

        for (WebElement radio : radioButtons) {
            if (radio.getText().equalsIgnoreCase(visibleText)) {
                if (!radio.isSelected()) {
                    radio.click();
                }
                break;
            }
        }
    }

    public void ValueRadio(String locatorType, String groupLocator, int index) {
        List<WebElement> radioButtons;

        if (locatorType.equalsIgnoreCase("cssSelector")) {
            radioButtons = driver.findElements(By.cssSelector(groupLocator));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            radioButtons = driver.findElements(By.xpath(groupLocator));
        } else if (locatorType.equalsIgnoreCase("name")) {
            radioButtons = driver.findElements(By.name(groupLocator));
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }

        if (index >= 0 && index < radioButtons.size()) {
            WebElement radio = radioButtons.get(index);
            if (!radio.isSelected()) {
                radio.click();
            }
        } else {
            throw new IndexOutOfBoundsException("Invalid radio button index: " + index);
        }
    }

    public void incrementValue(String locatorType, String locatorValue, int times) {
        WebElement stepper;

        if (locatorType.equalsIgnoreCase("cssSelector")) {
            stepper = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            stepper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
        } else if (locatorType.equalsIgnoreCase("id")) {
            stepper = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        } else if (locatorType.equalsIgnoreCase("name")) {
            stepper = wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }

        for (int i = 0; i < times; i++) {
            stepper.click();
        }
    }

    public void ScreenShot(String fileName) {
        String folderPath = "C:\\Users\\achetanya\\OneDrive - Boots UK Limited\\Pictures\\Screenshots";
        String filePath = folderPath + File.separator + fileName;

        try {
            File screenshotDir = new File(folderPath);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                System.out.println("Created screenshot directory: " + folderPath);
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);

            if (destination.exists()) {
                destination.delete();
            }

            FileHandler.copy(source, destination);
            System.out.println("Screenshot saved: " + filePath);
        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void waitForGeminiResponse() {
        try {
            System.out.println("🤖 Waiting for Gemini AI to respond...");
            WebDriverWait geminiWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            geminiWait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.id("geminiResponse")),
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#geminiResponse"))
            ));
            System.out.println("✅ Gemini response detected!");
        } catch (Exception e) {
            System.out.println("⚠ Gemini response took too long or not found.");
        }
    }

    // ✅ ADDED METHOD BELOW — required for `clear()`
    private WebElement findElement(String locatorType, String locatorValue) {
        WebElement element = null;
        try {
            switch (locatorType.toLowerCase()) {
                case "id":
                    element = driver.findElement(By.id(locatorValue));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(locatorValue));
                    break;
                case "cssselector":
                    element = driver.findElement(By.cssSelector(locatorValue));
                    break;
                case "name":
                    element = driver.findElement(By.name(locatorValue));
                    break;
                default:
                    System.out.println("❌ Invalid locator type: " + locatorType);
            }
        } catch (Exception e) {
            System.out.println("❌ Element not found: " + locatorValue + " (" + e.getMessage() + ")");
        }
        return element;
    }

    public void clear(String locatorType, String locatorValue) {
        try {
            WebElement element = findElement(locatorType, locatorValue);
            element.clear();
        } catch (Exception e) {
            System.out.println("❌ Unable to clear field: " + e.getMessage());
        }
    }
}
