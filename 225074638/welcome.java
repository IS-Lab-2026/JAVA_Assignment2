package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {

    public Welcome() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Java GUI Lab 2 - Welcome");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(420, 260);
        setLayout(new BorderLayout(10, 10));

        JLabel header = new JLabel("Welcome - Choose an Application", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.setBorder(BorderFactory.createEmptyBorder(25, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 35, 30));

        JButton btnBicycle = new JButton("Bicycle Rental");
        btnBicycle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnBicycle.addActionListener(e -> {
            new Bicycle_object().setVisible(true);
            this.dispose();
        });

        JButton btnMushroom = new JButton("Mushroom Finder");
        btnMushroom.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnMushroom.addActionListener(e -> {
            new Mushroom_object().setVisible(true);
            this.dispose();
        });

        buttonPanel.add(btnBicycle);
        buttonPanel.add(btnMushroom);

        add(header, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
