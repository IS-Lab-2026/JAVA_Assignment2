
import javax.swing.*;
import java.awt.*;

public class BicycleRentalGUI extends JFrame {

    private JTextField startField;
    private JTextField endField;
    private JLabel resultLabel;

    public BicycleRentalGUI() {

        setTitle("Bicycle Rental System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Title
        JLabel titleLabel = new JLabel(
            "BICYCLE RENTAL SYSTEM", JLabel.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Starting time
        JLabel startLabel = new JLabel("Starting time (0-23):");
        startField = new JTextField();

        // Ending time
        JLabel endLabel = new JLabel("Ending time (1-24):");
        endField = new JTextField();

        // Buttons
        JButton calculateButton = new JButton("Calculate Cost");
        JButton clearButton = new JButton("Clear");

        // Result
        resultLabel = new JLabel("Total rental cost: ", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Calculate button action
        calculateButton.addActionListener(e -> calculateCost());

        // Clear button action
        clearButton.addActionListener(e -> {
            startField.setText("");
            endField.setText("");
            resultLabel.setText("Total rental cost: ");
        });

        // Add components
        panel.add(titleLabel);
        panel.add(startLabel);
        panel.add(startField);
        panel.add(endLabel);
        panel.add(endField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);
    }

    private void calculateCost() {

        try {
            int startTime = Integer.parseInt(startField.getText());
            int endTime = Integer.parseInt(endField.getText());

            int total = 0;

            // Validate input
            if (startTime < 0 || startTime > 23 ||
                endTime < 1 || endTime > 24 ||
                startTime >= endTime) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid starting and ending times.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Calculate cost hour by hour
            for (int hour = startTime; hour < endTime; hour++) {

                if (hour < 7) {
                    total += 500;
                }
                else if (hour < 14) {
                    total += 1000;
                }
                else if (hour < 19) {
                    total += 1500;
                }
                else if (hour < 21) {
                    total += 1000;
                }
                else {
                    total += 500;
                }
            }

            resultLabel.setText(
                "Total rental cost: " + total + " RWF"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter numbers only.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            BicycleRentalGUI gui = new BicycleRentalGUI();
            gui.setVisible(true);
        });
    }
}
