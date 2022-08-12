package com.saucedemo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.saucedemo.model.pages.InventoryPage;

public class InventoryTest extends BaseTest {


//for standard user
    // @Test
    // public void standardInventory() {
    //     new InventoryPage(driver).standardUserLogin();
    //     assertEquals(true, driver.getCurrentUrl().contains("inventory"));
        
    // }

    //test can go to inventory-item page, TODO: create inventory-item page
    @Test
    public void verifyStandardProductDetail() {
        var sauceLabsBackpack = new InventoryPage(driver)
        .standardUserLogin()
        .clickSourceLabBackpack();

        assertEquals("BACK TO PRODUCTS", sauceLabsBackpack.getBackToProduct());
        assertEquals(true, driver.getCurrentUrl().contains("inventory-item"));
    }

    //standard user can add item to cart
    @Test
    public void verifyStandardAddCart() {
        var standardUser = new InventoryPage(driver)
        .standardUserLogin()
        .clickAddToCartSourceLabBackpack()
        .cartStatus();
        assertEquals("1", standardUser);
        
    }

    //standard user can remove item from cart
    @Test
    public void verifyStandardRemoveCart() {
        var standardUser = new InventoryPage(driver)
        .standardUserLogin()
        .clickAddToCartSourceLabBackpack()
        .clickAddToCartSourceLabBikeLight()
        .clickRemoveCartSourceLabBackpack()
        .cartStatus();
        assertEquals("1", standardUser);
        
    }

    //standard user can go to cart
    @Test
    public void verifyStandardGoToCard() {
        new InventoryPage(driver)
        .standardUserLogin()
        .clickAddToCartSourceLabBackpack()
        .clickCart();
        assertEquals(true, driver.getCurrentUrl().contains("cart"));
        
    }

    //standard user can logout from inventory page
    @Test
    public void verifyStandardLogout() {
        new InventoryPage(driver)
        .standardUserLogin()
        .clickHumbargerIcon()
        .clickLogout();
        assertEquals(true, driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
        
    }



    
}
