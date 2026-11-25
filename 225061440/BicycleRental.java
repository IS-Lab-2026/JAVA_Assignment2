import javax.swing.*;
import java.awt.event.*;

public class BicycleRental extends JFrame implements ActionListener {
    JLabel lblStart, lblEnd, lblTotal, lblCalc;
    JTextField txtStart, txtEnd, txtTotal;
    JButton btnCalc;

    public BicycleRental() {
        setTitle("Bicycle Rental");
        setSize(330, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblStart = new JLabel("Start");
        lblStart.setBounds(40, 30, 70, 25);
        add(lblStart);

        txtStart = new JTextField();
        txtStart.setBounds(120, 30, 130, 25);
        add(txtStart);

        lblEnd = new JLabel("End");
        lblEnd.setBounds(40, 70, 70, 25);
        add(lblEnd);

        txtEnd = new JTextField();
        txtEnd.setBounds(120, 70, 130, 25);
        add(txtEnd);

        lblTotal = new JLabel("Total");
        lblTotal.setBounds(40, 110, 70, 25);
        add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(120, 110, 130, 25);
        txtTotal.setEditable(false);
        add(txtTotal);

        lblCalc = new JLabel("calculate");
        lblCalc.setBounds(70, 155, 70, 25);
        add(lblCalc);

        btnCalc = new JButton("Calculate");
        btnCalc.setBounds(150, 155, 110, 28);
        btnCalc.addActionListener(this);
        add(btnCalc);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int start = Integer.parseInt(txtStart.getText());
            int end = Integer.parseInt(txtEnd.getText());

            if (start < 0 || start > 23 || end < 1 || end > 24) {
                JOptionPane.showMessageDialog(this, "Start must be 0-23 and End must be 1-24");
            } else if (start >= end) {
                JOptionPane.showMessageDialog(this, "Starting time must be less than ending time");
            } else {
                int total = 0;
                for (int i = start; i < end; i++) {
                    if ((i >= 0 && i < 7) || (i >= 21 && i < 24)) {
                        total = total + 500;
                    } else if ((i >= 7 && i < 14) || (i >= 19 && i < 21)) {
                        total = total + 1000;
                    } else if (i >= 14 && i < 19) {
                        total = total + 1500;
                    }
                }
                txtTotal.setText(total + " RWF");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter whole numbers only");
        }
    }

    public static void main(String[] args) {
        new BicycleRental();
    }
}