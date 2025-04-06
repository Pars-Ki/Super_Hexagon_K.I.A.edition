import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Settings implements Initializable {
    @FXML
    private MediaView mediaView;
    @FXML
    private Button back;
    private DropShadow dropShadow = new DropShadow (1,Color.rgb(83, 10, 251));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaView.setMediaPlayer(MediaManager.getMediaPlayer());
       // MediaManager.resumeBackgroundMedia();
    }
    public void back(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("menuButtons.css");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toggleUnderlineAndEffect(Button button) {
        button.setUnderline(!button.isUnderline());
        button.setEffect(button.getEffect() == null ? dropShadow : null);
    }
    public void backdropshodow(MouseEvent e){
        toggleUnderlineAndEffect(back);
    }
    public void mute(ActionEvent event){
        MediaManager.getMediaPlayer().setMute(MediaManager.getMediaPlayer().isMute() ? false : true);
    }
}