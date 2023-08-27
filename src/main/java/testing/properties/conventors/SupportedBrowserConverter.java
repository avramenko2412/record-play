package testing.properties.conventors;

import testing.enumeration.SupportedBrowsers;

import static testing.enumeration.SupportedBrowsers.LOCAL_CHROME;
import static testing.enumeration.SupportedBrowsers.LOCAL_FIREFOX;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName) {
        return switch (webBrowserName) {
            case "local_chrome" -> LOCAL_CHROME;
            case "local_firefox" -> LOCAL_FIREFOX;
            default -> throw new IllegalArgumentException();
        };
    }
}
