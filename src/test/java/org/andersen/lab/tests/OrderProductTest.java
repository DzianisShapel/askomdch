package org.andersen.lab.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.andersen.lab.base.BaseTest;
import org.andersen.lab.objects.BillingAddress;
import org.andersen.lab.objects.Product;
import org.andersen.lab.pages.CartPage;
import org.andersen.lab.pages.CheckoutPage;
import org.andersen.lab.pages.HomePage;
import org.andersen.lab.pages.ProductPage;
import org.andersen.lab.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Order products")
public class OrderProductTest  extends BaseTest {


    @Test
    @Description("Not logged in user orders featured products which are on the home page")
    @Story("Guest order product")
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
