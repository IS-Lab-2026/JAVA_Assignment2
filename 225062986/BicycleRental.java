

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BicycleRental extends JFrame {

    JTextField startField;
    JTextField endField;
    JLabel resultLabel;

    public BicycleRental() {
        setTitle("CampusDesk - Bicycle Rental");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(243, 246, 250));

        JLabel title = new JLabel("Bicycle Rental");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(20, 40, 62));
        title.setBounds(110, 25, 250, 35);
        add(title);

        JLabel info = new JLabel("Enter your rental hours");
        info.setBounds(125, 70, 230, 25);
        add(info);

        JLabel startLabel = new JLabel("Starting hour (0 - 23):");
        startLabel.setBounds(50, 115, 170, 25);
        add(startLabel);

        startField = new JTextField();
        startField.setBounds(230, 115, 150, 30);
        add(startField);

        JLabel endLabel = new JLabel("Ending hour (1 - 24):");
        endLabel.setBounds(50, 165, 170, 25);
        add(endLabel);

        endField = new JTextField();
        endField.setBounds(230, 165, 150, 30);
        add(endField);

        JButton calculateBtn = new JButton("Calculate Fee");
        calculateBtn.setBounds(50, 220, 160, 40);
        calculateBtn.setBackground(new Color(27, 153, 139));
        calculateBtn.setForeground(Color.WHITE);
        add(calculateBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(220, 220, 160, 40);
        add(cancelBtn);

        resultLabel = new JLabel("Total will appear here.");
        resultLabel.setBounds(50, 280, 340, 45);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(new Color(20, 40, 62));
        add(resultLabel);

        calculateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void calculate() {
        String startText = startField.getText();
        String endText = endField.getText();

        if (startText.equals("") || endText.equals("")) {
            resultLabel.setText("Please fill in both hours.");
            return;
        }

        if (!isWholeNumber(startText) || !isWholeNumber(endText)) {
            resultLabel.setText("Use whole numbers only, without spaces.");
            return;
        }

        int start;
        int end;

        try {
            start = Integer.parseInt(startText);
            end = Integer.parseInt(endText);
        } catch (NumberFormatException ex) {
            resultLabel.setText("The number is too large.");
            return;
        }

        if (start < 0 || start > 23) {
            resultLabel.setText("Starting hour must be 0 to 23.");
            return;
        }

        if (end < 1 || end > 24) {
            resultLabel.setText("Ending hour must be 1 to 24.");
            return;
        }

        if (start >= end) {
            resultLabel.setText("Start must be less than end.");
            return;
        }

        int total = 0;

        for (int hour = start; hour < end; hour++) {
            int rate;

            if (hour < 7 || hour >= 21) {
                rate = 500;
            } else if (hour < 14 || hour >= 19) {
                rate = 1000;
            } else {
                rate = 1500;
            }

            total = total + rate;
        }

        resultLabel.setText("Total to pay: " + total + " RWF");
    }

    public boolean isWholeNumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
    }
}
