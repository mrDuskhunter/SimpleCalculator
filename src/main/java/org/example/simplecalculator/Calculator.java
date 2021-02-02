package org.example.simplecalculator;

import javax.swing.*;

public class Calculator extends JFrame {
    JFrame frame;
    CalcPanel calcPanel;

    public Calculator() {
        frame = new JFrame();
        setBounds(400,300,400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcPanel = new CalcPanel();
        add(calcPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
