import javax.swing.*;
import java.awt.event.*;

public class RentalForm extends JFrame implements ActionListener {

    JLabel startLabel = new JLabel("Start hour:");
    JTextField startBox = new JTextField();
    JLabel endLabel = new JLabel("End hour:");
    JTextField endBox = new JTextField();
    JButton calcButton = new JButton("Calculate");
    JButton cancelButton = new JButton("Cancel");
    JLabel result = new JLabel("");

    public RentalForm() {
        setTitle("Bicycle rental");
        setSize(350, 280);
        setLayout(null);

        startLabel.setBounds(20, 20, 130, 25);
        startBox.setBounds(160, 20, 150, 25);
        endLabel.setBounds(20, 60, 130, 25);
        endBox.setBounds(160, 60, 150, 25);
        calcButton.setBounds(100, 105, 120, 30);
        result.setBounds(20, 150, 300, 25);
        cancelButton.setBounds(220, 200, 100, 30);

        add(startLabel);
        add(startBox);
        add(endLabel);
        add(endBox);
        add(calcButton);
        add(result);
        add(cancelButton);

        calcButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            dispose();
        }

        if (e.getSource() == calcButton) {
            try {
                int start = Integer.parseInt(startBox.getText().trim());
                int end = Integer.parseInt(endBox.getText().trim());

                if (start < 0 || start > 23 || end < 1 || end > 24 || start >= end) {
                    result.setText("Invalid input");
                } else {
                    int total = 0;
                    int hour = start;

                    while (hour < end) {
                        int rate;

                        if (hour < 7) {
                            rate = 500;
                        } else if (hour < 14) {
                            rate = 1000;
                        } else if (hour < 19) {
                            rate = 1500;
                        } else if (hour < 21) {
                            rate = 1000;
                        } else {
                            rate = 500;
                        }

                        total = total + rate;
                        hour = hour + 1;
                    }

                    result.setText("Total to pay: " + total + " RWF");
                }
            } catch (Exception ex) {
                result.setText("Enter whole numbers only");
            }
        }
    }
}