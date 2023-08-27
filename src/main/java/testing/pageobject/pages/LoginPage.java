package testing.pageobject.pages;

import testing.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "sign-in__email")
    private WebElement username;

    @FindBy(id = "sign-in__password")
    private WebElement pass;

    @FindBy(css = ".form__button")
    private WebElement loginButton;

    @FindBy(css = ".alert__inner")
    private WebElement errorLoginIncorrectPassword;

    @FindBy(xpath = "/html/body/div[1]/main/div/form/div[3]/p")
    private WebElement errorLoginEmptyPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        webDriver.get("http://127.0.0.1:7000/sign-in");
        return this;
    }

    public HomePage login(String username, String pass) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        loginButton.click();

        return new HomePage(webDriver);
    }

    public LoginPage negLoginIncorrectPassword(String username, String pass) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        loginButton.click();

        return new LoginPage(webDriver);
    }

    public LoginPage negLoginEmptyPassword(String username) {
        this.username.sendKeys(username);
        loginButton.click();

        return new LoginPage(webDriver);
    }

    public boolean existErrorLoginIncorrectPassword() {
        return errorLoginIncorrectPassword.isDisplayed();
    }

}
