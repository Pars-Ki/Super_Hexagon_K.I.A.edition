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
    @FXML
    private AnchorPane anchorPane;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MediaManager.initializeBackgroundMedia();
        mediaView.setMediaPlayer(MediaManager.getMediaPlayer());
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