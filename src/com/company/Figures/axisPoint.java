package com.company.Figures;

public class axisPoint extends Point {
    private String axis;
    public axisPoint(double x, double y){
        super(x, y);
        if (x==0 && y==0){
            this.axis="I'm a center";
        }
        else if (x==0){
            this.axis="I'm a y point";
        }
        else if (y==0){
            this.axis="I'm a x point";
        }
        else {
            this.axis = "????";
        }

    }
    public String toString(){
        return "I'm a axisPoint! Not a simple point, not like you. I'm axis lol";
    }

}
