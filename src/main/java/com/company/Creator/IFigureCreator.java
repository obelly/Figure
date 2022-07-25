package com.company.Creator;

import com.company.Figures.Figure;
import com.company.Figures.Point;

import java.util.ArrayList;

public interface IFigureCreator {
    Figure create (ArrayList<Point>points);
}
