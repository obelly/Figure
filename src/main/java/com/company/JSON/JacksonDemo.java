package com.company.JSON;

import com.company.Creator.FigureCreator;
import com.company.Figures.Figure;
import com.company.Figures.Point;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class JacksonDemo {
    public static void main(String[] args) throws IOException {
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

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, triangle);

        String result = writer.toString();
        System.out.println(result);

    }
}
