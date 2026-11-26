package lab2;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lab1.BicycleRental;

public class BicycleRentalForm extends JFrame {

    public BicycleRentalForm() {
        setTitle("Bicycle rental");
        setSize(360, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JTextField startField = new JTextField();
        JTextField endField = new JTextField();
        JButton calcBtn = new JButton("Calculate Rent");
        JButton cancelBtn = new JButton("Cancel");
        JLabel resultLabel = new JLabel("Total: -");

        calcBtn.addActionListener(e -> {
            try {
                int startHour = Integer.parseInt(startField.getText().trim());
                int endHour = Integer.parseInt(endField.getText().trim());
                int cost = BicycleRental.calculateRentalCost(startHour, endHour);
                resultLabel.setText("Total: " + cost + " RWF");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter whole numbers only.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Range Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> dispose());

        panel.add(new JLabel("Start Hour (0-23):"));
        panel.add(startField);
        panel.add(new JLabel("End Hour (1-24):"));
        panel.add(endField);
        panel.add(calcBtn);
        panel.add(resultLabel);
        panel.add(new JLabel(""));
        panel.add(cancelBtn);

        add(panel);
    }
}