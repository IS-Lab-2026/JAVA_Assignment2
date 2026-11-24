
package my.mushroom;

import javax.swing.*;

public class BicycleRentalGUI extends JFrame {

    public BicycleRentalGUI() {

        setTitle("Bicycle Rental");
        JLabel title = new JLabel("RENTAL SYSTEM");

        title.setBounds(300, 10, 300, 40);
         title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
         add(title);

        JLabel start = new JLabel("Start Hour:");
        JTextField startInput = new JTextField();

        JLabel end = new JLabel("End Hour:");
        JTextField endInput = new JTextField();

        JButton calculate = new JButton("Calculate");

        JLabel result = new JLabel("Total Cost: ");

        start.setBounds(30, 30, 100, 30);
        startInput.setBounds(130, 30, 100, 30);

        end.setBounds(30, 80, 100, 30);
        endInput.setBounds(130, 80, 100, 30);

        calculate.setBounds(80, 130, 120, 30);
        result.setBounds(30, 180, 250, 30);

        calculate.addActionListener(e -> {

            int s = Integer.parseInt(startInput.getText());
            int en = Integer.parseInt(endInput.getText());

            int total = BicycleRental.calculateCost(s, en);

            result.setText("Total Cost: " + total + " RWF");
        });
JButton cancel = new JButton("Cancel");

cancel.setBounds(80, 230, 120, 30);

cancel.addActionListener(e -> {
    WELCOME welcome = new WELCOME();
    welcome.setVisible(true);
    this.dispose();
});

add(cancel);
JButton clear = new JButton("Clear");
clear.setBounds(220, 230, 120, 30);

clear.addActionListener(e -> {
    startInput.setText("");
    endInput.setText("");
    result.setText("Total Cost: ");
});

add(clear);
        add(start);
        add(startInput);
        add(end);
        add(endInput);
        add(calculate);
        add(result);

        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new BicycleRentalGUI().setVisible(true);
    }
}
