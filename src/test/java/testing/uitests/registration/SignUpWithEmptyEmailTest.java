package testing.uitests.registration;

import testing.BaseTest;
import testing.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import testing.properties.Properties;

import java.io.IOException;

public class SignUpWithEmptyEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        SignInPage signInPage = new SignInPage(webDriver);
        Boolean flag;
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(Properties.NAME, Properties.LAST_NAME);
        errorSignIn.capture("signup/negative");
        flag = errorSignIn.emptyEmailErrorSignIn();
        Assert.assertTrue(flag);
    }
}

