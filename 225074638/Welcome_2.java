package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class Welcome_2 extends JFrame {

    public Welcome_2() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Main Menu - Select Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(420, 260);
        setLayout(new BorderLayout(10, 10));

        JLabel header = new JLabel("Choose an Application", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 18));
        header.setBorder(BorderFactory.createEmptyBorder(25, 10, 10, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

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

        JButton btnBack = new JButton("<- Back");
        btnBack.addActionListener(e -> {
            new Welcome_1().setVisible(true);
            this.dispose();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnBack);

        add(header, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
