package org.senla.mix.qa.tests;

import org.senla.mix.qa.base.BaseTest;
import org.senla.mix.qa.pages.ContactPage;
import org.senla.mix.qa.pages.HomePage;
import org.senla.mix.qa.pages.StorePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NavigationTest extends BaseTest {

    @Test
    public void navigateToContactPage(){
        ContactPage contactPage = new HomePage(getDriver()).load()
                .getAppHeader().navigateToContactPage();
        String url = getDriver().getCurrentUrl();
        verifyContactPage(contactPage, url);
    }

    @Test
    public void navigateToStorePage(){
        StorePage storePage = new HomePage(getDriver()).load().getAppHeader()
                .navigateToStorePage();
        String url = getDriver().getCurrentUrl();
        verifyStorePage(storePage, url);
    }

    private void verifyContactPage(ContactPage contactPage, String url) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(contactPage.checkContactEmailIsPresent(), "Contact Email is absent");
        softAssert.assertEquals(url, "https://askomdch.com/contact-us/");
        softAssert.assertAll();
    }

    private void verifyStorePage(StorePage storePage, String url) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(storePage.getTitle(), "Store");
        softAssert.assertEquals(url, "https://askomdch.com/store/");
        softAssert.assertAll();
    }

}
