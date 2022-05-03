package main.java.com.company.Creator;

import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Point;
import main.java.com.company.Figures.Triangle;

import java.util.ArrayList;

public class CreatorTriangle implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Triangle(points);
    }
}
