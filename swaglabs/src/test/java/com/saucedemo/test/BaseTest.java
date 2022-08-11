package com.saucedemo.test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
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
    }

    // @AfterEach
    // public void teardown() {
    //     driver.close();
    // }
}
