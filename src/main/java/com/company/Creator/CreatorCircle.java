package main.java.com.company.Creator;

import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Circle;
import main.java.com.company.Figures.Point;

import java.util.ArrayList;

public class CreatorCircle implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Circle(points);
    }
}
