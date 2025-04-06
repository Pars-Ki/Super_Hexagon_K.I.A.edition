import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class Menu implements Initializable {
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
    @FXML
    private AnchorPane anchorPane;
    private DropShadow dropShadow = new DropShadow(1, Color.rgb(83, 10, 251));
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MediaManager.initializeBackgroundMedia();
        mediaView.setMediaPlayer(MediaManager.getMediaPlayer());
    }

    public void Mute(ActionEvent event) {
        if (MediaManager.getMediaPlayer().isMute())
            MediaManager.getMediaPlayer().setMute(false);
        else
            MediaManager.getMediaPlayer().setMute(true);
    }

    private void toggleUnderlineAndEffect(Button button) {
        button.setUnderline(!button.isUnderline());
        button.setEffect(button.getEffect() == null ? dropShadow : null);
    }

    public void PlaysetUnerline(MouseEvent event) {
        toggleUnderlineAndEffect(Play);
    }

    public void HistorysetUnerline(MouseEvent event) {
        toggleUnderlineAndEffect(History);
    }

    public void SettingssetUnerline(MouseEvent event) {
        toggleUnderlineAndEffect(Settings);
    }

    public void ExitsetUnerline(MouseEvent event) {
        toggleUnderlineAndEffect(Exit);
    }

    public void Exit(ActionEvent event) {
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    private void switchScene(String fxmlFilePath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFilePath));
            stage = (Stage) anchorPane.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("menuButtons.css");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goToSettings(ActionEvent event) {
        switchScene("settings.fxml");
       // MediaManager.resumeBackgroundMedia();
    }

    public void goToHistory(ActionEvent event) {
        switchScene("history.fxml");
        //MediaManager.resumeBackgroundMedia();
    }

    public void goToPlay(ActionEvent event) {
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(Game.getScene());
        stage.show();

    }
}