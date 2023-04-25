package org.senla.mix.qa.tests;

import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.pages.AccountPage;
import org.senla.mix.qa.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void successfulLogin(@Optional String username, @Optional String password) {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        accountPage.login(username, password);

        Assert.assertTrue((accountPage.getAccountContent().contains("Hello " + username + " (not "
                + username + "? Log out")));
    }


    @DataProvider(name = "loginData")
    public Object[][] createLoginData() {
        return new Object[][]{
                {"senlamixqa", FakerUtils.generateRandomPassword()},
                {"senlamixqa", ""}
        };
    }

    @Test(dataProvider = "loginData")
    public void incorrectLogin(String username, String password) {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        accountPage.login(username, password);

        Assert.assertTrue(accountPage.getErrorMessage().contains("Error: The password"));
    }
}
