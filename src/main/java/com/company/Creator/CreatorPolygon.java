package main.java.com.company.Creator;

import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Point;
import main.java.com.company.Figures.Polygon;

import java.util.ArrayList;

public class CreatorPolygon implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Polygon(points);
    }

}
