import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MediaManager {
    private static MediaPlayer mediaPlayer;

    public static void initializeBackgroundMedia() {
        if (mediaPlayer == null) {
            File file = new File("background.mp4");
            Media media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setAutoPlay(true);
        }
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    /*
    public static void pauseBackgroundMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public static void resumeBackgroundMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }
    */
}