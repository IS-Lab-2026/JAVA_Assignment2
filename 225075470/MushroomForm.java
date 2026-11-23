import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MushroomForm extends JFrame implements ActionListener {
    JLabel title, ask, result;
    JButton bYes, bNo, bAgain, bCancel;
    int step;

    public MushroomForm() {
        setTitle("GreenWheel Hub - Mushroom Identifier");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(235, 245, 235));

        title = new JLabel("Mushroom Identifier", SwingConstants.CENTER);
        title.setBounds(30, 20, 440, 40);
        title.setFont(new Font("Georgia", Font.BOLD, 28));
        add(title);

        ask = new JLabel("Does it have a ring?", SwingConstants.CENTER);
        ask.setBounds(30, 90, 440, 40);
        ask.setFont(new Font("Verdana", Font.BOLD, 16));
        add(ask);

        bYes = new JButton("Yes");
        bYes.setBounds(90, 150, 130, 42);
        bYes.addActionListener(this);
        add(bYes);

        bNo = new JButton("No");
        bNo.setBounds(270, 150, 130, 42);
        bNo.addActionListener(this);
        add(bNo);

        result = new JLabel("", SwingConstants.CENTER);
        result.setBounds(30, 220, 440, 40);
        result.setFont(new Font("Verdana", Font.BOLD, 18));
        result.setForeground(new Color(20, 110, 60));
        add(result);

        bAgain = new JButton("Start Again");
        bAgain.setBounds(90, 290, 130, 40);
        bAgain.addActionListener(this);
        add(bAgain);

        bCancel = new JButton("Cancel");
        bCancel.setBounds(270, 290, 130, 40);
        bCancel.addActionListener(this);
        add(bCancel);

        step = 1;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCancel) {
            dispose();
        }

        if (e.getSource() == bAgain) {
            step = 1;
            ask.setText("Does it have a ring?");
            result.setText("");
            bYes.setEnabled(true);
            bNo.setEnabled(true);
        }

        if (e.getSource() == bYes || e.getSource() == bNo) {
            boolean yes = false;
            if (e.getSource() == bYes) {
                yes = true;
            }
            String found = "";

            if (step == 1) {
                if (yes) {
                    step = 2;
                    ask.setText("Does it have a convex cup?");
                } else {
                    step = 4;
                    ask.setText("Does it have gills?");
                }
            } else if (step == 2) {
                if (yes) {
                    step = 3;
                    ask.setText("Does it grow in a forest?");
                } else {
                    found = "Coprin chevelu";
                }
            } else if (step == 3) {
                if (yes) {
                    found = "Amanite tue-mouche";
                } else {
                    found = "Agaric jaunissant";
                }
            } else if (step == 4) {
                if (yes) {
                    step = 5;
                    ask.setText("Does it have a convex cup?");
                } else {
                    found = "Cepe de Bordeaux";
                }
            } else if (step == 5) {
                if (yes) {
                    found = "Pied bleu";
                } else {
                    found = "Girolle";
                }
            }

            if (found.length() > 0) {
                ask.setText("Your mushroom is:");
                result.setText(found);
                bYes.setEnabled(false);
                bNo.setEnabled(false);
            }
        }
    }
}