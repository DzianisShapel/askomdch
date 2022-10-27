package org.andersen.lab.tests;

import org.andersen.lab.base.BaseTest;
import org.andersen.lab.pages.AccountPage;
import org.andersen.lab.pages.OrdersPage;
import org.andersen.lab.utils.ConfigLoader;
import org.andersen.lab.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {


    @Test
    public void SuccessfullLogin() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        accountPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());

        Assert.assertTrue((accountPage.getAccountContent().contains("Hello " + ConfigLoader.getInstance().getUsername() + " (not "
                + ConfigLoader.getInstance().getUsername() + "? Log out")));
    }

    @Test
    public void loginWithIncorrectPassword() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        accountPage.login(ConfigLoader.getInstance().getUsername(), new FakerUtils().generateRandomPassword());

        Assert.assertEquals(accountPage.getErrorMessage(), "Error: The password you entered for the username " + ConfigLoader.getInstance().getUsername() + " is incorrect. Lost your password?");
    }

    @Test
    public void LoginAndViewOrderedProducts() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        OrdersPage ordersPage = accountPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword()).
                navigateToOrders().viewOrder();

        Assert.assertEquals(ordersPage.getOrderDetailsTitle(), "Order details");
    }


}
