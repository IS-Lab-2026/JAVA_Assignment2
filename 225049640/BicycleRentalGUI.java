import javax.swing.*;
import java.awt.*;

/**
 * Bicycle rental screen. Same validation and hourly rates as the console
 * BicycleRental program.
 */
public class BicycleRentalGUI extends JFrame {

    private final JTextField startField;
    private final JTextField endField;
    private final JLabel resultLabel;

    public BicycleRentalGUI() {
        setTitle("Bicycle Rental");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(248, 250, 252));

        Font topBtnFont = new Font("SansSerif", Font.BOLD, 16);
        Font headerFont = new Font("SansSerif", Font.BOLD, 30);
        Font subtitleFont = new Font("SansSerif", Font.PLAIN, 18);
        Font labelFont = new Font("SansSerif", Font.BOLD, 22);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 22);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);
        Font resultFont = new Font("SansSerif", Font.BOLD, 28);

        // Cancel goes back to the home page
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(topBtnFont);
        cancelButton.setBackground(new Color(226, 232, 240));
        cancelButton.setForeground(new Color(30, 41, 59));
        cancelButton.setOpaque(true);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(40, 24, 120, 42);
        cancelButton.addActionListener(e -> {
            new HomeGUI().setVisible(true);
            dispose();
        });
        add(cancelButton);

        JLabel headerLabel = new JLabel("Bicycle Rental", SwingConstants.CENTER);
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(new Color(24, 32, 42));
        headerLabel.setBounds(170, 24, 860, 42);
        add(headerLabel);

        JLabel subtitleLabel = new JLabel("Enter the start and end hour (24-hour format). The cost is in RWF.",
                SwingConstants.CENTER);
        subtitleLabel.setFont(subtitleFont);
        subtitleLabel.setForeground(new Color(95, 108, 123));
        subtitleLabel.setBounds(50, 74, 1100, 30);
        add(subtitleLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(90, 122, 1020, 2);
        add(separator);

        JLabel startLabel = new JLabel("Start hour (0 - 23):", SwingConstants.RIGHT);
        startLabel.setFont(labelFont);
        startLabel.setForeground(new Color(35, 45, 58));
        startLabel.setBounds(330, 160, 310, 46);
        add(startLabel);

        startField = new JTextField();
        startField.setFont(inputFont);
        startField.setHorizontalAlignment(SwingConstants.CENTER);
        startField.setBounds(660, 160, 210, 46);
        add(startField);

        JLabel endLabel = new JLabel("End hour (1 - 24):", SwingConstants.RIGHT);
        endLabel.setFont(labelFont);
        endLabel.setForeground(new Color(35, 45, 58));
        endLabel.setBounds(330, 232, 310, 46);
        add(endLabel);

        endField = new JTextField();
        endField.setFont(inputFont);
        endField.setHorizontalAlignment(SwingConstants.CENTER);
        endField.setBounds(660, 232, 210, 46);
        add(endField);

        JButton calculateButton = new JButton("Calculate Cost");
        calculateButton.setFont(buttonFont);
        calculateButton.setBackground(new Color(25, 118, 210));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setOpaque(true);
        calculateButton.setBorderPainted(false);
        calculateButton.setFocusPainted(false);
        calculateButton.setBounds(375, 325, 240, 62);
        add(calculateButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(buttonFont);
        clearButton.setBackground(new Color(226, 232, 240));
        clearButton.setForeground(new Color(30, 41, 59));
        clearButton.setOpaque(true);
        clearButton.setBorderPainted(false);
        clearButton.setFocusPainted(false);
        clearButton.setBounds(645, 325, 180, 62);
        add(clearButton);

        resultLabel = new JLabel("Total: 0 RWF", SwingConstants.CENTER);
        resultLabel.setFont(resultFont);
        resultLabel.setForeground(new Color(13, 71, 161));
        resultLabel.setBounds(50, 430, 1100, 50);
        add(resultLabel);

        calculateButton.addActionListener(e -> calculateRental());
        endField.addActionListener(e -> calculateRental()); // Enter key works too
        clearButton.addActionListener(e -> {
            startField.setText("");
            endField.setText("");
            resultLabel.setText("Total: 0 RWF");
            startField.requestFocus();
        });
    }

    /** Reads the two hours, validates them, and shows the total rent. */
    private void calculateRental() {
        int startHour;
        int endHour;
        try {
            startHour = Integer.parseInt(startField.getText().trim());
            endHour = Integer.parseInt(endField.getText().trim());
        } catch (NumberFormatException ex) {
            showError("Format Error", "Please enter valid whole numbers.");
            return;
        }

        // Input validation (same rules and messages as the console program)
        if (startHour < 0 || startHour > 23) {
            showError("Input Error", "Start hour must be between 0 and 23.");
            return;
        }
        if (endHour < 1 || endHour > 24) {
            showError("Input Error", "End hour must be between 1 and 24.");
            return;
        }
        if (startHour >= endHour) {
            showError("Input Error", "Starting time must be less than ending time.");
            return;
        }

        resultLabel.setText("Total: " + calculateCost(startHour, endHour) + " RWF");
    }

    /**
     * Adds up the rate of every rented hour (same rates as the console program).
     */
    private int calculateCost(int startHour, int endHour) {
        int totalCost = 0;

        for (int hour = startHour; hour < endHour; hour++) {
            // 500 RWF for hours 0-7 and 21-24
            if ((hour >= 0 && hour < 7) || (hour >= 21 && hour < 24)) {
                totalCost += 500;
            }
            // 1000 RWF for hours 7-14 and 19-21
            else if ((hour >= 7 && hour < 14) || (hour >= 19 && hour < 21)) {
                totalCost += 1000;
            }
            // 1500 RWF for hours 14-19
            else if (hour >= 14 && hour < 19) {
                totalCost += 1500;
            }
        }
        return totalCost;
    }

    private void showError(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BicycleRentalGUI().setVisible(true));
    }
}
