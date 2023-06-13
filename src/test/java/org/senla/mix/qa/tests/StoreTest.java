package org.senla.mix.qa.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.openqa.selenium.WebElement;
import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.pages.StorePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class StoreTest extends BaseTest {

    @Flaky
    @Test
    @Description("Filter products by browser")
    public void filterProductsByIncreasingPrice() {
        double filterPrice = 130;
        StorePage storePage = new StorePage(getDriver()).load();
        List<WebElement> productsBeforeFiltering = storePage.getListOfProducts();
        storePage.increaseStartPriceTo(filterPrice)
                .clickFilterButton();
        List<WebElement> productsAfterFiltering = storePage.getListOfProducts();
        Double productPrice = Double.valueOf(storePage.getProductThumbnail().getPrice());
        checkCorrectFiltering(productsBeforeFiltering, productsAfterFiltering, filterPrice, productPrice);
    }

    @Test
    @Description("Filter products by categories")
    public void browseByCategories() {
        String category = "accessories";
        StorePage storePage = new StorePage(getDriver()).load().selectCategory(category);
        String title = storePage.getTitle();
        List<WebElement> products = storePage.getListOfProducts();
        checkBrowsingByCategories(title,products);
    }

    private void checkBrowsingByCategories(String title, List<WebElement> products) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(title, "Accessories");
        softAssert.assertTrue(products.size()==3);
    }

    private void checkCorrectFiltering(List<WebElement> productsBefore, List<WebElement> productsAfter, double productPrice, double filterCriteria){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productsBefore.size()!=productsAfter.size());
        softAssert.assertTrue(checkPrice(productPrice, filterCriteria));
        softAssert.assertAll();
    }

    private Boolean checkPrice(double productPrice, double filterCriteria) {
        if (productPrice >= filterCriteria) {
            return true;
        } else
            return false;
    }



}
