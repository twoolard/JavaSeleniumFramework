package com.company.pageobjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObjectBase {

    public void waitForElement(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);

            wait.until(ExpectedConditions.visibilityOf(element));

            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException te) {
            throw new Error("Timed out after 30 seconds. Element " + element.getTagName() + " could not be located");
        } catch (NoSuchElementException ne) {
            throw new Error("Timed out after 30 seconds. Element " + element.getTagName() + " could not be located");
        }
    }


    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(pageLoadCondition);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Failed to load page - " + getPageTitle(driver));


        }

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }
}
