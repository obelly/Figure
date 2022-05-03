package main.java.com.company.Figures;
import java.util.ArrayList;


public class Circle extends Figure {
    double radius;
    public Circle(ArrayList<Point> points){
        super(points);
        this.radius = getRadius();
        }

    public double getRadius (){
        Point a = points.get(0);
        Point b = points.get(1);
        radius = Math.sqrt(Math.pow((b.getX()-a.getX()),2)+ Math.pow(((b.getY()- a.getY())), 2));
        return radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getSquare() {
        return  Math.PI * Math.pow(radius, 2);

    }




}
