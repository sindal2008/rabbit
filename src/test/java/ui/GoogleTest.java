package ui;

import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    @Test
    @Video
    public void googlePageTitleShouldContainGoogle() throws InterruptedException {
        Thread.sleep(3000);
    }
}
