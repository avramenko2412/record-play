package testing.uitests.comment;

import testing.BaseTest;
import testing.pageobject.pages.LoginPage;
import testing.pageobject.pages.PostPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static testing.properties.Properties.*;

public class CommentTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void CommentTest() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver);
        Boolean flag;
        PostPage existComment = loginPage
                .open()
                .login(LOGIN, PASS)
                .post(POST_TITLE,POST_DESC)
                        .readMore().
                addComment(COMMENT);
        existComment.capture("/comment/positive");
        flag = existComment.existComment(COMMENT);
        Assert.assertTrue(flag);
    }
}
