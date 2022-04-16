package com.company.Creator;

import com.company.Figures.Figure;
import com.company.Figures.Point;
import com.company.Figures.Triangle;

import java.util.ArrayList;

public class CreatorTriangle implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Triangle(points);
    }
}
