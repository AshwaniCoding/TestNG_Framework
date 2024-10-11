package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
    List<WebElement> cartItemsList;

    public boolean isCartPageDisplayed() {
        return checkOutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn() {
        checkOutBtn.click();
    }

    public int getTotalProductsAddedInCart() {
        return cartItemsList.size();
    }
}
