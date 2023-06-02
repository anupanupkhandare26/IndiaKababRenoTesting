package com.indiaKababReno.library;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement locator, Duration timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement locator, Duration i) {
        WebDriverWait wait = new WebDriverWait(driver, i);
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
    }

    public static void waitForPageLoad(WebDriver driver, Duration timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // Additional wait methods can be added based on conditions

}

