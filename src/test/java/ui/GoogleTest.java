package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    @Test
    public void googlePageTitleShouldContainGoogle() throws InterruptedException {
        Thread.sleep(3000);
    }
}
