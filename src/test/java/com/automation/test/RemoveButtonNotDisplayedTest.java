package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveButtonNotDisplayedTest extends BaseTest{

    @Test
    public void verifyRemoveButtonNotDisplayed(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.addAllItemsToCart();

        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickOnCheckoutBtn();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        reviewPage.clickOnFinishBtn();

        Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());
        orderConfirmationPage.clickOnBackHomeBtn();

        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertFalse(homePage.removeBtnDisplayed());
    }

}
