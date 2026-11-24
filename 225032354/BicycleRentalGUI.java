import javax.swing.*;
import java.awt.*;

public class BicycleRentalGUI extends JFrame {

    private final JTextField startField;
    private final JTextField endField;
    private final JLabel resultLabel;

    public BicycleRentalGUI() {
        setTitle("Bicycle Rental Calculator");
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

        JButton homeButton = new JButton("Home");
        homeButton.setFont(topBtnFont);
        homeButton.setBackground(new Color(226, 232, 240));
        homeButton.setForeground(new Color(30, 41, 59));
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setBounds(40, 24, 120, 42);
        homeButton.addActionListener(e -> {
            new HomeGUI().setVisible(true);
            dispose();
        });
        add(homeButton);

        JLabel headerLabel = new JLabel("Bicycle Rental Cost Calculator", SwingConstants.CENTER);
        headerLabel.setFont(headerFont);
        headerLabel.setForeground(new Color(24, 32, 42));
        headerLabel.setBounds(170, 24, 860, 42);
        add(headerLabel);

        JLabel subtitleLabel = new JLabel("Enter your rental window in 24-hour format (RWF)", SwingConstants.CENTER);
        subtitleLabel.setFont(subtitleFont);
        subtitleLabel.setForeground(new Color(95, 108, 123));
        subtitleLabel.setBounds(50, 74, 1100, 30);
        add(subtitleLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(212, 220, 228));
        separator.setBounds(90, 122, 1020, 2);
        add(separator);

        JLabel startLabel = new JLabel("Starting Time (0 - 23):", SwingConstants.RIGHT);
        startLabel.setFont(labelFont);
        startLabel.setForeground(new Color(35, 45, 58));
        startLabel.setBounds(330, 160, 310, 46);
        add(startLabel);

        startField = new JTextField();
        startField.setFont(inputFont);
        startField.setHorizontalAlignment(SwingConstants.CENTER);
        startField.setBounds(660, 160, 210, 46);
        add(startField);

        JLabel endLabel = new JLabel("Ending Time (1 - 24):", SwingConstants.RIGHT);
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
        clearButton.addActionListener(e -> {
            startField.setText("");
            endField.setText("");
            resultLabel.setText("Total: 0 RWF");
            startField.requestFocus();
        });
    }

    private void calculateRental() {
        try {
            int start = Integer.parseInt(startField.getText().trim());
            int end = Integer.parseInt(endField.getText().trim());

            if (start < 0 || start > 23 || end < 1 || end > 24 || end <= start) {
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid hours! Ensure Start is 0-23, End is 1-24, and End > Start.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int total = BicycleRental.culculateCost(start, end);
            resultLabel.setText("Total: " + total + " RWF");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid integer numbers.",
                "Format Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BicycleRentalGUI().setVisible(true));
    }
}