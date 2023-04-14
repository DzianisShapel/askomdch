package org.senla.mix.qa.tests;

import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.objects.Product;
import org.senla.mix.qa.pages.ProductPage;
import org.senla.mix.qa.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class SearchTest extends BaseTest {


    @Test
    public void searchSpecificProduct() throws IOException {
        Product product = new Product(1202);
        ProductPage productPage = new StorePage(getDriver()).
                load().
                searchExactProduct(product.getName());
        Assert.assertEquals(productPage.getProductTitle(),product.getName());
    }
}
