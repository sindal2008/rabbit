package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    @Test
    public void googlePageTitleShouldContainGoogle() {
        open("https://www.google.com");
        String title = Selenide.title();
        assertTrue(title.contains("Google"), "Page title should contain 'Google'");
    }
}
