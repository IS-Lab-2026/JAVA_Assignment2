package javaapplication1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Lab1_rental_bicycle_Swing extends JFrame {

    private JTextField startingTimeField;
    private JTextField endingTimeField;
    private JTextArea resultArea;

    public Lab1_rental_bicycle_Swing() {
        setTitle("Bicycle Rental Services");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(12, 12));
        mainPanel.setBorder(new EmptyBorder(20, 25, 20, 25));
        mainPanel.setBackground(new Color(245, 248, 250));

        // Heading
        JLabel heading = new JLabel("WELCOME TO OUR BICYCLE RENTAL SERVICES",
                SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 19));
        heading.setForeground(new Color(25, 75, 115));
        mainPanel.add(heading, BorderLayout.NORTH);

        // Center content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);

        JLabel priceHeading = new JLabel("TABLE SHOWING HOURS AND PRICES");
        priceHeading.setFont(new Font("Arial", Font.BOLD, 15));
        priceHeading.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] columns = {"Rental time", "Price per hour"};
        Object[][] prices = {
                {"00:00 - 07:00 and 21:00 - 24:00", "500 RWF"},
                {"07:00 - 14:00 and 19:00 - 21:00", "1,000 RWF"},
                {"14:00 - 19:00", "1,500 RWF"}
        };

        JTable priceTable = new JTable(prices, columns);
        priceTable.setEnabled(false);
        priceTable.setRowHeight(27);
        priceTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        priceTable.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane tableScroll = new JScrollPane(priceTable);
        tableScroll.setPreferredSize(new Dimension(490, 115));
        tableScroll.setMaximumSize(new Dimension(490, 115));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setOpaque(false);
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Rental Period"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Starting time (0-23):"), gbc);

        startingTimeField = new JTextField(12);
        gbc.gridx = 1;
        inputPanel.add(startingTimeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Ending time (1-24):"), gbc);

        endingTimeField = new JTextField(12);
        gbc.gridx = 1;
        inputPanel.add(endingTimeField, gbc);

        JButton calculateButton = new JButton("Calculate Rental Cost");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 13));
        calculateButton.setBackground(new Color(35, 125, 75));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.addActionListener(e -> calculateRentalCost());

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearFields());

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        resultArea = new JTextArea(5, 35);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultArea.setBackground(Color.WHITE);
        resultArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        resultArea.setText("Your rental calculation will appear here.");
        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setBorder(BorderFactory.createTitledBorder("Rental Summary"));

        centerPanel.add(priceHeading);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(tableScroll);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(inputPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(resultScroll);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private void calculateRentalCost() {
        int time1;
        int time2;

        // Convert the input values into integers.
        try {
            time1 = Integer.parseInt(startingTimeField.getText().trim());
            time2 = Integer.parseInt(endingTimeField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid whole numbers for both times.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate starting time.
        if (time1 < 0 || time1 > 23) {
            JOptionPane.showMessageDialog(this,
                    "Invalid starting time. It must be between 0 and 23.",
                    "Invalid Starting Time", JOptionPane.ERROR_MESSAGE);
            startingTimeField.requestFocus();
            return;
        }

        // Validate ending time.
        if (time2 < 1 || time2 > 24) {
            JOptionPane.showMessageDialog(this,
                    "Invalid ending time. It must be between 1 and 24.",
                    "Invalid Ending Time", JOptionPane.ERROR_MESSAGE);
            endingTimeField.requestFocus();
            return;
        }

        // Starting time must be less than ending time.
        if (time1 >= time2) {
            JOptionPane.showMessageDialog(this,
                    "Invalid rental period. Starting time must be less than ending time.",
                    "Invalid Rental Period", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int hours = time2 - time1;
        int total = 0;

        // Calculate the rental cost using the original hourly pricing rules.
        for (int hour = time1; hour < time2; hour++) {
            if (hour < 7) {
                total = total + 500;
            } else if (hour < 14) {
                total = total + 1000;
            } else if (hour < 19) {
                total = total + 1500;
            } else if (hour < 21) {
                total = total + 1000;
            } else {
                total = total + 500;
            }
        }

        // Display the rental summary.
        resultArea.setText(
                "RENTAL SUMMARY\n"
                + "------------------------------\n"
                + "Starting time : " + String.format("%02d:00", time1) + "\n"
                + "Ending time   : " + String.format("%02d:00", time2) + "\n"
                + "Total hours   : " + hours + "\n"
                + "Total cost    : " + String.format("%,d", total) + " RWF\n"
                + "------------------------------\n"
                + "Thank you for using our service!"
        );
    }

    private void clearFields() {
        startingTimeField.setText("");
        endingTimeField.setText("");
        resultArea.setText("Your rental calculation will appear here.");
        startingTimeField.requestFocus();
    }

    public static void main(String[] args) {
        // Start the Swing GUI on the Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> {
            Lab1_rental_bicycle_Swing application = new Lab1_rental_bicycle_Swing();
            application.setVisible(true);
        });
    }
}
