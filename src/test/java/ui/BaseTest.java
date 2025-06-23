package ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
//        Configuration.remote = "http://localhost:4444/wd/hub"; // URL до Selenoid
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;

    }
}
