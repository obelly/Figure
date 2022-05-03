package main.java.com.company.Figures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties ({"perimeter", "square", "radius", "centerFigure"})
public abstract class Figure implements Serializable {
    public ArrayList<Point> points;
    double radius;

    public Figure (ArrayList<Point> points) {
        this.points = points;
        this.radius = getRadius();
    }

    public ArrayList<Point> getPoints (){
        return this.points;
    }

    public double getRadius (){
        Point a = points.get(0);
        Point b = points.get(1);
        radius = Math.sqrt(Math.pow((b.getX()-a.getX()),2)+ Math.pow(((b.getY()- a.getY())), 2));
        return radius;
    }
    public String toString(){
        String result = "I'm " + this.getClass().getSimpleName()+ ", my Points: ";
        for (var point: points) {
            result += point;
        }
        return result;

    }
    public double getPerimeter() {
        double perimeter = 0;
        for (int i = 1; i < points.size(); i++) {
            perimeter += Math.sqrt(Math.pow(points.get(i).getX()-points.get(i-1).getX(), 2) +(Math.pow(points.get(i).getY()-points.get(i-1).getY(), 2)));
        }
            perimeter+= Math.sqrt(Math.pow(points.get(points.size()-1).getX()-points.get(0).getX(), 2) +(Math.pow(points.get(points.size()- 1).getY()-points.get(0).getY(), 2)));
        return perimeter;
    }
    public double getSquare(){
        double square = 0;
        for (int i = 0; i<points.size(); i++){
            int temp = i + 1 < points.size() ? i + 1 : 0;
            square += points.get(i).getX()* points.get(temp).getY() - points.get(temp).getX()* points.get(i).getY();
        }
        return Math.abs(square / 2);
    }
    public Point getCenterFigure(){
        double minX = points.get(0).getX();
        double maxX = points.get(0).getX();
        double minY = points.get(0).getY();
        double maxY = points.get(0).getY();
        for (var point: this.points){
            if (point.getX() > maxX){
                maxX = point.getX();
            }
            if (point.getX() < minX){
                minX = point.getX();
            }
            if (point.getY() > maxY){
                maxY = point.getY();
            }
            if (point.getY() < minY){
                minY = point.getY();
            }
        }
        return new Point(((maxX+minX) / 2), ((maxY+minY) / 2));
    }
    protected void move (int a, int b){
        for (int i = 0; i < points.size();i++){
            points.get(i).setX(points.get(i).getX() + a);
            points.get(i).setY(points.get(i).getY() + b);
        }
    }
    protected void scale (int num) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setX(((points.get(i).getX() - getCenterFigure().getX() * num) + getCenterFigure().getX()));
            points.get(i).setY(((points.get(i).getY() - getCenterFigure().getY() * num) + getCenterFigure().getY()));
        }
    }
    protected void rotate (double angle) {
        angle += Math.PI / 180;
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setX(((points.get(i).getX() - getCenterFigure().getX() * Math.cos(angle)) -
                                (points.get(i).getY() - getCenterFigure().getY() * Math.cos(angle))));

            points.get(i).setX(((points.get(i).getX() - getCenterFigure().getX() * Math.sin(angle)) -
                                (points.get(i).getY() - getCenterFigure().getY() * Math.sin(angle))));
        }
    }
}
