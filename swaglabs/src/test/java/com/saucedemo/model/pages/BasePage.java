package com.saucedemo.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    // Setting up login parameters
    String standardUsername = "standard_user";
    String lockoutUsername = "locked_out_user";
    String problemUsername = "problem_user";
    String performanceGlitchUsername = "performance_glitch_user";
    String password = "secret_sauce";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton(int num) {
        driver.findElement(By.id("login-button")).click();
        return new LoginPage(driver);
    }

    public InventoryPage clickLoginButton(double num) {
        driver.findElement(By.id("login-button")).click();
        return new InventoryPage(driver);
    }

    public LoginPage setInput(String username, String password, String userid, String passwordid) {
        driver.findElement(By.id(userid)).sendKeys(username);
        driver.findElement(By.id(passwordid)).sendKeys(password);
        return new LoginPage(driver);
    }

    public InventoryPage clickSourceLabBackpack() {
        driver.findElement(By.cssSelector("#item_4_title_link div")).click();
        return new InventoryPage(driver);
    }

    public String getBackToProduct() {
        return driver.findElement(By.id("back-to-products")).getText();
    }

    public InventoryPage clickAddToCartSourceLabBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        return new InventoryPage(driver);
    }

    public InventoryPage clickAddToCartSourceLabBikeLight() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        return new InventoryPage(driver);
    }

    public CartPage clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(driver);
    }

    public InventoryPage clickContinueShopping() {
        driver.findElement(By.id("continue-shopping")).click();
        return new InventoryPage(driver);
    }

    public CheckOutStepOnePage clickCheckOut() {
        driver.findElement(By.id("checkout")).click();
        return new CheckOutStepOnePage(driver);
    }


}
