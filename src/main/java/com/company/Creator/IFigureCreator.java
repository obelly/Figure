package main.java.com.company.Creator;

import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Point;

import java.util.ArrayList;

public interface IFigureCreator {
    Figure create (ArrayList<Point>points);
}
