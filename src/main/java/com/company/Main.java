package main.java.com.company;

import main.java.com.company.App.JFrame;
import main.java.com.company.App.JPanelFigures;
import main.java.com.company.Creator.FigureCreator;
import main.java.com.company.Figures.Figure;

import main.java.com.company.Figures.Point;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(100, 250);
        Point p2 = new Point(200, 240);
        Point p3 = new Point(245, 256);
        Point p4 = new Point(162, 269);
        Point p5 = new Point(200, 100);
        Point p6 = new Point(300, 400);
        Point p7 = new Point(150, 200);
        Point p8 = new Point(100, 100);
        Point p9 = new Point(200, 200);
        Point p10 = new Point(300, 100);
        Point p11 = new Point(350, 150);


        ArrayList<Point> pointsT = new ArrayList<>(Arrays.asList(p1, p2, p3));
        ArrayList<Point> pointsR = new ArrayList<>(Arrays.asList(p4, p5, p6, p7));
        ArrayList<Point> pointsC = new ArrayList<>(Arrays.asList(p8, p9));
        ArrayList<Point> pointsP = new ArrayList<>(Arrays.asList(p10, p11, p3, p4, p5));

        FigureCreator figure = new FigureCreator();

        Figure triangle = figure.create(pointsT);
        //System.out.println(triangle);
        Figure rectangle = figure.create(pointsR);
        //System.out.println(rectangle);
        Figure circle = figure.create(pointsC);
        //System.out.println(circle);
        Figure polygon = figure.create(pointsP);
        //System.out.println(polygon);


        JFrame frame = new JFrame();
        frame.setVisible(true);


        ArrayList<Figure> figures = new ArrayList<>(Arrays.asList(triangle,rectangle,circle,polygon));
        JPanelFigures PanelFigures = new JPanelFigures(figures); //панель с фигурами
        frame.getContentPane().add(PanelFigures); //добавить панель с фигурами

        //frame.revalidate();

        //frame.revalidate();



    }
}