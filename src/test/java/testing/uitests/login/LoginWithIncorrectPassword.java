package testing.uitests.login;

import testing.BaseTest;
import testing.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static testing.properties.Properties.*;

public class LoginWithIncorrectPassword extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeLoginTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean flag; LoginPage errorLogin = loginPage
                .open()
                .negLoginIncorrectPassword(LOGIN,PASS1);
        errorLogin.capture("login/negative");
        flag = errorLogin.existErrorLoginIncorrectPassword();
        Assert.assertTrue(flag);
    }
}
