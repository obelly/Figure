package com.company.Figures;



import java.io.Serializable;
import java.util.ArrayList;


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
    public void move (Point a){
        for (int i = 0; i < points.size();i++){
            points.get(i).setX(points.get(i).getX() + a.getX());
            points.get(i).setY(points.get(i).getY() + a.getY());
        }
    }
    public void scale (double num) {
        Point center = getCenterFigure();
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setX((((points.get(i).getX() - center.getX()) * num) + center.getX()));
            points.get(i).setY((((points.get(i).getY() - center.getY()) * num) + center.getY()));
        }
    }
    public void rotate (double angle) {
            double side = 0;
            angle = Math.toRadians(angle);
            Point center=getCenterFigure();
            for (int i = 0; i < points.size(); i++) {

                double x= ((points.get(i).getX()-center.getX())*Math.cos(angle)-(points.get(i).getY()-center.getY())*Math.sin(angle));
                double y= ((points.get(i).getX()-center.getX())*Math.cos(angle)+(points.get(i).getY()-center.getY())*Math.sin(angle));
                points.set(i,new Point(x+center.getX(),y+center.getY()));
            }
        }
    public boolean containPoint (int x,int y){//int multiplierX,int multiplierY){
        boolean flag = false;
        for (int i = 0; i< this.getPoints().size(); i++){
            int j = i ==this.getPoints().size() - 1 ? 0: i+1;
            double x1 = this.getPoints().get(i).getX();//*multiplierX;
            double x2 = this.getPoints().get(j).getX();//*multiplierX;
            double y1 = this.getPoints().get(i).getY();//*multiplierY;
            double y2 = this.getPoints().get(j).getY();//*multiplierY;

            if (x2-x1 != 0){
                double a = (y2-y1) / (x2-x1);
                double b = y1 - a * x1;
                if ((Math.abs(y - (int) (a * x + b)) <= 2)) {
                    flag = true;}
                else {
                    if ((Math.abs(x-x1) <= 2) && (y >= Math.min(y1, y2) && y<Math.max(y1,y2))){
                        flag = true;
                    }
                }
            }
        }
        return flag;
    };
}
