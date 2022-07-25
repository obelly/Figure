package com.company.App;

import com.company.Figures.Figure;
import com.company.Figures.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelFigures extends JPanel {

    private ArrayList<Figure> figures;
    public int multiplierX, multiplierY;

    public JPanelFigures(ArrayList<Figure> figures) {
        super();
        this.figures = figures;
        //points = new ArrayList<>();
    }

    public void paint(Graphics g) {
        //super.paint (g);
        int width = this.getWidth(); // сохраняем текущую ширину панели
        int height = this.getHeight(); // и высоту
        int startX = 0;
        int startY = 0;

        Graphics figurePane = g.create(startX, startY, width, height);
        drawGrid(figurePane, width, height);
        drawAxis(figurePane, width, height);
        if (figures != null) {
            for (Figure figure : figures) {
                drawFigures(g, figure);//, multiplierX, multiplierY);
            }

        if (figures.size() > 0) {
            double minX = figures.get(0).getPoints().get(0).getX();
            double minY = figures.get(0).getPoints().get(0).getY();
            double maxX = figures.get(0).getPoints().get(0).getX();
            double maxY = figures.get(0).getPoints().get(0).getY();
            for (Figure figure : figures) {
                for (Point point : figure.getPoints()) {
                    if (point.getX() < minX) minX = point.getX();
                    if (point.getX() > maxX) maxX = point.getX();
                    if (point.getY() < minY) minY = point.getY();
                    if (point.getY() > maxY) maxY = point.getY();
                }
            }
            // Проверить кто больше мин х или мин у, взять модуль от этого числа
//            int moduleX = Math.abs(maxX) > Math.abs(minX) ? (int) Math.abs(maxX) : (int) Math.abs(minX);
//            int moduleY = Math.abs(maxY) > Math.abs(minY) ? (int) Math.abs(maxY) : (int) Math.abs(minY);
//
//            multiplierX = (int) (this.getWidth() * 0.9 / moduleX);// делить на модуль!
//            multiplierY = (int) (this.getHeight() * 0.9 / moduleY);
            }
        }
    }
    public void drawFigures(Graphics g, Figure figure){ //int multiplierX, int multiplierY){
            for (var fig : figures) {
                if (fig.getPoints().size() == 2) {
//                    Circle circle = (Circle) fig;
//                    double radius = circle.getRadius();
                    //!!!!!!!!!!!!!не работает!!!!!!!!!!!!!!!!!!
//                    int multiplier = Math.min(multiplierX, multiplierY);
//                    g.drawOval((int) fig.getPoints().get(0).getX() * multiplier + getWidth() / 2,
//                            getHeight() / 2 - ((int) fig.getPoints().get(0).getY() * multiplier),
//                            (int) fig.getRadius() * 2, (int) fig.getRadius() * 2);
                    g.drawOval((int) fig.getPoints().get(0).getX() + getWidth() / 2,
                            getHeight() / 2 - ((int) fig.getPoints().get(0).getY()),
                            (int) fig.getRadius() * 2, (int) fig.getRadius() * 2);

                }
                else {
                    for (int i = 0; i < fig.getPoints().size() - 1; i++) {
                        g.drawLine((int) fig.getPoints().get(i).getX() + getWidth() / 2,
                                getHeight() / 2 - ((int) fig.getPoints().get(i).getY()),
                                (int) fig.getPoints().get(i + 1).getX() + getWidth() / 2,
                                getHeight() / 2 - ((int) fig.getPoints().get(i + 1).getY()));
                    }
                    g.drawLine((int) fig.getPoints().get(fig.getPoints().size() - 1).getX() + getWidth() / 2,
                            getHeight() / 2 - ((int) fig.getPoints().get(fig.getPoints().size() - 1).getY()),
                            (int) fig.getPoints().get(0).getX() + getWidth() / 2,
                            getHeight() / 2 - ((int) fig.getPoints().get(0).getY()));
//                    for (int i = 0; i < fig.getPoints().size() - 1; i++) {
//                        g.drawLine((int) fig.getPoints().get(i).getX() * multiplierX + getWidth() / 2,
//                                getHeight() / 2 - ((int) fig.getPoints().get(i).getY() * multiplierY),
//                                (int) fig.getPoints().get(i + 1).getX() * multiplierX + getWidth() / 2,
//                                getHeight() / 2 - ((int) fig.getPoints().get(i + 1).getY() * multiplierY));
//                    }
//                    g.drawLine((int) fig.getPoints().get(fig.getPoints().size() - 1).getX() * multiplierX + getWidth() / 2,
//                            getHeight() / 2 - ((int) fig.getPoints().get(fig.getPoints().size() - 1).getY() * multiplierY),
//                            (int) fig.getPoints().get(0).getX() * multiplierX + getWidth() / 2,
//                            getHeight() / 2 - ((int) fig.getPoints().get(0).getY() * multiplierY));
                }
            }
        }

//                Point value1 = fig.getPoints().get(i);
//                if (fig.getPoints().size() == 2) {
//                    g.drawOval((int) fig.getPoints().get(0).getX()+getWidth/2, (int) fig.getPoints().get(0).getY()+getWidth/2,
//                            (int) (fig.getRadius() * 2), (int) (fig.getRadius() * 2));
//                } else {
//                    int temp = i + 1 < fig.getPoints().size() ? i + 1 : 0;
//                    Point value2 = fig.getPoints().get(temp);
//                    g.drawLine((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
//                }

    private void drawGrid(Graphics figurePane, int width, int height) {
        figurePane.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for (int x = width / 2; x < width; x += 20) {  // цикл от центра до правого края
            figurePane.drawLine(x, 0, x, height);    // вертикальная линия
        }
        for (int x = width / 2; x > 0; x -= 20) {  // цикл от центра до леваого края
            figurePane.drawLine(x, 0, x, height);   // вертикальная линия
        }
        for (int y = height / 2; y < height; y += 20) {  // цикл от центра до верхнего края
            figurePane.drawLine(0, y, width, y);    // горизонтальная линия
        }
        for (int y = height / 2; y > 0; y -= 20) {  // цикл от центра до леваого края
            figurePane.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics figurePane, int width, int height) {
        figurePane.setColor(Color.BLACK);
        figurePane.drawLine(width / 2, 0, width / 2, height);
        figurePane.drawLine(0, height / 2, width, height / 2);
    }

    public void repaintGraphics(ArrayList<Figure> figures) {
        this.figures = figures;
        this.revalidate();
        this.repaint();
    }
}
