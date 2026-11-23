import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RentalForm extends JFrame implements ActionListener {
    JLabel title, lStart, lEnd, msg;
    JTextField tStart, tEnd;
    JButton bCalc, bCancel;

    public RentalForm() {
        setTitle("GreenWheel Hub - Bicycle Rental");
        setSize(460, 360);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 244, 214));

        title = new JLabel("Bicycle Rental", SwingConstants.CENTER);
        title.setBounds(30, 20, 400, 40);
        title.setFont(new Font("Georgia", Font.BOLD, 28));
        add(title);

        lStart = new JLabel("Starting hour (0 to 23):");
        lStart.setBounds(40, 90, 200, 25);
        add(lStart);

        tStart = new JTextField();
        tStart.setBounds(250, 90, 150, 28);
        add(tStart);

        lEnd = new JLabel("Ending hour (1 to 24):");
        lEnd.setBounds(40, 140, 200, 25);
        add(lEnd);

        tEnd = new JTextField();
        tEnd.setBounds(250, 140, 150, 28);
        add(tEnd);

        bCalc = new JButton("Calculate Price");
        bCalc.setBounds(40, 200, 170, 40);
        bCalc.addActionListener(this);
        add(bCalc);

        bCancel = new JButton("Cancel");
        bCancel.setBounds(230, 200, 170, 40);
        bCancel.addActionListener(this);
        add(bCancel);

        msg = new JLabel("Enter two whole numbers.", SwingConstants.CENTER);
        msg.setBounds(20, 265, 410, 30);
        msg.setFont(new Font("Verdana", Font.BOLD, 14));
        add(msg);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCancel) {
            dispose();
        }

        if (e.getSource() == bCalc) {
            String a = tStart.getText();
            String b = tEnd.getText();
            String error = "";

            if (a.length() == 0 || b.length() == 0) {
                error = "Please fill in both boxes.";
            } else if (a.contains(" ") || b.contains(" ")) {
                error = "No spaces allowed.";
            } else if (a.contains(".") || b.contains(".") || a.contains(",") || b.contains(",")) {
                error = "Whole numbers only, no decimals.";
            } else {
                String both = a + b;
                boolean digitsOnly = true;
                int i = 0;
                while (i < both.length()) {
                    char c = both.charAt(i);
                    if (c < '0' || c > '9') {
                        digitsOnly = false;
                    }
                    i = i + 1;
                }
                if (digitsOnly == false) {
                    error = "Use digits 0-9 only, no letters or symbols.";
                } else if (a.length() > 2 || b.length() > 2) {
                    error = "Hours must be between 0 and 24.";
                }
            }

            if (error.length() == 0) {
                int start = Integer.parseInt(a);
                int end = Integer.parseInt(b);

                if (start > 23) {
                    error = "Starting hour must be 0 to 23.";
                } else if (end < 1 || end > 24) {
                    error = "Ending hour must be 1 to 24.";
                } else if (start >= end) {
                    error = "Start must be less than end.";
                }
            }

            if (error.length() > 0) {
                msg.setForeground(Color.RED);
                msg.setText(error);
            } else {
                int start = Integer.parseInt(a);
                int end = Integer.parseInt(b);
                int total = 0;
                int hour = start;

                while (hour < end) {
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
                    hour = hour + 1;
                }

                msg.setForeground(new Color(20, 110, 60));
                msg.setText("Total to pay: " + total + " RWF");
            }
        }
    }
}