package org.senla.mix.qa.tests;

<<<<<<<< HEAD:src/test/java/org/senla/mix/qa/tests/LoginTest.java
import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.pages.AccountPage;
import org.senla.mix.qa.pages.OrdersPage;
import org.senla.mix.qa.utils.ConfigLoader;
import org.senla.mix.qa.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
========
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
>>>>>>>> origin/master:src/test/java/org/andersen/lab/tests/AccountTest.java

    @Test
<<<<<<<< HEAD:src/test/java/org/senla/mix/qa/tests/LoginTest.java
    public void successfullLogin() {
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

   /* @Test
    public void LoginAndViewOrderedProducts() {
========
    @Description("Customer is able to navigate to orders and view ordered products")
    @Story("View ordered products")
    public void ViewOrderedProducts() {
>>>>>>>> origin/master:src/test/java/org/andersen/lab/tests/AccountTest.java
        AccountPage accountPage = new AccountPage(getDriver()).load();
        OrdersPage ordersPage = accountPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword()).
                navigateToOrders().viewOrder();

        Assert.assertEquals(ordersPage.getOrderDetailsTitle(), "Order details");
<<<<<<<< HEAD:src/test/java/org/senla/mix/qa/tests/LoginTest.java
    }*/


========
    }
>>>>>>>> origin/master:src/test/java/org/andersen/lab/tests/AccountTest.java
}
