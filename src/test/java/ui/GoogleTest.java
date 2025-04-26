package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GoogleTest {

    @BeforeClass
    public void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub"; // URL до Selenoid
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVideo", true);
        options.setCapability("selenoid:options", selenoidOptions);

        Configuration.browserCapabilities = options;
    }

    @Test
    public void googlePageTitleShouldContainGoogle() {
        open("https://www.google.com");
        String title = Selenide.title();
        assertTrue(title.contains("Google"), "Page title should contain 'Google'");
    }
}

