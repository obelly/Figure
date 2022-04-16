package com.company;

import com.company.Creator.FigureCreator;
import com.company.Figures.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        figure();
   }

     public static void figure (){
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,4);
        Point p3 = new Point(2,2);
        Point p4 = new Point(6 ,9);
        Point p5 = new Point(2,1);

        ArrayList<Point> pointsT = new ArrayList<>(Arrays.asList(p1,p2,p4));
        ArrayList<Point> pointsR = new ArrayList<>(Arrays.asList(p1,p2,p3,p4));
        ArrayList<Point> pointsC = new ArrayList<>(Arrays.asList(p1,p2));
        ArrayList<Point> pointsP = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));

        FigureCreator figure = new FigureCreator();

        Figure triangle = figure.create(pointsT);
        System.out.println(triangle);

        Figure rectangle = figure.create(pointsR);
        System.out.println(rectangle);

        Figure circle = figure.create(pointsC);
        System.out.println(circle);

        Figure polygon = figure.create(pointsP);
        System.out.println(polygon);

    }
    public static void car(){
         Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
    }




}