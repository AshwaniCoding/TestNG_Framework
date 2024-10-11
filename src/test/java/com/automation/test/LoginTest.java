package com.automation.test;

import com.automation.utils.ExcelUtils;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class LoginTest extends BaseTest{

    @Test(dataProvider = "getValidCredentials")
    public void verifyUserCanLoginWithValidCredentials(String username, String password){

        loginPage.openWebsite();
        loginPage.doLogin(username, password);

        Allure.addAttachment("screenshot", takeScreenshot());
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @DataProvider
    public Object[][] getValidCredentials(){
//        return new Object[][]{{"standard_user","secret_sauce"},
//                {"problem_user","secret_sauce"},
//                {"performance_glitch_user","secret_sauce"},
//                {"error_user","secret_sauce"},
//                {"visual_user","secret_sauce"}};

        ExcelUtils excelUtils = new ExcelUtils("credentials.xlsx","ValidData");
        List<List<String>> tableData = excelUtils.getData();
        Object[][] data = new Object[tableData.size()][tableData.get(0).size()];

        for(int i = 0; i < tableData.size(); i++){
            List<String> row = tableData.get(i);
            for(int j = 0; j < row.size(); j++){
                data[i][j] = tableData.get(i).get(j);
            }
        }

        return data;
    }
}
