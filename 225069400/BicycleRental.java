package Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BicycleRental extends JFrame {

    private JComboBox<Integer> startTime;
    private JComboBox<Integer> endTime;
    private JLabel resultLabel;
    private Welcome welcome;

    private static final Color BACKGROUND = new Color(25, 42, 86);

    public BicycleRental(Welcome welcome) {
        this.welcome = welcome;

        setTitle("Bicycle Rental System");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                BicycleRental.this.welcome.setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 15));
        panel.setBackground(BACKGROUND);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("BICYCLE RENTAL SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        panel.add(createLabel("Starting Hour:"));

        startTime = new JComboBox<>();
        for (int i = 0; i <= 23; i++) {
            startTime.addItem(i);
        }
        styleComboBox(startTime);
        panel.add(startTime);

        panel.add(createLabel("Ending Hour:"));

        endTime = new JComboBox<>();
        for (int i = 1; i <= 24; i++) {
            endTime.addItem(i);
        }
        styleComboBox(endTime);
        panel.add(endTime);

        JButton calculateButton = new JButton("Calculate Cost");
        styleButton(calculateButton, new Color(46, 125, 50));
        panel.add(calculateButton);

        JButton clearButton = new JButton("Clear");
        styleButton(clearButton, new Color(33, 150, 243));
        panel.add(clearButton);

        panel.add(createLabel("Total Rental Cost:"));

        resultLabel = new JLabel("0 RWF");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(new Color(102, 255, 102));
        panel.add(resultLabel);

        JButton cancelButton = new JButton("Cancel");
        styleButton(cancelButton, new Color(245, 124, 0));
        panel.add(cancelButton);
        panel.add(new JLabel());

        calculateButton.addActionListener(e -> calculateCost());

        clearButton.addActionListener(e -> {
            startTime.setSelectedIndex(0);
            endTime.setSelectedIndex(0);
            resultLabel.setText("0 RWF");
        });

        cancelButton.addActionListener(e -> {
            dispose();
            welcome.setVisible(true);
        });

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        return label;
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    private void styleComboBox(JComboBox<Integer> comboBox) {
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.BLACK);
    }

    private void calculateCost() {
        int start = (int) startTime.getSelectedItem();
        int end = (int) endTime.getSelectedItem();

        if (start >= end) {
            JOptionPane.showMessageDialog(
                this,
                "Starting hour must be less than ending hour!",
                "Invalid Rental Time",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int totalCost = 0;

        for (int hour = start; hour < end; hour++) {
            int rate;

            if (hour < 7 || hour >= 21) {
                rate = 500;
            } else if (hour < 14 || hour >= 19) {
                rate = 1000;
            } else {
                rate = 1500;
            }

            totalCost += rate;
        }

        resultLabel.setText(totalCost + " RWF");
    }
}