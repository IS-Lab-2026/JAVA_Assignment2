package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class Mushroom_object extends JFrame {

    private JRadioButton rbRingYes, rbRingNo;
    private JRadioButton rbGillsYes, rbGillsNo;
    private JRadioButton rbConvexYes, rbConvexNo;
    private JRadioButton rbForestYes, rbForestNo;
    private JTextField txtResult;

    public Mushroom_object() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Mushroom Identification System");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450, 340);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("MUSHROOM IDENTIFIER", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));

        JPanel grid = new JPanel(new GridLayout(5, 3, 10, 10));
        grid.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        grid.add(new JLabel("Does it have a ring?"));
        rbRingYes = new JRadioButton("Yes");
        rbRingNo = new JRadioButton("No");
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rbRingYes);
        bg1.add(rbRingNo);
        grid.add(rbRingYes);
        grid.add(rbRingNo);

        grid.add(new JLabel("Does it have gills?"));
        rbGillsYes = new JRadioButton("Yes");
        rbGillsNo = new JRadioButton("No");
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(rbGillsYes);
        bg2.add(rbGillsNo);
        grid.add(rbGillsYes);
        grid.add(rbGillsNo);

        grid.add(new JLabel("Does it have a convex cap?"));
        rbConvexYes = new JRadioButton("Yes");
        rbConvexNo = new JRadioButton("No");
        ButtonGroup bg3 = new ButtonGroup();
        bg3.add(rbConvexYes);
        bg3.add(rbConvexNo);
        grid.add(rbConvexYes);
        grid.add(rbConvexNo);

        grid.add(new JLabel("Does it grow in the forest?"));
        rbForestYes = new JRadioButton("Yes");
        rbForestNo = new JRadioButton("No");
        ButtonGroup bg4 = new ButtonGroup();
        bg4.add(rbForestYes);
        bg4.add(rbForestNo);
        grid.add(rbForestYes);
        grid.add(rbForestNo);

        grid.add(new JLabel("Identified Mushroom:"));
        txtResult = new JTextField();
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Segoe UI", Font.BOLD, 12));
        grid.add(txtResult);
        grid.add(new JLabel(""));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        JButton btnCancel = new JButton("Cancel");
        JButton btnIdentify = new JButton("Identify");
        btnIdentify.setFont(new Font("Segoe UI", Font.BOLD, 13));

        btnCancel.addActionListener(e -> {
            new Welcome_2().setVisible(true);
            this.dispose();
        });

        btnIdentify.addActionListener(e -> identifyMushroom());

        btnPanel.add(btnCancel);
        btnPanel.add(btnIdentify);

        add(title, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    private void identifyMushroom() {
        if ((!rbRingYes.isSelected() && !rbRingNo.isSelected()) ||
            (!rbGillsYes.isSelected() && !rbGillsNo.isSelected()) ||
            (!rbConvexYes.isSelected() && !rbConvexNo.isSelected()) ||
            (!rbForestYes.isSelected() && !rbForestNo.isSelected())) {
            JOptionPane.showMessageDialog(this, "Please answer all 4 questions first.", "Incomplete Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean ring = rbRingYes.isSelected();
        boolean gills = rbGillsYes.isSelected();
        boolean convex = rbConvexYes.isSelected();
        boolean forest = rbForestYes.isSelected();

        if (!gills && !ring && convex && forest) {
            txtResult.setText("Cepe de Bordeaux");
        } else if (gills && ring && convex && !forest) {
            txtResult.setText("Agaric jaunissant");
        } else if (gills && ring && convex && forest) {
            txtResult.setText("Amanite tue-mouche");
        } else if (gills && ring && !convex && !forest) {
            txtResult.setText("Coprin chevelu");
        } else if (gills && !ring && !convex && forest) {
            txtResult.setText("Girolle");
        } else if (gills && !ring && convex && forest) {
            txtResult.setText("Pied bleu");
        } else {
            txtResult.setText("Unknown combination");
        }
    }
}

