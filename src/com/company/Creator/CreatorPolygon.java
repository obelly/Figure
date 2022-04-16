package com.company.Creator;

import com.company.Figures.Figure;
import com.company.Figures.Point;
import com.company.Figures.Polygon;

import java.util.ArrayList;

public class CreatorPolygon implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Polygon(points);
    }

}
