package com.mycompany.bicyclemushroom;

import java.awt.*;
import javax.swing.*;

/**
 * Bicycle rental form: start time, end time, calculates total cost.
 * Pricing (per hour of rental):
 *   less than 5 hours  -> 1500 each
 *   5 to 20 hours      -> 1000 each
 *   21 hours or more   -> 500 each
 */
public class Bicyclerental extends JFrame {

    private JTextField txtstart;
    private JTextField txtend;
    private JTextField txtanswerbicycle;
    private JButton btncalculate;
    private JButton btncancel1;

    public Bicyclerental() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Bicycle rental");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("BICYCLERENTAL IDENTIFICATION", SwingConstants.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));

        txtstart = new JTextField(10);
        txtend = new JTextField(10);
        txtanswerbicycle = new JTextField(22);
        txtanswerbicycle.setEditable(false);
        btncalculate = new JButton("Calculate amount");
        btncancel1 = new JButton("Cancel");

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 10, 8, 10);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0; form.add(label("Start time:"), c);
        c.gridx = 1;              form.add(txtstart, c);
        c.gridx = 0; c.gridy = 1; form.add(label("Endtime:"), c);
        c.gridx = 1;              form.add(txtend, c);
        c.gridx = 0; c.gridy = 2; form.add(btncalculate, c);
        c.gridx = 1;              form.add(txtanswerbicycle, c);
        c.gridx = 0; c.gridy = 3; form.add(btncancel1, c);

        btncalculate.addActionListener(this::btncalculateActionPerformed);
        btncancel1.addActionListener(this::btncancel1ActionPerformed);

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private JLabel label(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        return l;
    }

    // Cancel: go back to the welcome form
    private void btncancel1ActionPerformed(java.awt.event.ActionEvent evt) {
        TRAVELAGENCY back = new TRAVELAGENCY();
        back.setVisible(true);
        this.dispose();
    }

    private void btncalculateActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int starttime = Integer.parseInt(txtstart.getText().trim());
            int endtime = Integer.parseInt(txtend.getText().trim());

            // Rules: start 0-23, end 1-24, start must be less than end
            if (starttime < 0 || starttime > 23 || endtime < 1 || endtime > 24
                    || starttime >= endtime) {
                txtanswerbicycle.setText("Invalid time.");
                return;
            }

            // Add up the rate of every hour rented (hour h means h:00 to h+1:00)
            int totalCost = 0;
            for (int hour = starttime; hour < endtime; hour++) {
                if (hour < 7 || hour >= 21) {
                    totalCost += 500;        // 0-7 and 21-24
                } else if (hour < 14 || hour >= 19) {
                    totalCost += 1000;       // 7-14 and 19-21
                } else {
                    totalCost += 1500;       // 14-19
                }
            }

            txtanswerbicycle.setText("Total cost: " + totalCost + " RWF");
        } catch (NumberFormatException ex) {
            txtanswerbicycle.setText("Please enter valid numbers for start and end time.");
        }
    }
}
