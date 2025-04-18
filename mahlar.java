import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class mahlar {
    private static double CenterX = 640;
    private static double CenterY = 360;
    private static double radius = 80;
    public static Polygon mahlar = new Polygon(CenterX - 12, CenterY + 9, CenterX, CenterY - 15, CenterX + 12, CenterY + 9);

    public void rotate(double angle) {
        mahlar.setRotate(mahlar.getRotate() + angle);

        double radians = Math.toRadians(mahlar.getRotate()) - Math.toRadians(90);

        double newX = CenterX + radius * Math.cos(radians);
        double newY = CenterY + radius * Math.sin(radians);

        mahlar.setLayoutX(newX - CenterX);
        mahlar.setLayoutY(newY - CenterY);
    }

    static {
        mahlar.setLayoutX(0);
        mahlar.setLayoutY(-80);
        mahlar.setFill(Color.IVORY);
    }
}