
package com.mycompany.gui;

import javax.swing.*;
import java.awt.*;

public class Mushroom extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(Mushroom.class.getName());

    private JLabel lblTitle;
    private JLabel lblGills;
    private JLabel lblForest;
    private JLabel lblRing;
    private JLabel lblResult;

    private JComboBox<String> cmbGills;
    private JComboBox<String> cmbForest;
    private JComboBox<String> cmbRing;

    private JButton btnIdentify;

    public Mushroom() {
        initComponents();
    }

    private void initComponents() {

        lblTitle = new JLabel();
        lblGills = new JLabel();
        lblForest = new JLabel();
        lblRing = new JLabel();
        lblResult = new JLabel();

        cmbGills = new JComboBox<>();
        cmbForest = new JComboBox<>();
        cmbRing = new JComboBox<>();

        btnIdentify = new JButton();

        setDefaultCloseOperation(
                javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Mushroom Identification");

        lblTitle.setFont(
                new java.awt.Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setText("Mushroom Identification");

        lblGills.setText("Does your mushroom have gills?");

        cmbGills.setModel(new DefaultComboBoxModel<>(
                new String[]{"Yes", "No"}));

        lblForest.setText(
                "Does your mushroom grow in a forest?");

        cmbForest.setModel(new DefaultComboBoxModel<>(
                new String[]{"Yes", "No"}));

        lblRing.setText(
                "Does your mushroom have a ring?");

        cmbRing.setModel(new DefaultComboBoxModel<>(
                new String[]{"Yes", "No"}));

        btnIdentify.setText("Identify Mushroom");

        btnIdentify.addActionListener(evt ->
                btnIdentifyActionPerformed(evt));

        lblResult.setText("Your mushroom is:");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 15));

        panel.add(lblTitle);
        panel.add(new JLabel());

        panel.add(lblGills);
        panel.add(cmbGills);

        panel.add(lblForest);
        panel.add(cmbForest);

        panel.add(lblRing);
        panel.add(cmbRing);

        panel.add(btnIdentify);
        panel.add(lblResult);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    private void btnIdentifyActionPerformed(
            java.awt.event.ActionEvent evt) {

        String gills = cmbGills.getSelectedItem().toString();
        String forest = cmbForest.getSelectedItem().toString();
        String ring = cmbRing.getSelectedItem().toString();

        String mushroom;

        if (gills.equalsIgnoreCase("No")) {
            mushroom = "Cepe de bordeau";
        }
        else if (forest.equalsIgnoreCase("No")) {

            if (ring.equalsIgnoreCase("Yes")) {
                mushroom = "Coprin chevelu";
            }
            else {
                mushroom = "Agaric jaunissant";
            }
        }
        else {

            if (ring.equalsIgnoreCase("Yes")) {
                mushroom = "Amanite tue-mouche";
            }
            else {
                mushroom = "Girolle or Pied bleu";
            }
        }

        lblResult.setText("Your mushroom is: " + mushroom);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Mushroom().setVisible(true);
        });
    }
}
