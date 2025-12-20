package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void userCanLogoutSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isLoaded(), "Dashboard should be loaded after login");

        dashboardPage.logout();

        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login page should be displayed after logout");
    }
}
