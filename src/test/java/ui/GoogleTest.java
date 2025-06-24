package ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    private static Process ffmpegProcess;

    @BeforeMethod
    public void startRecording(Method method) {
        String methodName = method.getName();
        String videoName = "target/video/" + methodName + ".mp4";
        ProcessBuilder builder = new ProcessBuilder(
                "ffmpeg",
                "-y",
                "-f", "x11grab",
                "-video_size", "1536x768",
                "-i", System.getenv("DISPLAY") + ".0",
                "-codec:v", "libx264",
                "-preset", "ultrafast",
                videoName
        );
        builder.redirectErrorStream(true);
        try {
            ffmpegProcess = builder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void googlePageTitleShouldContainGoogle() throws InterruptedException {
        open("https://www.rambler.ru");
        String title = Selenide.title();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(title);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        assertTrue(title.contains("Рамблер"), "Page title should contain 'Rambler'");
    }

    @AfterMethod
    public static void stopRecording() {
        if (ffmpegProcess != null) {
            ffmpegProcess.destroy();
        }
    }
}
