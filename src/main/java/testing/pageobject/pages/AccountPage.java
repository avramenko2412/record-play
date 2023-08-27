package testing.pageobject.pages;

import testing.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {
    @FindBy(id = "account__first-name")
    private WebElement name;

    @FindBy(id = "account__last-name")
    private WebElement lastname;

    @FindBy(id = "account__gender")
    private WebElement gender;

    @FindBy(id = "account__birthday")
    private WebElement birthday;

    @FindBy(id = "account__address")
    private WebElement address;

    @FindBy(id = "account__website")
    private WebElement website;

    @FindBy(css = ".account-form")
    private WebElement updateButton;

    @FindBy(css = ".button--fluid")
    private WebElement okButton;

    @FindBy(css = ".alert__button")
    private WebElement alertButton;
    @FindBy(css = ".alert__heading")
    private WebElement alertHeading;


    @FindBy(xpath = "/html/body/main/div/form/div[4]/select/option[3]")
    private WebElement female;


    @FindBy(css = ".comment-form__button:nth-child(1)")
    private WebElement commentButton;

    @FindBy(xpath = "/html/body/main/div/div/div/div/p")
    private WebElement comment;

    protected AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AccountPage editFields(String name, String lastname, String birthday, String address, String website) {
        this.name.click();
        this.name.clear();
        this.name.sendKeys(name);
        this.lastname.click();
        this.lastname.clear();
        this.lastname.sendKeys(lastname);
        this.birthday.click();
        this.birthday.clear();
        this.birthday.sendKeys(birthday);
        this.gender.click();
        this.female.click();
        this.address.click();
        this.address.clear();
        this.address.sendKeys(address);
        this.website.click();
        this.website.clear();
        this.website.sendKeys(website);
        okButton.click();

        return new AccountPage(webDriver);
    }

    public boolean updateSucceed() {
        new WebDriverWait(webDriver, 3);
        return alertButton.isDisplayed();
    }
}
