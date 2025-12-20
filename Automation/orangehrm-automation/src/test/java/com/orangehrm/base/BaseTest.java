package com.orangehrm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void tearDown(org.testng.ITestResult result) {
    try {
        if (result.getStatus() == org.testng.ITestResult.FAILURE && driver != null) {
            Thread.sleep(400);
            java.io.File src = ((org.openqa.selenium.TakesScreenshot) driver)
                    .getScreenshotAs(org.openqa.selenium.OutputType.FILE);

            java.io.File dest = new java.io.File("screenshots/" + result.getName() + ".png");
            dest.getParentFile().mkdirs();
            java.nio.file.Files.copy(src.toPath(), dest.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        }
    } catch (Exception ignored) {
    } finally {
        if (driver != null) driver.quit();
    }
}
}
