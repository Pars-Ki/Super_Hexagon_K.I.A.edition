import javafx.geometry.Point2D;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.Random;

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

    public ArrayList<Polygon> mane1 (double a, double b, int j){
        ArrayList<Polygon> mane = new ArrayList<Polygon>();
        mane.add(obstacle1(1000,950));
        mane.add(obstacle2(1000,950));
        mane.add(obstacle3(1000,950));
        mane.add(obstacle4(1000,950));
        mane.add(obstacle5(1000,950));
        mane.add(obstacle6(1000,950));

        mane.remove(j);

        return mane;
    }

    public ArrayList<Polygon> mane2 (double a, double b, int j){
        ArrayList<Polygon> mane = new ArrayList<Polygon>();
        mane.add(obstacle1(1000,950));
        mane.add(obstacle2(1000,950));
        mane.add(obstacle3(1000,950));
        mane.add(obstacle4(1000,950));
        mane.add(obstacle5(1000,950));
        mane.add(obstacle6(1000,950));

        mane.remove(j);
        mane.remove(j+1);
        mane.remove(j+2);

        return mane;
    }


    public void TransferMane (double a, double b, ArrayList<Polygon> mane, int j){
        if(mane.size() == 3){
            if (j==1){
                Shape1SetPoint(a,b,mane.get(0));
                Shape3SetPoint(a,b,mane.get(1));
                Shape5SetPoint(a,b,mane.get(2));
            }
            else{
                Shape2SetPoint(a,b,mane.get(0));
                Shape4SetPoint(a,b,mane.get(1));
                Shape6SetPoint(a,b,mane.get(2));
            }
        }
        else {
            if(j==0){
                Shape2SetPoint(a,b,mane.get(0));
                Shape3SetPoint(a,b,mane.get(1));
                Shape4SetPoint(a,b,mane.get(2));
                Shape5SetPoint(a,b,mane.get(3));
                Shape6SetPoint(a,b,mane.get(4));
            }
            else if(j==1){
                Shape1SetPoint(a,b,mane.get(0));
                Shape3SetPoint(a,b,mane.get(1));
                Shape4SetPoint(a,b,mane.get(2));
                Shape5SetPoint(a,b,mane.get(3));
                Shape6SetPoint(a,b,mane.get(4));
            }
            else if(j==2){
                Shape1SetPoint(a,b,mane.get(0));
                Shape2SetPoint(a,b,mane.get(1));
                Shape4SetPoint(a,b,mane.get(2));
                Shape5SetPoint(a,b,mane.get(3));
                Shape6SetPoint(a,b,mane.get(4));
            }
            else if(j==3){
                Shape1SetPoint(a,b,mane.get(0));
                Shape2SetPoint(a,b,mane.get(1));
                Shape3SetPoint(a,b,mane.get(2));
                Shape5SetPoint(a,b,mane.get(3));
                Shape6SetPoint(a,b,mane.get(4));
            }
            else if(j==4){
                Shape1SetPoint(a,b,mane.get(0));
                Shape2SetPoint(a,b,mane.get(1));
                Shape3SetPoint(a,b,mane.get(2));
                Shape4SetPoint(a,b,mane.get(3));
                Shape6SetPoint(a,b,mane.get(4));
            }
            else if(j==5){
                Shape1SetPoint(a,b,mane.get(0));
                Shape2SetPoint(a,b,mane.get(1));
                Shape3SetPoint(a,b,mane.get(2));
                Shape4SetPoint(a,b,mane.get(3));
                Shape5SetPoint(a,b,mane.get(4));
            }
        }
    }


}