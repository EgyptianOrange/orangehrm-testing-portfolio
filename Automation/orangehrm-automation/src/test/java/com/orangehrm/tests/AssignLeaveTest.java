package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.AssignLeavePage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AssignLeaveTest extends BaseTest {

    @Test
    public void assignLeaveWithFutureDates_shouldSucceed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AssignLeavePage page = new AssignLeavePage(driver);
        page.open();

        LocalDate from = LocalDate.now().plusDays(1);
        LocalDate to   = LocalDate.now().plusDays(2);

        page.assignLeave("James  Butler", from, to);

        page.confirmIfInsufficientBalancePopupAppears();
        Assert.assertTrue(page.isSuccessToastShown(),
                "Expected success toast after assigning leave with valid future dates.");
    }

    @Test(enabled = false, description = "BUG_01: System allows assigning leave with a past date (should be rejected).")
    public void assignLeaveWithPastDate_shouldBeRejected_bug01() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AssignLeavePage page = new AssignLeavePage(driver);
        page.open();

        LocalDate past = LocalDate.now().minusDays(5);

        page.assignLeave("Timothy Lewis Amiano", past, past);

        page.confirmIfInsufficientBalancePopupAppears();

        Assert.assertTrue(page.isValidationErrorShown(),
                "Expected validation error when assigning leave with a past date.");
    }

}
