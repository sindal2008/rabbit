package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest extends BaseTest {

    private static Process ffmpegProcess;

    @BeforeMethod
    public static void startRecording(String methodName) {
        String videoName = "target/video/" + methodName + ".mp4";
        ProcessBuilder builder = new ProcessBuilder(
                "ffmpeg",
                "-y",
                "-f", "x11grab",
                "-video_size", "1536x768",
                "-i", System.getenv("DISPLAY"),
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
        Thread.sleep(5000);
    }

    @AfterMethod
    public static void stopRecording() {
        if (ffmpegProcess != null) {
            ffmpegProcess.destroy();
        }
    }
}
