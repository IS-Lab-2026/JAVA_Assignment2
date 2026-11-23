package com.mycompany.bicyclerentals;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RentalGUI extends JFrame {

    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField resultField;
    private JButton calculateButton;
    private JButton exitButton;

    public RentalGUI() {
        setTitle("Bicycle Rental Calculator");
        setSize(350, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel startLabel = new JLabel("Start Time (0-23):");
        startLabel.setBounds(30, 30, 120, 25);
        add(startLabel);

        startTimeField = new JTextField();
        startTimeField.setBounds(150, 30, 150, 25);
        add(startTimeField);

        JLabel endLabel = new JLabel("End Time (1-24):");
        endLabel.setBounds(30, 70, 120, 25);
        add(endLabel);

        endTimeField = new JTextField();
        endTimeField.setBounds(150, 70, 150, 25);
        add(endTimeField);

        JLabel resultLabel = new JLabel("Result (RWF):");
        resultLabel.setBounds(30, 130, 120, 25);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(150, 130, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 190, 120, 30);
        add(calculateButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(100, 230, 120, 30);
        add(exitButton);

        // When this window closes (Exit button or X), go back to the Main page
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                new MainGUI().setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int start = Integer.parseInt(startTimeField.getText().trim());
                    int end = Integer.parseInt(endTimeField.getText().trim());

                    if (start < 0 || start >= 23 || end < 1 || end > 24 || start >= end) {
                        JOptionPane.showMessageDialog(RentalGUI.this, "Invalid Time Range!");
                        return;
                    }

                    // Create an object of the logic class and call its method
                    RentalCalculator calc = new RentalCalculator();
                    int total = calc.calculateTotal(start, end);

                    resultField.setText(String.valueOf(total));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RentalGUI.this, "Please enter valid numbers!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RentalGUI().setVisible(true);
            }
        });
    }
}
