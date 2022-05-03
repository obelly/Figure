package main.java.com.company.IO;

import java.io.*;

public class ReadToFile {
    public static void main(String[] args) throws IOException {
        File file = new File("Figure.bin");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);//только здесь есть построчный вывод
        String str;
        while ((str = br.readLine()) != null){
            String name = str.substring(0,str.indexOf(":"));
            String point = str.substring(str.indexOf("Point"), str.indexOf(","));
            String pointStr = point.trim();

        }
    }
}
