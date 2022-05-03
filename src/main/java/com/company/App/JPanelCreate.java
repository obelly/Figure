package main.java.com.company.App;

import javax.swing.*;

public class JPanelCreate extends JPanel{
    JTextField InputX, InputY;
    JLabel TextX,TextY;

    public JPanelCreate() {

        TextX = new JLabel("Значение x: ");
        InputX = new JTextField();
        TextY = new JLabel("Значение y: ");
        InputY = new JTextField();

    }
}
