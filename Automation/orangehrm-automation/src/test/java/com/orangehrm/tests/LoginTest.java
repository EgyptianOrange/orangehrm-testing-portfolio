package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "User should be redirected to dashboard after login.");
    }
    @Test(groups = {"smoke"})
    public void invalidLoginShowsErrorMessage() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin", "wrongpass");

    org.testng.Assert.assertTrue(loginPage.getErrorMessage().toLowerCase().contains("invalid"),
            "Error message should mention invalid credentials.");
    }
}
