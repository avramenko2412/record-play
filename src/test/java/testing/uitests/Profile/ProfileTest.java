package testing.uitests.Profile;

import testing.BaseTest;
import testing.pageobject.pages.AccountPage;
import testing.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import testing.properties.Properties;

import java.io.IOException;

public class ProfileTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void ProfileTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        Boolean flag; AccountPage updateSucceed = loginPage
                .open()
                .login(Properties.LOGIN, Properties.PASS)
                        .openMyProfile().editFields(Properties.NAME, Properties.LAST_NAME, Properties.BIRTHDAY, Properties.ADDRESS, Properties.WEBSITE);
        updateSucceed.capture("profile");
        flag = updateSucceed.updateSucceed();

        Assert.assertTrue(flag);
    }
}
