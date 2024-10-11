package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    WebDriver driver;
    Select dropDown;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

}
