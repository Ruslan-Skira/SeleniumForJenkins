package com.academy.automation.practice.test;

import com.academy.automation.practice.page.HomePage;
import com.academy.automation.practice.page.LoginPage;
import com.academy.automation.practice.page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Ignore
    @Test(groups = "login")
    public void testLoginPage() throws Exception {
        manager.goTo().home();
        LOG.info("Start test of login");

        LOG.info("Input login {}", "oleg.kh81@gmail.com");
        LOG.info("Input password {}", "123qwerty");

        MyAccountPage myAccountPage =
                (MyAccountPage)new HomePage(manager.getDriver())
                        .clickSignInLink()
                        .inputLogin("oleg.kh81@gmail.com")
                        .inputPassword("123qwerty")
                        .clickSignIn(true);

        String loginCapture = myAccountPage.getLoginCapture();
        Assert.assertEquals(loginCapture, "Oleg Afanasiev");
        myAccountPage.logout();
        LOG.info("Finish test of login");
    }

    @Test(groups = {"login", "provider"}, dataProvider = "loginIncorrectData")
    public void testIncorrectLogin(String login, String password, String expectedMessage) {
        manager.goTo().home();
        LoginPage loginPage =
                (LoginPage) new HomePage(manager.getDriver())
                        .clickSignInLink()
                        .inputLogin(login)
                        .inputPassword(password)
                        .clickSignIn(false);

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, expectedMessage);
    }

    // TODO read from excel
    @DataProvider(name="loginIncorrectData")
    public Object[][] provideLoginIncorrectData() {
        return new Object[][] {
                {"oleg.kh81@gmail.com", "123", "Invalid password."},
                {"123", "123qwerty", "Invalid email address."},
                {"", "123", "An email address required."},
        };
    }
}

