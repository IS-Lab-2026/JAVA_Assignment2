package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class Welcome_1 extends JFrame {

    public Welcome_1() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Java GUI Lab 2 - Welcome");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(420, 260);
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Welcome to Java GUI Lab 2", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));

        JLabel subLabel = new JLabel("Interactive Object Calculators & Classifiers", SwingConstants.CENTER);
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnContinue = new JButton("Continue to Applications ->");
        btnContinue.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnContinue.addActionListener(e -> {
            new Welcome_2().setVisible(true);
            this.dispose();
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        btnPanel.add(btnContinue);

        add(titleLabel, BorderLayout.NORTH);
        add(subLabel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
