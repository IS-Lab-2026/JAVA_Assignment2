package com.mycompany.bicyclemushroom;

import java.awt.*;
import javax.swing.*;

/**
 * Mushroom identifier form: four Yes/No questions, "Action" shows the result.
 */
public class mushroom extends JFrame {

    private JRadioButton radiogillsyes, radiogillsno;
    private JRadioButton radioforestyes, radioforestno;
    private JRadioButton radioringyes, radioringno;
    private JRadioButton radioconvexyes, radioconvexno;
    private JTextField txtanswermushroom;
    private JButton btnaction;
    private JButton btncancel2;

    public mushroom() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Mushroom identifier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("MUSHROOM IDENTIFIER", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));

        radiogillsyes = new JRadioButton("Yes");
        radiogillsno = new JRadioButton("No");
        radioforestyes = new JRadioButton("Yes");
        radioforestno = new JRadioButton("No");
        radioringyes = new JRadioButton("Yes");
        radioringno = new JRadioButton("No");
        radioconvexyes = new JRadioButton("Yes");
        radioconvexno = new JRadioButton("No");

        group(radiogillsyes, radiogillsno);
        group(radioforestyes, radioforestno);
        group(radioringyes, radioringno);
        group(radioconvexyes, radioconvexno);

        txtanswermushroom = new JTextField(30);
        txtanswermushroom.setEditable(false);
        btnaction = new JButton("Action");
        btncancel2 = new JButton("Cancel");

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 10, 8, 10);
        c.anchor = GridBagConstraints.WEST;

        addQuestion(form, c, 0, "Does it have gills?", radiogillsyes, radiogillsno);
        addQuestion(form, c, 1, "Does it grow in a forest?", radioforestyes, radioforestno);
        addQuestion(form, c, 2, "Does it have a ring?", radioringyes, radioringno);
        addQuestion(form, c, 3, "Does it have a convex cup?", radioconvexyes, radioconvexno);

        c.gridx = 0; c.gridy = 4; form.add(btnaction, c);
        c.gridx = 1; c.gridwidth = 2; form.add(txtanswermushroom, c);
        c.gridx = 0; c.gridy = 5; c.gridwidth = 1; form.add(btncancel2, c);

        btnaction.addActionListener(this::btnactionActionPerformed);
        btncancel2.addActionListener(this::btncancel2ActionPerformed);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void group(JRadioButton a, JRadioButton b) {
        ButtonGroup g = new ButtonGroup();
        g.add(a);
        g.add(b);
    }

    private void addQuestion(JPanel p, GridBagConstraints c, int row, String q,
                             JRadioButton yes, JRadioButton no) {
        JLabel l = new JLabel(q);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        c.gridwidth = 1;
        c.gridy = row;
        c.gridx = 0; p.add(l, c);
        c.gridx = 1; p.add(yes, c);
        c.gridx = 2; p.add(no, c);
    }

    // Cancel: go back to the welcome form
    private void btncancel2ActionPerformed(java.awt.event.ActionEvent evt) {
        TRAVELAGENCY back = new TRAVELAGENCY();
        back.setVisible(true);
        this.dispose();
    }

    private void btnactionActionPerformed(java.awt.event.ActionEvent evt) {
        String gills = radiogillsyes.isSelected() ? "yes" : (radiogillsno.isSelected() ? "no" : "");
        String forest = radioforestyes.isSelected() ? "yes" : (radioforestno.isSelected() ? "no" : "");
        String convexCup = radioconvexyes.isSelected() ? "yes" : (radioconvexno.isSelected() ? "no" : "");
        String ring = radioringyes.isSelected() ? "yes" : (radioringno.isSelected() ? "no" : "");

        String mushroom;

        if (gills.equals("no")) {
            mushroom = "Cepe de Bordeaux";
        } else if (gills.equals("yes")) {
            if (forest.equals("no")) {
                if (convexCup.equals("yes")) {
                    mushroom = "Agaric Jaunissant";
                } else if (convexCup.equals("no")) {
                    mushroom = "Coprin chevelu";
                } else {
                    txtanswermushroom.setText("Please select Yes or No for convex cup.");
                    return;
                }
            } else if (forest.equals("yes")) {
                if (ring.equals("yes")) {
                    mushroom = "Amanite tue-mouche";
                } else if (ring.equals("no")) {
                    if (convexCup.equals("yes")) {
                        mushroom = "Pied bleu";
                    } else if (convexCup.equals("no")) {
                        mushroom = "Girolle";
                    } else {
                        txtanswermushroom.setText("Please select Yes or No for convex cup.");
                        return;
                    }
                } else {
                    txtanswermushroom.setText("Please select Yes or No for ring.");
                    return;
                }
            } else {
                txtanswermushroom.setText("Please select Yes or No for forest.");
                return;
            }
        } else {
            txtanswermushroom.setText("Please select Yes or No for gills.");
            return;
        }

        txtanswermushroom.setText("Mushroom: " + mushroom);
    }
}
