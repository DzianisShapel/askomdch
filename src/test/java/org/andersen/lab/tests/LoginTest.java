package org.andersen.lab.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.andersen.lab.base.BaseTest;
import org.andersen.lab.pages.AccountPage;
import org.andersen.lab.utils.ConfigLoader;
import org.andersen.lab.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("User login")
public class LoginTest extends BaseTest {
    @Test
    @Description("User is able to login with valid credentials")
    @Story("Login with valid credentials")
    public void SuccessfullLogin() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        accountPage.login(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());

        Assert.assertTrue((accountPage.getAccountContent().contains("Hello " + ConfigLoader.getInstance().getUsername() + " (not "
                + ConfigLoader.getInstance().getUsername() + "? Log out")));
    }

    @Test
    @Description("User is not able to with invalid password")
    @Story("Login denied as incorrect password was provided")
    public void loginWithIncorrectPassword() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        accountPage.login(ConfigLoader.getInstance().getUsername(), new FakerUtils().generateRandomPassword());

        Assert.assertEquals(accountPage.getErrorMessage(), "Error: The password you entered for the username " + ConfigLoader.getInstance().getUsername() + " is incorrect. Lost your password?");
    }

}
