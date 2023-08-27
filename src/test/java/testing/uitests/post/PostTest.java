package testing.uitests.post;

import testing.BaseTest;
import testing.pageobject.pages.HomePage;
import testing.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static testing.properties.Properties.*;

public class PostTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void PostTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        Boolean flag;
        HomePage existPost = loginPage
                .open()
                .login(LOGIN, PASS)
                .post(POST_TITLE,POST_DESC);
        existPost.capture("/post");
        flag = existPost.existPost(POST_TITLE);
        Assert.assertTrue(flag);
    }
}
