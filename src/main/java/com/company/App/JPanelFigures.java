package main.java.com.company.App;

import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelFigures extends JPanel {
    private ArrayList<Figure> figures;

    public JPanelFigures(ArrayList<Figure> figures) {
        super();
        this.setSize(500,500);
        this.figures = figures;


    }

    public void paint(Graphics g) {
        for (var fig : figures) {
            for (int i = 0; i < fig.getPoints().size(); i++) {
                Point value1 = fig.getPoints().get(i);
                if (fig.getPoints().size() == 2) {
                    g.drawOval((int) fig.getPoints().get(0).getX(), (int) fig.getPoints().get(0).getY(),
                               (int) (fig.getRadius() * 2), (int) (fig.getRadius() * 2));
                } else {
                    int temp = i + 1 < fig.getPoints().size() ? i + 1 : 0;
                    Point value2 = fig.getPoints().get(temp);
                    g.drawLine((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
                }
            }
        }
    }

}
