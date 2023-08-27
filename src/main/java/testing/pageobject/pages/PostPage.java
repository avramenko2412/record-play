package testing.pageobject.pages;

import testing.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BasePage {
    @FindBy(css = ".comment-form__textarea")
    private WebElement textarea;

    @FindBy(css = ".comment-form__button:nth-child(1)")
    private WebElement commentButton;

    @FindBy(xpath = "/html/body/main/div/div/div/div/p")
    private WebElement comment;

    protected PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage addComment(String comment) {
        textarea.sendKeys(comment);
        commentButton.click();
        return new PostPage(webDriver);
    }

    public boolean existComment(String comment) {
        return this.comment.getText().equals(comment);
    }
}
