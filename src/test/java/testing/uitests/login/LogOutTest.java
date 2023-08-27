package testing.uitests.login;

import testing.BaseTest;
import testing.pageobject.modules.LogoutModule;
import testing.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static testing.properties.Properties.LOGIN;
import static testing.properties.Properties.PASS;

public class LogOutTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void logoutTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean flag;
        LogoutModule logout = loginPage
                .open()
                .login(LOGIN, PASS)
                .logout();

        logout.capture("/logout");
        flag = logout.getLoginField();
        Assert.assertTrue(flag);
    }
}
