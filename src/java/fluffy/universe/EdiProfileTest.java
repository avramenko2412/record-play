// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class EdiProfileTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void ediProfile() {
    driver.get("http://127.0.0.1:7000/");
    driver.manage().window().setSize(new Dimension(974, 1040));
    driver.findElement(By.linkText("My profile")).click();
    driver.findElement(By.id("account__gender")).click();
    {
      WebElement dropdown = driver.findElement(By.id("account__gender"));
      dropdown.findElement(By.xpath("//option[. = 'Male']")).click();
    }
    driver.findElement(By.id("account__birthday")).click();
    driver.findElement(By.id("account__birthday")).click();
    driver.findElement(By.id("account__birthday")).sendKeys("2000-12-24");
    driver.findElement(By.cssSelector(".button--fluid")).click();
    driver.findElement(By.cssSelector(".alert__button")).click();
  }
}
