package ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.UUID;

public abstract class BaseTest {

    private static String uniqueProfileDir = "/tmp/chrome-profile-" + UUID.randomUUID();

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + uniqueProfileDir);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");  // или "--headless" в старых версиях
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        Configuration.browserCapabilities = options;
    }
}

