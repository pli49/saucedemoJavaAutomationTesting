package com.saucedemo.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginError() {
        return driver.findElement(By.cssSelector(".error-message-container h3")).getText();
    }

    public String getProductHeader() {
        return driver.findElement(By.cssSelector(".header_secondary_container .title")).getText();
    }

    public boolean checkShoppingCart() {
        return driver.findElement(By.id("shopping_cart_container")).isDisplayed();
    }

}
