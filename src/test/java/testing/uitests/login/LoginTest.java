package testing.uitests.login;

import testing.BaseTest;
import testing.pageobject.pages.HomePage;
import testing.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static testing.properties.Properties.LOGIN;
import static testing.properties.Properties.PASS;

public class LoginTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        Boolean flag;
        HomePage userInformation = loginPage
                .open()
                .login(LOGIN, PASS);
        userInformation.capture("login/positive");
        flag = userInformation.verifyLogin();
        Assert.assertTrue(flag);
    }
}
