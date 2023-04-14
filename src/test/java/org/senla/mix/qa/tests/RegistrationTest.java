package org.senla.mix.qa.tests;

import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.objects.User;
import org.senla.mix.qa.pages.AccountPage;

import org.senla.mix.qa.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void successfullRegistration() {
        AccountPage accountPage = new AccountPage(getDriver()).load();
        User user = createUserData();
        accountPage.register(user);
        Assert.assertTrue((accountPage.getAccountContent().contains("Hello " + user.getUsername() + " (not "
                + user.getUsername() + "? Log out")));
    }

    private User createUserData(){
        User user = new User();
        user.setUsername(new FakerUtils().generateFirstName());
        user.setEmail(new FakerUtils().generateRandomUsername() + "@gmail.com");
        user.setPassword(new FakerUtils().generateRandomPassword());
        return user;
    }
}
