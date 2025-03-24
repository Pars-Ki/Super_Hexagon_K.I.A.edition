import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Menu implements Initializable{
    @FXML
    private MediaView mediaView;
    private Media media;
    private File file;
    private MediaPlayer mediaPlayer;
    @FXML
    private Button Play;
    @FXML
    private Button History;
    @FXML
    private Button Settings;
    @FXML
    private Button Exit;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new File("background.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);

    }
    public void Mute(ActionEvent event){
        if(mediaPlayer.getVolume() > 0)
            mediaPlayer.setVolume(0);
        else mediaPlayer.setVolume(1.0);
    }
    public void PlaysetUnerline(MouseEvent event) {
        if(Play.isUnderline())
            Play.setUnderline(false);
        else if(!Play.isUnderline())
            Play.setUnderline(true);
    }
    public void HistorysetUnerline(MouseEvent event) {
        if(History.isUnderline())
            History.setUnderline(false);
        else if(!History.isUnderline())
            History.setUnderline(true);
    }
    public void SettingssetUnerline(MouseEvent event) {
        if(Settings.isUnderline())
            Settings.setUnderline(false);
        else if(!Settings.isUnderline())
            Settings.setUnderline(true);
    }
    public void ExitsetUnerline(MouseEvent event) {
        if(Exit.isUnderline())
            Exit.setUnderline(false);
        else if(!Exit.isUnderline())
            Exit.setUnderline(true);
    }
}