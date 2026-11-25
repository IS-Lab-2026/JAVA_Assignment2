package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class Bicycle_object extends JFrame {

    private JTextField txtStart, txtEnd, txtCost;

    public Bicycle_object() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Bicycle Rental Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("BICYCLE RENTAL", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        formPanel.add(new JLabel("Start Time (0-23):"));
        txtStart = new JTextField();
        formPanel.add(txtStart);

        formPanel.add(new JLabel("End Time (1-24):"));
        txtEnd = new JTextField();
        formPanel.add(txtEnd);

        formPanel.add(new JLabel("Total Cost:"));
        txtCost = new JTextField();
        txtCost.setEditable(false);
        txtCost.setFont(new Font("Segoe UI", Font.BOLD, 13));
        formPanel.add(txtCost);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        JButton btnCancel = new JButton("Cancel");
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setFont(new Font("Segoe UI", Font.BOLD, 13));

        btnCancel.addActionListener(e -> {
            new Welcome_2().setVisible(true);
            this.dispose();
        });

        btnCalculate.addActionListener(e -> calculateCost());

        btnPanel.add(btnCancel);
        btnPanel.add(btnCalculate);

        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    private void calculateCost() {
        try {
            int start = Integer.parseInt(txtStart.getText().trim());
            int end = Integer.parseInt(txtEnd.getText().trim());
            int hour;
            int rate;
            int total = 0;

            if (start < 0 || start > 23 || end < 1 || end > 24 || start >= end) {
                txtCost.setText("Invalid time.");
            } else {
                hour = start;

                while (hour < end) {
                    if (hour < 7 || hour >= 21) {
                        rate = 500;
                    } else if (hour < 14 || hour >= 19) {
                        rate = 1000;
                    } else {
                        rate = 1500;
                    }

                    total = total + rate;
                    hour++;
                }

                txtCost.setText(total + " RWF");
            }
        } catch (NumberFormatException ex) {
            txtCost.setText("Invalid input.");
        }
    }
}
