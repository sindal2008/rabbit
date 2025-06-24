package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class GoogleTest extends BaseTest {

    private static Process ffmpegProcess;

    @BeforeMethod
    public void startRecording(Method method) {
        String display = System.getenv("DISPLAY");
        System.out.println("🎥 Using DISPLAY=" + display);
        if (display == null) {
            throw new RuntimeException("DISPLAY env is not set!");
        }
        String methodName = method.getName();
        String videoName = "target/video/" + methodName + ".mp4";
        ProcessBuilder builder = new ProcessBuilder(
                "ffmpeg",
                "-y",
                "-f", "x11grab",
                "-video_size", "1536x768",
                "-i", "99",
                "-codec:v", "libx264",
                "-preset", "ultrafast",
                videoName
        );
        builder.redirectErrorStream(true);
        try {
            new File("target/video").mkdirs();
            ffmpegProcess = builder.start();
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void googlePageTitleShouldContainGoogle() throws InterruptedException {
        open("https://www.rambler.ru");
        System.out.println("🧪 DISPLAY = " + System.getenv("DISPLAY"));
        Configuration.reportsFolder = "target/my-screenshots";
        File screenshot = Screenshots.takeScreenShotAsFile();
        System.out.println("Screenshot saved to: " + screenshot.getAbsolutePath());
        String title = Selenide.title();
        assertTrue(title.contains("Рамблер"), "Page title should contain 'Rambler'");
    }

    @AfterMethod
    public static void stopRecording() {
        if (ffmpegProcess != null) {
            ffmpegProcess.destroy();
        }
    }
}
