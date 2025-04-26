package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GoogleTest {

    @BeforeClass
    public void setUp() {
        // Если тест будет крутиться в CI — раскомментируешь это:
         Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void googlePageTitleShouldContainGoogle() {
        open("https://www.google.com");
        String title = Selenide.title();
        assertTrue(title.contains("Google"), "Page title should contain 'Google'");
    }
}

