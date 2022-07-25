package com.company.Creator;

import com.company.Figures.Figure;
import com.company.Figures.Point;
import com.company.Figures.Rectangle;

import java.util.ArrayList;

public class CreatorRentangle implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        return new Rectangle(points);
    }
}

