import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game {

    private static AnchorPane gamePane = new AnchorPane();
    Group group = new Group();
    mahlar player = new mahlar();
    Shapes shapes = new Shapes();
    Timeline timeline = new Timeline();
    Polygon CenterHexagon = new Polygon();
    private Label timerLabel = new Label();
    private double timeElapsed = 0;
    ArrayList<Polygon> BackgroundPolygons= new ArrayList<>();
    public Game() {
        BackgroundPolygons.add(shapes.obstacle1(50,1000));
        BackgroundPolygons.add(shapes.obstacle2(50,1000));
        BackgroundPolygons.add(shapes.obstacle3(50,1000));
        BackgroundPolygons.add(shapes.obstacle4(50,1000));
        BackgroundPolygons.add(shapes.obstacle5(50,1000));
        BackgroundPolygons.add(shapes.obstacle6(50,1000));
        RadialGradient gradient1 = new RadialGradient(
                0, 0.1, 0, 0, 100, false,
                CycleMethod.REFLECT,
                new Stop(0, Color.web("#191970")),
                new Stop(1, Color.web("#008080"))
        );
        RadialGradient gradient2 = new RadialGradient(
                0, 0.1, 0, 0, 50, false,
                CycleMethod.REFLECT,
                new Stop(0, Color.web("#c5cbcd" )),
                new Stop(1, Color.web("#0d0b4d"))
        );

        for (int i=0;i<6;i++){
            if(i % 2 == 0)
                BackgroundPolygons.get(i).setFill(gradient1);
            else BackgroundPolygons.get(i).setFill(gradient2);
            group.getChildren().add(BackgroundPolygons.get(i));
        }

        gamePane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, null)));
        Shapes.enterPoints(50);
        shapes.lines(shapes.p);
        CenterHexagon = shapes.hexagon(50);
        for(int i=0; i<shapes.lines.size(); i++){
            group.getChildren().add(shapes.lines.get(i));
        }
        group.getChildren().add(CenterHexagon);
        group.getChildren().add(player.mahlar);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5), e -> {

            group.setRotate(group.getRotate()+1);
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        timerLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");
        timerLabel.setLayoutX(20);
        timerLabel.setLayoutY(20);

        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {
            timeElapsed += 0.01;
            timerLabel.setText("Time: " + timeElapsed + "s");
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        gamePane.getChildren().add(group);
        gamePane.getChildren().add(timerLabel);
        initializeMouseHandlers();
    }

    private void initializeMouseHandlers() {
        gamePane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                player.rotate(30);
            } else if (event.getButton() == MouseButton.PRIMARY) {
                player.rotate(-30);
            }
        });
    }

    private void startTimer() {
        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeElapsed++;
            timerLabel.setText("Time: " + timeElapsed + "s");
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }


    public static Scene getScene() {
        return new Scene(gamePane, 1280, 720);
    }

    public void startGame() {
        timeline.play();
    }
}