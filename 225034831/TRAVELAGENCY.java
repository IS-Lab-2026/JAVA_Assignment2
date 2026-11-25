package com.mycompany.bicyclemushroom;

import java.awt.*;
import javax.swing.*;

/**
 * Landing / welcome form with three buttons:
 * Bicycle rental, Mushroom and EXIT.
 */
public class TRAVELAGENCY extends JFrame {

    private JButton btnbicycle;
    private JButton btnmushroom;
    private JButton btnexit;

    public TRAVELAGENCY() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Welcome");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("WELCOME TO MY PROJECT", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));

        btnbicycle = new JButton("Bicycle rental");
        btnmushroom = new JButton("Mushroom");
        btnexit = new JButton("EXIT");
        for (JButton b : new JButton[]{btnbicycle, btnmushroom, btnexit}) {
            b.setFont(new Font("Tahoma", Font.BOLD, 14));
            b.setPreferredSize(new Dimension(160, 40));
        }

        btnbicycle.addActionListener(this::btnbicycleActionPerformed);
        btnmushroom.addActionListener(this::btnmushroomActionPerformed);
        btnexit.addActionListener(this::btnexitActionPerformed);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttons.add(btnbicycle);
        buttons.add(btnmushroom);
        buttons.add(btnexit);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(buttons, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    // Open the bicycle rental form and hide this one
    private void btnbicycleActionPerformed(java.awt.event.ActionEvent evt) {
        Bicyclerental bike = new Bicyclerental();
        bike.setVisible(true);
        this.dispose();
    }

    // Open the mushroom form and hide this one
    private void btnmushroomActionPerformed(java.awt.event.ActionEvent evt) {
        mushroom m = new mushroom();
        m.setVisible(true);
        this.dispose();
    }

    // Close the application
    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
}
