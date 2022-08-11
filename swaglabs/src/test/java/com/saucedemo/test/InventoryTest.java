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

    @Test
    public void standardProductDetail() {
        var sauceLabsBackpack = new InventoryPage(driver)
        .standardUserLogin()
        .clickSourceLabBackpack();

        assertEquals("BACK TO PRODUCTS", sauceLabsBackpack.getBackToProduct());
        assertEquals(true, driver.getCurrentUrl().contains("inventory-item"));
    }

    @Test
    public void standardAddCart() {
        var standardUser = new InventoryPage(driver)
        .standardUserLogin()
        .clickAddToCartSourceLabBackpack()
        .cartStatus();
        assertEquals("1", standardUser);
        
    }

    @Test
    public void standardRemoveCart() {
        var standardUser = new InventoryPage(driver)
        .standardUserLogin()
        .clickAddToCartSourceLabBackpack()
        .clickAddToCartSourceLabBikeLight()
        .clickRemoveCartSourceLabBackpack()
        .cartStatus();
        assertEquals("1", standardUser);
        
    }

    @Test
    public void standardGoToCard() {
        new InventoryPage(driver)
        .standardUserLogin()
        .clickAddToCartSourceLabBackpack()
        .clickCart();
        assertEquals(true, driver.getCurrentUrl().contains("cart"));
        
    }

    @Test
    public void standardLogout() {
        new InventoryPage(driver)
        .standardUserLogin()
        .clickHumbargerIcon()
        .clickLogout();
        assertEquals(true, driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
        
    }



    
}
