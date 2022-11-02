package org.andersen.lab.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.andersen.lab.base.BaseTest;
import org.andersen.lab.objects.Product;
import org.andersen.lab.pages.ProductPage;
import org.andersen.lab.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Search products")
public class SearchTest extends BaseTest {


    @Test
    @Description("User is able to find specific product")
    @Story("Search products")
    public void searchSpecificProduct() throws IOException {
        Product product = new Product(1202);
        ProductPage productPage = new StorePage(getDriver()).
                load().
                searchExactProduct(product.getName());
        Assert.assertEquals(productPage.getProductTitle(),product.getName());
    }
}
