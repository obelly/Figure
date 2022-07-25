package com.company.Creator;

import com.company.Figures.Figure;
import com.company.Figures.Circle;
import com.company.Figures.Point;

import java.util.ArrayList;

public class CreatorCircle implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Circle(points);
    }
}
