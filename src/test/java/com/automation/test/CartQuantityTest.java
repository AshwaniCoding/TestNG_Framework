package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartQuantityTest extends BaseTest{

    @Test
    public void verifyCartPageTotalItemsEqualsToItemsAddedInCart(){

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.addAllItemsToCart();

        int expectedItems = homePage.expectedTotalProducts();

        Assert.assertEquals(homePage.actualTotalProducts(), expectedItems);
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        Assert.assertEquals(cartPage.getTotalProductsAddedInCart(),expectedItems);

    }
}
