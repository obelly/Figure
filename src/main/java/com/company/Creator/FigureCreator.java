package main.java.com.company.Creator;

import main.java.com.company.Figures.Figure;
import main.java.com.company.Figures.Point;
import java.util.ArrayList;

public class FigureCreator implements IFigureCreator {
    @Override
    public Figure create (ArrayList<Point>points){
        int nPoints = points.size();
        IFigureCreator creator;// создатель
        if (nPoints == 2){
            creator = new CreatorCircle();
        }
        else if (nPoints == 3){
            creator = new CreatorTriangle();
        }
        else if (nPoints == 4){
            creator = new CreatorRentangle();
        }
        else if (nPoints > 4){
            creator = new CreatorPolygon();
        }
        else {
            return null;
        }
        return creator.create(points);

    }
}
