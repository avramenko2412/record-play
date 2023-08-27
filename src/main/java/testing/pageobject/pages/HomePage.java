package testing.pageobject.pages;

import testing.pageobject.BasePage;
import testing.pageobject.modules.LogoutModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = ".dropdown")
    private WebElement profileDropDownButton;

    @FindBy(linkText = "My profile")
    private WebElement myProfile;

    @FindBy(css = ".dropdown__link:nth-child(2)")
    private WebElement logoutButton;

    @FindBy(linkText = "New post")
    private WebElement newPostButton;


    @FindBy(css = ".post-form__title")
    private WebElement postTitle;

    @FindBy(css = ".post-form__description")
    private WebElement postDescription;

    @FindBy(css = ".post-form__button:nth-child(2)")
    private WebElement postButton;

    @FindBy(css = ".alert__button")
    private WebElement okButton;

    @FindBy(xpath = "/html/body/main/div/div[1]/div[1]/div[1]/h2")
    private WebElement postedTitle;

    @FindBy(linkText = "Read more")
    private WebElement readMore;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean verifyLogin() {
        return profileDropDownButton.isDisplayed();
    }

    public LogoutModule logout() {
        profileDropDownButton.click();
        logoutButton.click();
        return new LogoutModule(webDriver);
    }

    public HomePage post(String title, String desc) {
        newPostButton.click();
        postTitle.sendKeys(title);
        postDescription.sendKeys(desc);
        postButton.click();
        okButton.click();

        return new HomePage(webDriver);
    }

    public boolean existPost(String title) {
        return postedTitle.getText().equals(title);

    }

    public PostPage readMore() {
        readMore.click();
        return new PostPage(webDriver);
    }

    public AccountPage openMyProfile() {
        profileDropDownButton.click();
        myProfile.click();
        return new AccountPage(webDriver);
    }


}
