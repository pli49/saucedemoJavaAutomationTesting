package com.saucedemo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.saucedemo.model.pages.LoginPage;

public class LoginTest extends BaseTest {

/* Testing for different kind of inputs*/

    // test for no input
    @Test
    public void verifyNoInputUserLoginError() {
        var user = new LoginPage(driver).clickLoginButton(1).getLoginError();
        assertEquals("Epic sadface: Username is required", user);
    }

    // Test for standard user name with no password - Equivalence Partationing
    @Test
    public void verifyNoPasswordLogin() {
        var noPasswordUser = new LoginPage(driver)
                .setInput(username, "", "user-name", "password")
                .clickLoginButton(1).getLoginError();
        assertEquals("Epic sadface: Password is required", noPasswordUser);

    }

    // test for lock out user
    @Test
    public void verifyLockoutUserLoginError() {
        var user = new LoginPage(driver)
        .setInput(lockoutUsername, password, "user-name", "password")
        .clickLoginButton(1)
        .getLoginError();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", user);
    }

    // testing for standard user login
    @Test
    public void verifyStandardUserLogin() {
        var standardUser = new LoginPage(driver)
                .setInput(username, password, "user-name", "password")
                .clickLoginButton(1);

        // verify that the url contains word invertory
        assertEquals(true, driver.getCurrentUrl().contains("inventory"));

        // verify that the PRODUCT header exists
        var productHeader = standardUser.getProductHeader();
        assertEquals("PRODUCTS", productHeader);

        // verify that the shoping cart exists
        var shppoingCart = standardUser.checkShoppingCart();
        assertEquals(true, shppoingCart);

    }

    // test for a problem user login
    @Test
    public void verifyProblemUserLogin() {
        var problemUser = new LoginPage(driver)
                .setInput(problemUsername, password, "user-name", "password")
                .clickLoginButton(1);

        // verify that the url contains word invertory
        assertEquals(true, driver.getCurrentUrl().contains("inventory"));

        // verify that the PRODUCT header exists
        var productHeader = problemUser.getProductHeader();
        assertEquals("PRODUCTS", productHeader);

        // verify that the shoping cart exists
        var shppoingCart = problemUser.checkShoppingCart();
        assertEquals(true, shppoingCart);

    }

        // test for a Performance Glitch user login
        @Test
        public void verifyPerformanceGlitchUserLogin() {
            var performanceGlitchUser = new LoginPage(driver)
                    .setInput(performanceGlitchUsername, password, "user-name", "password")
                    .clickLoginButton(1);
    
            // verify that the url contains word invertory
            assertEquals(true, driver.getCurrentUrl().contains("inventory"));
    
            // verify that the PRODUCT header exists
            var productHeader = performanceGlitchUser.getProductHeader();
            assertEquals("PRODUCTS", productHeader);
    
            // verify that the shoping cart exists
            var shppoingCart = performanceGlitchUser.checkShoppingCart();
            assertEquals(true, shppoingCart);
    
        }

}
