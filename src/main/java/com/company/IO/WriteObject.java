package main.java.com.company.IO;

import main.java.com.company.Creator.FigureCreator;
import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Point;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObject {
    public static void main(String[] args){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(6, 9);
        Point p5 = new Point(2, 1);

        ArrayList<Point> pointsT = new ArrayList<>(Arrays.asList(p1, p2, p4));
        ArrayList<Point> pointsR = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        ArrayList<Point> pointsC = new ArrayList<>(Arrays.asList(p1, p2));
        ArrayList<Point> pointsP = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        FigureCreator figure = new FigureCreator();


        Figure triangle = figure.create(pointsT);

        Figure rectangle = figure.create(pointsR);

        Figure circle = figure.create(pointsC);

        Figure polygon = figure.create(pointsP);
         ArrayList<Figure> ListFigure = new ArrayList<>(Arrays.asList(triangle,rectangle));
         String result = " ";
        for (var figures: ListFigure) {
            result+=figures;
        }
        System.out.println(result);

        try {
            FileOutputStream fos = new FileOutputStream("TestFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(rectangle);
            oos.writeObject(circle);
            oos.writeObject(polygon);
            oos.writeObject(ListFigure);

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
