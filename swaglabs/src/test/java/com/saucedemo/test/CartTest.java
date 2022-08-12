package com.saucedemo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.saucedemo.model.pages.LoginPage;

public class CartTest extends BaseTest{
    
    //verify standard user can add one item to cart
    @Test
    public void verifyStandardCartWithOneItem() {
        var cartItem = new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickAddToCartSourceLabBackpack()
        .clickCart()
        .getItmeName();
        assertEquals("Sauce Labs Backpack", cartItem);
    }

    //Verify standard user can remove item in cart
    @Test
    public void verifyRemoveCartItem() {
        var cartItem = new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickAddToCartSourceLabBackpack()
        .clickCart()
        .removeBackPack()
        .getItmeName();
        assertEquals("No element found", cartItem);
    }

    //verify standard user can continue shopping 
    @Test
    public void verifyContiuneShopping() {
        new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickCart()
        .clickContinueShopping();
        assertEquals(true, driver.getCurrentUrl().contains("inventory"));
        
        
    }

    //verify standard user can go to check out
    @Test
    public void verifyCheckOut() {
        new LoginPage(driver)
        .setInput(username, password, "user-name", "password")
        .clickLoginButton(1.1)
        .clickAddToCartSourceLabBackpack()
        .clickCart()
        .clickCheckOut();
        assertEquals(true, driver.getCurrentUrl().contains("checkout-step-one"));
    }

}
