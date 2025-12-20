package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By errorMsg = By.cssSelector(".oxd-alert-content-text");

    public String getErrorMessage() {
    return driver.findElement(errorMsg).getText();
    }
}
