package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class RamblerTest extends BaseTest {

    @Test
    public void ramblerPageTitleShouldContainRambler() {
        open("https://www.rambler.ru");
        String title = Selenide.title();
        assertTrue(title.contains("Рамблер"), "Page title should contain 'Rambler'");
    }
}
