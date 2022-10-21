package org.andersen.lab.tests;

import org.andersen.lab.base.BaseTest;
import org.andersen.lab.objects.User;
import org.andersen.lab.pages.AccountPage;
import org.andersen.lab.pages.OrdersPage;
import org.andersen.lab.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {


    @Test
    public void LoginAndViewOrderedProducts() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        OrdersPage ordersPage = accountPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword()).
                navigateToOrders().viewOrder();

        Assert.assertEquals(ordersPage.getOrderDetailsTitle(), "Order details");
    }


}
