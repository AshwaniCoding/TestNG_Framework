package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends BaseTest{

    @Test
    public void verifyTotalPriceIsCorrect(){

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.addAllItemsToCart();

        int expectedItems = homePage.expectedTotalProducts();

        Assert.assertEquals(homePage.actualTotalProducts(), expectedItems);
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickOnCheckoutBtn();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        Assert.assertEquals(reviewPage.getActualTotalPrice(), reviewPage.getExpectedTotalPrice());

    }
}
