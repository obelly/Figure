package com.company;

import com.company.Figures.Figure;
import com.company.NewApp.GraphicApp;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       GraphicApp app = new GraphicApp(new ArrayList<Figure>());
       app.show();
    }
}