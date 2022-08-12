package com.saucedemo.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// import com.saucedemo.model.pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriver standardDriver;
    // Setting up login parameters
    String username = "standard_user";
    String lockoutUsername = "locked_out_user";
    String problemUsername = "problem_user";
    String performanceGlitchUsername = "performance_glitch_user";
    String password = "secret_sauce";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

/*Create common element in for all test to reduce code duplication */

        // standardDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // standardDriver.manage().window().maximize();
        // standardDriver.navigate().to("https://www.saucedemo.com/");
        // var stdUser = New LoginPage(standardDriver)
        // .setInput(lockoutUsername, password, "user-name", "password")
        // .clickLoginButton(1);
    }

    @AfterEach
    public void teardown() {
        driver.close();
    }
}
