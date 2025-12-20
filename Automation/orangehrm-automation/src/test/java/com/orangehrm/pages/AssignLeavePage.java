package com.orangehrm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AssignLeavePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By employeeNameInput = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private final By leaveTypeDropdown = By.xpath("//label[text()='Leave Type']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
    private final By leaveTypeFirstOption = By.xpath("//div[@role='listbox']//div[contains(@class,'oxd-select-option')][2]");

    private final By fromDateInput = By.xpath("//label[contains(text(),'From')]/../following-sibling::div//input");
    private final By toDateInput   = By.xpath("//label[contains(text(),'To')]/../following-sibling::div//input");

    private final By submitBtn = By.xpath("//button[@type='submit']");

    private final By autoCompleteFirstItem = By.xpath("//div[@role='listbox']//span[1]");

    private final By fieldErrorMsg = By.cssSelector("span.oxd-input-field-error-message");
    private final By successToast  = By.cssSelector("div.oxd-toast--success");

    private final By confirmDialog = By.cssSelector(".oxd-dialog-container-default");
    private final By confirmOkBtn  = By.xpath("//div[contains(@class,'oxd-dialog-container-default')]//button[normalize-space()='Ok' or normalize-space()='OK']");


    public AssignLeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave");
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput));
    }

    public void assignLeave(String employeeName, LocalDate from, LocalDate to) {
        // Employee name (autocomplete)
        WebElement emp = wait.until(ExpectedConditions.elementToBeClickable(employeeNameInput));
        emp.click();
        emp.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        emp.sendKeys(employeeName);

        // pick first suggestion
        wait.until(ExpectedConditions.elementToBeClickable(autoCompleteFirstItem)).click();

        // Leave type: choose first option
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeFirstOption)).click();

        // Dates
        setDate(fromDateInput, from);
        setDate(toDateInput, to);

        // Submit
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

    public boolean isSuccessToastShown() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isValidationErrorShown() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(fieldErrorMsg)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void setDate(By locator, LocalDate date) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(locator));

        // Figure out UI placeholder format (usually yyyy-mm-dd)
        String placeholder = input.getAttribute("placeholder"); // e.g. "yyyy-mm-dd"
        String formatted = formatDate(date, placeholder);

        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(formatted);
        input.sendKeys(Keys.TAB); // trigger blur/change
    }

    private String formatDate(LocalDate date, String placeholder) {
        if (placeholder == null) {
            return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        String p = placeholder.toLowerCase();
        if (p.startsWith("dd")) {
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        // default year-first
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void confirmIfInsufficientBalancePopupAppears() {
        try {
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(confirmDialog));
            wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(confirmOkBtn)).click();
        } catch (org.openqa.selenium.TimeoutException ignored) {
            // popup didn't appear → nothing to do
        }
    }

}
