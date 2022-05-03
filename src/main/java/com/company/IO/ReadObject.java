package main.java.com.company.IO;

import main.java.com.company.Figures.Figure;

import java.io.*;
import java.util.ArrayList;

public class ReadObject {
    public static void main(String[] args){
        ArrayList<Figure> fig = new ArrayList<>();
        ArrayList<ArrayList<Figure>> figObject = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("TestFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Figure rectangle = (Figure) ois.readObject();
            Figure circle = (Figure) ois.readObject();
            Figure polygon = (Figure) ois.readObject();
            while (true) {
                fig = (ArrayList<Figure>) ois.readObject();
                figObject.add(fig);

            System.out.println(rectangle);
            System.out.println(circle);
            System.out.println(polygon);

                ois.close();
            }
        }catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (var figures: fig) {
            System.out.println(figures);
        }

    }

}
