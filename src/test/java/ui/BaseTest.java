package ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub"; // URL до Selenoid
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> selenoidOptions = new HashMap<>();
//        selenoidOptions.put("enableVideo", true);
        options.setCapability("selenoid:options", selenoidOptions);

        // Генерация уникальной директории для пользовательских данных
//        String tempDir = System.getProperty("java.io.tmpdir");
//        String userDataDir = tempDir + "/chrome-user-data-" + System.currentTimeMillis();
//        options.addArguments("--user-data-dir=" + userDataDir);

        Configuration.browserCapabilities = options;
    }
}
