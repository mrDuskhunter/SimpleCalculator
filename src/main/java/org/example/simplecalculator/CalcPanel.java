package org.example.simplecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JPanel {
    JButton display;
    private boolean start;
    private String lastCommand;
    private double result;
    JPanel panel;

    public CalcPanel() {
        super();
        start = true;
        lastCommand = "=";
        setLayout(new BorderLayout());
        display = new JButton("0");
        display.setFont(new Font("Arial",Font.BOLD,22));
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        initButtonPanel();
    }

    public void initButtonPanel() {
        InsertAction insertAction = new InsertAction();
        CommandAction commandAction = new CommandAction();

        addButton("7", insertAction);
        addButton("8", insertAction);
        addButton("9", insertAction);
        addButton("/", commandAction);

        addButton("4", insertAction);
        addButton("5", insertAction);
        addButton("6", insertAction);
        addButton("*", commandAction);

        addButton("1", insertAction);
        addButton("2", insertAction);
        addButton("3", insertAction);
        addButton("-", commandAction);

        addButton("0", insertAction);
        addButton(".", insertAction);
        addButton("=", commandAction);
        addButton("+", commandAction);

        add(panel);
    }

    public void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();

            if (start) {
                display.setText("");
                start = false;
            }
            if (!input.equals(".") || !display.getText().contains("."))
                display.setText(display.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (start) {
                lastCommand = command;
            } else {
                calc(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
        public void calc(double x) {
            switch (lastCommand) {
                case "+" -> result += x;
                case "-" -> result -= x;
                case "*" -> result *= x;
                case "/" -> result /= x;
                case "=" -> result = x;
            }
            display.setText("" + result);
        }
    }
}



