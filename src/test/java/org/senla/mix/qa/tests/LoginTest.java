package org.senla.mix.qa.tests;


import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.pages.AccountPage;
import org.senla.mix.qa.utils.ConfigLoader;
import org.senla.mix.qa.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
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
}
