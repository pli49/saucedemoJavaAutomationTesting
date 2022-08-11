package com.saucedemo.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItmeName() {
        var elements = driver.findElements(By.cssSelector("#item_4_title_link .inventory_item_name"));
        if(elements.isEmpty()){
            return "No element found";
        }
        return elements.get(0).getText();
        
    }

    public CartPage removeBackPack() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        return this;
    }


    
}
