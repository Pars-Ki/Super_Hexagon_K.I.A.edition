import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaView;
import java.net.URL;
import java.util.ResourceBundle;

public class History implements Initializable {
    @FXML
    private MediaView mediaView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaView.setMediaPlayer(MediaManager.getMediaPlayer());
        //MediaManager.resumeBackgroundMedia();
    }
}