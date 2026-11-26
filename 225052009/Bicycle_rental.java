package com.mycompany.quitbuttonexample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Bicycle_rental extends JFrame {

    private JTextField startTimeField;
    private JTextField endTimeField;

    public Bicycle_rental() {
        setTitle("Bicycle Rental Calculations");
        setSize(550, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel startLabel = new JLabel("Enter starting time (0-23):");
        startTimeField = new JTextField();

        JLabel endLabel = new JLabel("Enter ending time (1-24):");
        endTimeField = new JTextField();

        inputPanel.add(startLabel);
        inputPanel.add(startTimeField);
        inputPanel.add(endLabel);
        inputPanel.add(endTimeField);

        JButton calculateButton = new JButton("Calculate");
        JButton mushroomButton = new JButton("Go to Mushroom");
        JButton quitButton = new JButton("Quit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(mushroomButton);
        buttonPanel.add(quitButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        calculateButton.addActionListener(e -> calculateCost());

        mushroomButton.addActionListener(e -> {
            dispose();
            new Mushroom().setVisible(true);
        });

        quitButton.addActionListener(e -> confirmQuit());
    }

    private void calculateCost() {
        try {
            int startTime = Integer.parseInt(startTimeField.getText().trim());
            int endTime = Integer.parseInt(endTimeField.getText().trim());

            if (startTime < 0 || startTime > 23
                    || endTime < 1 || endTime > 24
                    || startTime >= endTime) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid time! Enter a starting time from 0 to 23 "
                                + "and an ending time from 1 to 24. "
                                + "The ending time must be later than the starting time.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int total = 0;

            // Add the price for each rented hour.
            for (int hour = startTime; hour < endTime; hour++) {
                if (hour < 7) {
                    total += 500;
                } else if (hour < 14) {
                    total += 1000;
                } else if (hour < 19) {
                    total += 1500;
                } else if (hour < 21) {
                    total += 1000;
                } else {
                    total += 500;
                }
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Starting Time: " + startTime
                            + "\nEnding Time: " + endTime
                            + "\n\nTotal Rental Cost: " + total + " RWF",
                    "Calculation Result",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid whole numbers!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void confirmQuit() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to quit?",
                "Exit Application",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bicycle_rental().setVisible(true));
    }
}
