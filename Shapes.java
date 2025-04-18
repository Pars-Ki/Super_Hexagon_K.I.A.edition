import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

public class Shapes {
    public static int neww=0;
    public static double r;
    public static ArrayList<Point2D>p = new ArrayList<>();
    ArrayList<Line> lines = new ArrayList<>();
    public double a=950;
    public double b=900;

    public static void enterPoints(double r){
        p.add(new Point2D(r, 0.0));
        p.add(new Point2D( 0.5*r, Math.sqrt(3)/2*r));
        p.add(new Point2D( -0.5*r, Math.sqrt(3)/2*r));
        p.add(new Point2D(-r,0.0));
        p.add(new Point2D( -0.5*r, -Math.sqrt(3)/2*r));
        p.add(new Point2D( 0.5*r, -Math.sqrt(3)/2*r));
    }

    public Polygon hexagon(double r){
        Polygon hexagon = new Polygon();
        hexagon.setTranslateX(640);
        hexagon.setTranslateY(360);
        hexagon.getPoints().addAll(r, (double)0, 0.5*r, Math.sqrt(3)/2*r, -0.5*r,Math.sqrt(3)/2*r, -r, (double)0, -0.5*r, -Math.sqrt(3)/2*r, 0.5*r, -Math.sqrt(3)/2*r);
        return hexagon;
    }
    public void lines (ArrayList<Point2D> p){
        lines.add(new Line(0.0,0.0, 0.5*1450, Math.sqrt(3)/2*1450));
        lines.add(new Line(0.0,0.0, -0.5*1450, Math.sqrt(3)/2*1450));
        lines.add(new Line(0.0,0.0, 0.5*1450, -Math.sqrt(3)/2*1450));
        lines.add(new Line(0.0,0.0, -0.5*1450, -Math.sqrt(3)/2*1450));
        lines.add(new Line(0.0,0.0, 1450, 0.0));
        lines.add(new Line(0.0,0.0, -1450, 0.0));
        for (int i=0;i<lines.size();i++){
            lines.get(i).setTranslateX(640);
            lines.get(i).setTranslateY(360);
        }
    }
    public Polygon obstacle1 (double a, double b){
        Polygon avali = new Polygon();
        avali = new Polygon(0.5*a,Math.sqrt(3)/2*a,0.5*b,Math.sqrt(3)/2*b,-0.5*b, Math.sqrt(3)/2*b, -0.5*a, Math.sqrt(3)/2*a);
        avali.setTranslateX(640);
        avali.setTranslateY(360);
        return  avali;
    }

    public void Shape1SetPoint(double a, double b, Polygon shape){
        shape.getPoints().setAll(
                0.5 * a, Math.sqrt(3) / 2 * a,
                0.5 * b, Math.sqrt(3) / 2 * b,
                -0.5 * b, Math.sqrt(3) / 2 * b,
                -0.5 * a, Math.sqrt(3) / 2 * a
        );
    }


    public Polygon obstacle2 (double a, double b){
        Polygon avali = new Polygon();
        avali = new Polygon(-0.5*a,Math.sqrt(3)/2*a,-0.5*b,Math.sqrt(3)/2*b, -b, 0.0, -a, 0.0);
        avali.setTranslateX(640);
        avali.setTranslateY(360);
        return  avali;
    }

    public void Shape2SetPoint(double a, double b, Polygon shape){
        shape.getPoints().setAll(
                -0.5 * a, Math.sqrt(3) / 2 * a,
                -0.5 * b, Math.sqrt(3) / 2 * b,
                -b, 0.0,
                -a, 0.0
        );
    }


    public Polygon obstacle3 (double a, double b){
        Polygon avali = new Polygon();
        avali = new Polygon(-a,0.0,-b,0.0,-0.5*b, -Math.sqrt(3)/2*b, -0.5*a, -Math.sqrt(3)/2*a);
        avali.setTranslateX(640);
        avali.setTranslateY(360);
        return  avali;
    }

    public void Shape3SetPoint(double a, double b, Polygon shape){
        shape.getPoints().setAll(
                -a, 0.0,
                -b, 0.0,
                -0.5 * b, -Math.sqrt(3) / 2 * b,
                -0.5 * a, -Math.sqrt(3) / 2 * a
        );
    }



    public Polygon obstacle4 (double a, double b){
        Polygon avali = new Polygon();
        avali = new Polygon(-0.5*a,-Math.sqrt(3)/2*a,-0.5*b,-Math.sqrt(3)/2*b,0.5*b, -Math.sqrt(3)/2*b, 0.5*a, -Math.sqrt(3)/2*a);
        avali.setTranslateX(640);
        avali.setTranslateY(360);
        return  avali;
    }

    public void Shape4SetPoint(double a, double b, Polygon shape){
        shape.getPoints().setAll(
                -0.5 * a, -Math.sqrt(3) / 2 * a,
                -0.5 * b, -Math.sqrt(3) / 2 * b,
                0.5 * b, -Math.sqrt(3) / 2 * b,
                0.5 * a, -Math.sqrt(3) / 2 * a
        );
    }



    public Polygon obstacle5 (double a, double b){
        Polygon avali = new Polygon();
        avali = new Polygon(0.5*a,-Math.sqrt(3)/2*a,0.5*b,-Math.sqrt(3)/2*b,b, 0.0, a, 0.0);
        avali.setTranslateX(640);
        avali.setTranslateY(360);
        return  avali;
    }

    public void Shape5SetPoint(double a, double b, Polygon shape){
        shape.getPoints().setAll(
                0.5 * a, -Math.sqrt(3) / 2 * a,
                0.5 * b, -Math.sqrt(3) / 2 * b,
                b, 0.0,
                a, 0.0
        );
    }




    public Polygon obstacle6 (double a, double b){
        Polygon avali = new Polygon();
        avali = new Polygon(a, 0.0, b, 0.0, 0.5*b, Math.sqrt(3)/2*b, 0.5*a, Math.sqrt(3)/2*a);
        avali.setTranslateX(640);
        avali.setTranslateY(360);
        return  avali;
    }

    public void Shape6SetPoint(double a, double b, Polygon shape){
        shape.getPoints().setAll(
                a, 0.0,
                b, 0.0,
                0.5 * b, Math.sqrt(3) / 2 * b,
                0.5 * a, Math.sqrt(3) / 2 * a
        );
    }


}
