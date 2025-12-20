package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
    public boolean isLoginPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).isDisplayed();
    }
    private final By errorMsg = By.cssSelector(".oxd-alert-content-text");

    public String getErrorMessage() {
    return driver.findElement(errorMsg).getText();
    }
}
