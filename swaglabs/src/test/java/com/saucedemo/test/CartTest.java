package com.saucedemo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.saucedemo.model.pages.LoginPage;

public class CartTest extends BaseTest{
    
    @Test
    public void standardCartWithOneItem() {
        var cartItem = new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickAddToCartSourceLabBackpack()
        .clickCart()
        .getItmeName();
        assertEquals("Sauce Labs Backpack", cartItem);
    }

    @Test
    public void removeCartItem() {
        var cartItem = new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickAddToCartSourceLabBackpack()
        .clickCart()
        .removeBackPack()
        .getItmeName();
        assertEquals("No element found", cartItem);
    }

    @Test
    public void contiuneShopping() {
        new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickCart()
        .clickContinueShopping();
        assertEquals(true, driver.getCurrentUrl().contains("inventory"));
        
        
    }

    @Test
    public void checkOut() {
        new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickAddToCartSourceLabBackpack()
        .clickCart()
        .clickCheckOut();
        assertEquals(true, driver.getCurrentUrl().contains("checkout-step-one"));
    }

}
