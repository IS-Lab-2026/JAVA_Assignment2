
package com.mycompany.gui_assign;

import java.awt.*;
import javax.swing.*;

/** Bicycle rental fee calculator. */
public class BicycleRental extends JFrame {

    // Text fields
    private final JTextField Txtstart = new JTextField();
    private final JTextField TxtEnd = new JTextField();
    private final JTextField TxtTotal = new JTextField();

    // EDITABLE TEXT FIELD SIZE SETTINGS
    private int FIELD_WIDTH = 200;
    private int FIELD_HEIGHT = 35;

    public BicycleRental() {
        setTitle("Bicycle Rental");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 420);
        setMinimumSize(new Dimension(550, 380));
        setLocationRelativeTo(null);

        TxtTotal.setEditable(false);

        buildForm();
    }

    private void buildForm() {

        JPanel page = new JPanel(new BorderLayout(12, 18));
        page.setBorder(
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );
        page.setBackground(new Color(248, 250, 252));

        // TITLE
        JLabel title = new JLabel(
            "BICYCLE RENTAL",
            SwingConstants.CENTER
        );

        title.setFont(
            new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25)
        );

        title.setForeground(new Color(31, 41, 55));

        page.add(title, BorderLayout.NORTH);

        // FORM PANEL
        JPanel fields = new JPanel(new GridBagLayout());
        fields.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(12, 10, 12, 10);
        c.anchor = GridBagConstraints.WEST;

        // EDIT TEXT FIELD SIZES HERE
        Dimension fieldSize = new Dimension(
            FIELD_WIDTH,
            FIELD_HEIGHT
        );

        Txtstart.setPreferredSize(fieldSize);
        TxtEnd.setPreferredSize(fieldSize);
        TxtTotal.setPreferredSize(fieldSize);

        // START TIME
        c.gridx = 0;
        c.gridy = 0;
        fields.add(new JLabel("Start time (0-23):"), c);

        c.gridx = 1;
        fields.add(Txtstart, c);

        // END TIME
        c.gridx = 0;
        c.gridy = 1;
        fields.add(new JLabel("End time (1-24):"), c);

        c.gridx = 1;
        fields.add(TxtEnd, c);

        // TOTAL AMOUNT
        c.gridx = 0;
        c.gridy = 2;
        fields.add(new JLabel("Total amount to pay:"), c);

        c.gridx = 1;
        fields.add(TxtTotal, c);

        // RENTAL RATE
        JLabel rate = new JLabel(
            "Rental rate: 500 RWF per hour"
        );

        rate.setForeground(new Color(75, 85, 99));

        c.gridx = 1;
        c.gridy = 3;
        fields.add(rate, c);

        page.add(fields, BorderLayout.CENTER);

        // BUTTONS
        JButton calculate = new JButton("Calculate");
        calculate.setBackground(new Color(0, 160, 70));
        calculate.setForeground(Color.WHITE);

        JButton clear = new JButton("Clear");
        clear.setBackground(new Color(102, 0, 102));
        clear.setForeground(Color.WHITE);

        JButton back = new JButton("Back to Welcome");

        back.addActionListener(e -> {
            new Welcome().setVisible(true);
            dispose();
        });

        calculate.addActionListener(
            e -> btncalculateActionPerformed()
        );

        clear.addActionListener(
            e -> btnclearActionPerformed()
        );

        JPanel buttons = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 12, 0)
        );

        buttons.setOpaque(false);

        buttons.add(calculate);
        buttons.add(clear);
        buttons.add(back);

        page.add(buttons, BorderLayout.SOUTH);

        setContentPane(page);
    }

    // CALCULATE RENTAL FEE
    private void btncalculateActionPerformed() {

        if (Txtstart.getText().trim().isEmpty()
                || TxtEnd.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please fill both Starttime and Endtime!"
            );

            TxtTotal.setText("");
            return;
        }

        try {

            int start = Integer.parseInt(
                Txtstart.getText().trim()
            );

            int end = Integer.parseInt(
                TxtEnd.getText().trim()
            );

            if (start < 0 || start > 23) {

                JOptionPane.showMessageDialog(
                    this,
                    "Starttime must be between 0 and 23!"
                );

                TxtTotal.setText("");
                return;
            }

            if (end < 1 || end > 24) {

                JOptionPane.showMessageDialog(
                    this,
                    "Endtime must be between 1 and 24!"
                );

                TxtTotal.setText("");
                return;
            }

            if (end <= start) {

                JOptionPane.showMessageDialog(
                    this,
                    "Endtime must be bigger than Starttime!"
                );

                TxtTotal.setText("");
                return;
            }

            int hours = end - start;
            int total = hours * 500;

            TxtTotal.setText(
                total + " RWF (" + hours + " hours)"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter numbers only! No letters."
            );

            TxtTotal.setText("");
        }
    }

    // CLEAR FIELDS
    private void btnclearActionPerformed() {

        Txtstart.setText("");
        TxtEnd.setText("");
        TxtTotal.setText("");
    }
}
