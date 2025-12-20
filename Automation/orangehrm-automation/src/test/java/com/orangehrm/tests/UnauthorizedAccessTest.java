package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnauthorizedAccessTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void cannotAccessRestrictedPageAfterLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isLoaded(), "Dashboard should be loaded after login");

        dashboardPage.logout();

        // Try to access a restricted page directly
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");

        Assert.assertTrue(loginPage.isLoginPageLoaded(),
                "User should be redirected to login when trying to access restricted page.");
    }
}

