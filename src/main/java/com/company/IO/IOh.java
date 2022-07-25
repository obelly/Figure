package com.company.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class IOh{
        public static void main(String[] args) throws FileNotFoundException {
    File file = new File("TestFile");

    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    String[] numbersString = line.split(" ");
    int [] numbers = new int[3];
    int counter = 0;

        for (String number : numbersString){
        numbers[counter++] = Integer.parseInt(number);
    }
       System.out.println(Arrays.toString(numbers));
        while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
    }
        scanner.close();
    PrintWriter pw = new PrintWriter(file);

       pw.println("Test 1");
       pw.println("Test 2");

       pw.close();
}
}
