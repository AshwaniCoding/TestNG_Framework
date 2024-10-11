package com.automation.test;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class BaseTest {

//    LoginPage loginPage = new LoginPage();
//    HomePage homePage = new HomePage();
//    CartPage cartPage = new CartPage();
//    CheckoutPage checkoutPage = new CheckoutPage();
//    ReviewPage reviewPage = new ReviewPage();
//    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ReviewPage reviewPage;
    OrderConfirmationPage orderConfirmationPage;


    @BeforeMethod
    public void setUp(){
        DriverManager.createDriver();
        ConfigReader.initConfig();
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        reviewPage = new ReviewPage();
        orderConfirmationPage = new OrderConfirmationPage();
    }


    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }

    public ByteArrayInputStream takeScreenshot(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return new ByteArrayInputStream(screenshot);
    }
}
