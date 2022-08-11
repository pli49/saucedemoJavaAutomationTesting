package com.saucedemo.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage standardUserLogin() {
        new InventoryPage(driver)
                .setInput("standard_user", "secret_sauce", "user-name", "password")
                .clickLoginButton(1.1);
        return this;

    }

    public InventoryPage clickHumbargerIcon() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        return this;
    }

    public InventoryPage clickLogout() {
        driver.findElement(By.id("logout_sidebar_link")).click();
        return this;
    }

    

    public InventoryPage clickRemoveCartSourceLabBackpack() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        return this;
    }

    public String cartStatus() {
        return driver.findElement(By.cssSelector("#shopping_cart_container .shopping_cart_link .shopping_cart_badge"))
                .getText();
    }


}
