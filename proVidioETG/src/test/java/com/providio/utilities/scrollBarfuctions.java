//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class scrollBarfuctions {
    public scrollBarfuctions() {
    }

    public void scrolldownfull(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);", new Object[0]);
    }

    public void scrollmedium(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Long windowHeight = (Long)js.executeScript("return window.innerHeight;", new Object[0]);
        js.executeScript("window.scrollTo(0, " + windowHeight / 2L + ");", new Object[0]);
    }

    public void scrollupmedium(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Long windowHeight = (Long)js.executeScript("return window.innerHeight;", new Object[0]);
        js.executeScript("window.scrollTo(0, -" + windowHeight / 2L + ");", new Object[0]);
    }

    public void scrollupfull(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, 0);", new Object[0]);
    }
}
