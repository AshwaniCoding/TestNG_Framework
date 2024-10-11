package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SortProductsTest extends BaseTest{

    @Test
    public void verifyUserCanSortProductsFromZToA(){

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());

        List<String> expected = homePage.expectedProductNames();
        homePage.clickOnZToASort();
        List<String> actual = homePage.actualProductNames();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void verifyUserCanSortProductsByPrice(){

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());

        List<Double> expected = homePage.expectedPriceList();

        homePage.clickOnHighToLowSort();
        List<Double> actual = homePage.actualPriceList();

        Assert.assertEquals(actual, expected);
    }
}
