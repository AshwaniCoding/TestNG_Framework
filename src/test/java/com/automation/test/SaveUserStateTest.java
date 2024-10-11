package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SaveUserStateTest extends BaseTest{

    @Test(dataProvider = "getValidCredentials")
    public void verifyApplicationSaveStateOfUser(String username, String password){

        loginPage.openWebsite();
        loginPage.doLogin(username, password);
        Assert.assertTrue(homePage.isHomePageDisplayed());

        homePage.clickOnAddToCartOfFirstItem();
        Assert.assertEquals(homePage.getCartQuantity(),"1");

        homePage.clickOnMenuBtn();
        homePage.clickOnLogOutBtn();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());

        loginPage.doLogin(username, password);
        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertEquals(homePage.getCartQuantity(),"1");

    }

    @DataProvider
    public Object[][] getValidCredentials(){
        return new Object[][]{{"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
                {"error_user","secret_sauce"},
                {"visual_user","secret_sauce"}};
    }
}
