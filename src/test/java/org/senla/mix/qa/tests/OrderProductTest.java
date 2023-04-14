package org.senla.mix.qa.tests;

import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.objects.BillingAddress;
import org.senla.mix.qa.objects.Product;
import org.senla.mix.qa.pages.CheckoutPage;
import org.senla.mix.qa.pages.HomePage;
import org.senla.mix.qa.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderProductTest  extends BaseTest {


    @Test
    public void GuestOrderFeaturedProduct () throws IOException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        CheckoutPage checkoutPage = new HomePage(getDriver()).load().
                getProductThumbnail().
                clickAddToCartBtn(product.getName()).
                clickViewCart().
                checkout().
                setBillingAddress(billingAddress).
                selectCashOnDeliveryTransfer().
                placeOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
