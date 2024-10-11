package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;

    @FindBy(xpath = "//span[@class=\"shopping_cart_badge\"]")
    WebElement shoppingCartBadge;

    @FindBy(xpath = "//button[@id=\"react-burger-menu-btn\"]")
    WebElement menuBtn;

    @FindBy(xpath = "//a[@id=\"logout_sidebar_link\"]")
    WebElement logOutBtn;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement sortProductsDropdown;

    @FindBy(xpath = "//div[@class=\"inventory_item_name \"]")
    List<WebElement> productElement;

    @FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
    List<WebElement> priceElement;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBtn;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public void clickOnMenuBtn() {
        menuBtn.click();
    }

    public void clickOnLogOutBtn() {
        logOutBtn.click();
    }

    public String getCartQuantity(){
        return shoppingCartBadge.getText();
    }

    public void clickOnZToASort() {
        dropDown = new Select(sortProductsDropdown);
        dropDown.selectByValue("za");
    }

    public List<String> getProductNamesListed(){
        List<String> productNamesList = new ArrayList<>();
        for(WebElement product : productElement){
            productNamesList.add(product.getText().trim());
        }
        return productNamesList;
    }

    public List<String> actualProductNames() {
        return getProductNamesListed();
    }

    public List<String> expectedProductNames() {
        List<String> expectedProductNamesList = new ArrayList<>(getProductNamesListed());
        Collections.sort(expectedProductNamesList,Collections.reverseOrder());
        return expectedProductNamesList;
    }

    public List<Double> getProductPrices(){
        List<Double> productPrices = new ArrayList<>();
        for(WebElement productPrice : priceElement){
            String s = productPrice.getText().trim();
            Double price = Double.parseDouble(s.replace("$",""));
            productPrices.add(price);
        }
        return productPrices;
    }


    public List<Double> expectedPriceList() {
        List<Double> expectedProductPriceList = new ArrayList<>(getProductPrices());
        Collections.sort(expectedProductPriceList, Collections.reverseOrder());
//        System.out.println("Expected");
//        for(Double s : expectedProductPriceList){
//            System.out.println(s);
//        }
        return expectedProductPriceList;
    }

    public List<Double> actualPriceList() {
//        System.out.println("Actual");
//        for(Double s : getProductPrices()){
//            System.out.println(s);
//        }
        return getProductPrices();
    }

    public void clickOnHighToLowSort() {
        dropDown = new Select(sortProductsDropdown);
        dropDown.selectByValue("hilo");
    }

    public void addAllItemsToCart() {
        for(WebElement addToCartBtn : addToCartBtnList){
            addToCartBtn.click();
        }
    }

    public int expectedTotalProducts() {
        return productElement.size();
    }

    public int actualTotalProducts() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    public boolean removeBtnDisplayed() {
        try{
            removeBtn.isDisplayed();
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
