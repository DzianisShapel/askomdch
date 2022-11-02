package org.andersen.lab.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.andersen.lab.base.BaseTest;
import org.andersen.lab.pages.AccountPage;
import org.andersen.lab.pages.OrdersPage;
import org.andersen.lab.utils.ConfigLoader;
import org.andersen.lab.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("Customer profile")
public class AccountTest extends BaseTest {

    @Test
    @Description("Customer is able to navigate to orders and view ordered products")
    @Story("View ordered products")
    public void ViewOrderedProducts() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        OrdersPage ordersPage = accountPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword()).
                navigateToOrders().viewOrder();

        Assert.assertEquals(ordersPage.getOrderDetailsTitle(), "Order details");
    }
}
