package com.company.Figures;

import java.util.List;

public abstract class Figure  {
    public List<Point> points;

    public Figure (List<Point> points) {
        this.points = points;
        this.getSquare();
    }


    public String toString(){
        return "I'm " + getClass().getSimpleName()+  ", my Perimeter = " + getPerimeter() + ", my Square = " + getSquare();
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

}
