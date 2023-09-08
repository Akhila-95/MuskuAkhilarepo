package com.providio.commonfunctionality;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtility {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtility(WebDriver driver, Duration i) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, i);
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Add more wait methods as needed...

    // Example: Wait for an element to be present in the DOM
    public WebElement waitForPresenceOfElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
