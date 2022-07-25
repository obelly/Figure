package com.company.Figures;

import java.util.ArrayList;


public class Polygon extends Figure{
    public Polygon (ArrayList<Point>points) {
        super(points);}

//    @Override
//    public boolean containPoint(int x, int y, int multiplierX, int multiplierY) {
//        boolean flag = false;
//        for (int i = 0; i< this.getPoints().size(); i++){
//            int j = i ==this.getPoints().size() - 1 ? 0: i+1;
//            double x1 = this.getPoints().get(i).getX()*multiplierX;
//            double x2 = this.getPoints().get(j).getX()*multiplierX;
//            double y1 = this.getPoints().get(i).getY()*multiplierY;
//            double y2 = this.getPoints().get(j).getY()*multiplierY;
//
//            if (x2-x1 != 0){
//                double a = (y2-y1) / (x2-x1);
//                double b = y1 - a * x1;
//                if ((Math.abs(y - (int) (a * x + b)) <= 2)) {
//                    flag = true;}
//                else {
//                    if ((Math.abs(x-x1) <= 2) && (y >= Math.min(y1, y2) && y<Math.max(y1,y2))){
//                        flag = true;
//                    }
//                }
//            }
//        }
//        return flag;
//    }


}
