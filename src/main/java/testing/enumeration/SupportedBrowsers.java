package testing.enumeration;

import testing.invoker.WebDriverInvoker;
import testing.invoker.implementations.LocalChromeInvoker;
import testing.invoker.implementations.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCAL_FIREFOX(new LocalFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker());

    private final WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}
