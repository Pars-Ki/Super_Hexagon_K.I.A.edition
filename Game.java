import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private static AnchorPane gamePane = new AnchorPane();
    Group group = new Group();
    mahlar player = new mahlar();
    Shapes shapes = new Shapes();
    Timeline timeline = new Timeline();
    Polygon CenterHexagon = new Polygon();
    private Label timerLabel = new Label();
    Parent root;
    public double timeElapsed = 0;
    private double Speed = 1;
    private Random random = new Random();
    private int a = 50;
    private int b = 100;
    private int x;

    private int c = 400;
    private int d = 450;
    private int y;

    private int f = 750;
    private int g = 800;
    private int z;

    private ArrayList<Polygon> mavane1 = new ArrayList<Polygon>();
    private ArrayList<Polygon> mavane2 = new ArrayList<Polygon>();
    private ArrayList<Polygon> mavane3 = new ArrayList<Polygon>();
    ArrayList<Polygon> BackgroundPolygons= new ArrayList<>();
    public Game() {
        try {
            root = FXMLLoader.load(getClass().getResource("Gameover.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
            if (b <= 50){
                mavane1=new ArrayList<Polygon>();
                a = 1100;
                b = 1150;
                if (random.nextInt(2)==1){
                    x = random.nextInt(2);
                    mavane1=shapes.mane2(a,b,x);
                }
                else {
                    x= random.nextInt(6);
                    mavane1=shapes.mane1(a,b,x);
                }
                for (int i=0; i<mavane1.size(); i++)
                    group.getChildren().add(mavane1.get(i));
            }
            else{
                a-= Speed;
                b-=Speed;
                for (int i=0;i< mavane1.size(); i++){
                    shapes.TransferMane(a,b,mavane1,x);
                }
            }

            if (d <= 50){
                mavane2=new ArrayList<Polygon>();
                c = 1100;
                d = 1150;
                if (random.nextInt(2)==1){
                    y = random.nextInt(2);
                    mavane2=shapes.mane2(c,d,y);
                }
                else {
                    y= random.nextInt(6);
                    mavane2=shapes.mane1(c,d,y);
                }
                for (int i=0; i<mavane2.size(); i++)
                    group.getChildren().add(mavane2.get(i));
            }
            else{
                c-= Speed;
                d-= Speed;
                for (int i=0;i< mavane2.size(); i++){
                    shapes.TransferMane(c,d,mavane2,y);
                }
            }


            if (g <= 50){
                mavane3=new ArrayList<Polygon>();
                f = 1100;
                g = 1150;
                if (random.nextInt(2)==1){
                    z = random.nextInt(2);
                    mavane3=shapes.mane2(f,g,z);
                }
                else {
                    z= random.nextInt(6);
                    mavane3=shapes.mane1(f,g,z);
                }
                for (int i=0; i<mavane3.size(); i++)
                    group.getChildren().add(mavane3.get(i));
            }
            else{
                f-= Speed;
                g-= Speed;
                for (int i=0;i< mavane3.size(); i++){
                    shapes.TransferMane(f,g,mavane3,z);
                }
            }




            group.setRotate(group.getRotate()+Speed);
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        KeyFrame speedchanger = new KeyFrame(Duration.seconds(10), e-> {
            Speed+=0.25;
        });
        Timeline Speedchanger = new Timeline(speedchanger);
        Speedchanger.setCycleCount(Timeline.INDEFINITE);
        Speedchanger.play();

        timerLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");
        timerLabel.setLayoutX(20);
        timerLabel.setLayoutY(20);

        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {
            timeElapsed += 0.01;
            timerLabel.setText("Time: " + timeElapsed + "s");
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        Timeline collisinchecker = new Timeline(new KeyFrame(Duration.seconds(0.01), e -> {
            if (isCollisionDetected(player.mahlar,mavane1)) {
                gamePane.getChildren().add(root);
                timeline.stop();
                timer.stop();
            }
            if (isCollisionDetected(player.mahlar,mavane2)) {
                gamePane.getChildren().add(root);
                timeline.stop();
                timer.stop();
            }
            if (isCollisionDetected(player.mahlar,mavane3)) {
                gamePane.getChildren().add(root);
                timeline.stop();
                timer.stop();
            }
        }));
        collisinchecker.setCycleCount(Timeline.INDEFINITE);
        collisinchecker.play();

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

    public static boolean isCollisionDetected(Polygon mahlar, ArrayList<Polygon> mavaneList) {
            for (Polygon obstacle : mavaneList) {
                Shape intersection = Shape.intersect(mahlar, obstacle);
                if (intersection.getBoundsInLocal().getWidth() > 0 || intersection.getBoundsInLocal().getHeight() > 0) {
                    return true;
                }
            }
            return false;
    }


    public static Scene getScene() {
        return new Scene(gamePane, 1280, 720);
    }

    public void startGame() {
        timeline.play();
    }
}