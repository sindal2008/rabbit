package ui;

import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    @Test
    @Video
    public void shouldFailAndCreateRecordWithTestName() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assert false;
    }

    @Test
    @Video(name = "second_test")
    public void videoShouldHaveNameSecondTest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(false);
    }
}
