package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(xpath = "//div[@class=\"summary_total_label\"]")
    WebElement totalPrice;

    @FindBy(xpath = "//div[@class=\"summary_tax_label\"]")
    WebElement taxLabel;

    @FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
    List<WebElement> productPriceElement;

    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }

    public Double getActualTotalPrice(){
        String s = totalPrice.getText().trim();
        return Double.parseDouble(s.replace("Total: $",""));
    }


    public Double getExpectedTotalPrice() {
        double totalPrice = 0.0;
        for(WebElement priceElement : productPriceElement){
            String s = priceElement.getText().trim();
            totalPrice += Double.parseDouble(s.replace("$",""));
        }
        return totalPrice + Double.parseDouble(taxLabel.getText().replace("Tax: $",""));
    }
}
