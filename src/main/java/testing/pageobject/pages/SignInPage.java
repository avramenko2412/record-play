package testing.pageobject.pages;

import testing.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "sign-up__first-name")
    private WebElement name;

    @FindBy(id = "sign-up__last-name")
    private WebElement lastName;

    @FindBy(id = "sign-up__email")
    private WebElement username;

    @FindBy(id = "sign-up__password")
    private WebElement pass;

    @FindBy(id = "sign-up__confirm-password")
    private WebElement confPass;

    @FindBy(css = ".form__button")
    private WebElement signUpButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible fade show\"]")
    private WebElement errorNonCorrectEmail;

    @FindBy(xpath = "/html/body/div[1]/main/div/form/div[3]/p")
    private WebElement emptyEmail;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignInPage open() {
        webDriver.get("http://127.0.0.1:7000/sign-up");
        return this;
    }

    public HomePage signIn(String name, String lastName, String username, String pass, String pass1) {
        this.name.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        this.confPass.sendKeys(pass1);
        signUpButton.click();

        return new HomePage(webDriver);
    }

    public SignInPage negSignIn(String name, String lastName) {
        this.name.sendKeys(name);
        this.lastName.sendKeys(lastName);
        signUpButton.click();

        return new SignInPage(webDriver);
    }

    public boolean emptyEmailErrorSignIn() {
        boolean error = emptyEmail.getText().equals("Enter a valid email");
        return error;
    }

}
