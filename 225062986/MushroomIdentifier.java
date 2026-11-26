
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MushroomIdentifier extends JFrame {

    JLabel resultLabel;

    public MushroomIdentifier() {
        setTitle("CampusDesk - Mushroom Identifier");
        setSize(480, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(243, 246, 250));

        JLabel title = new JLabel("Mushroom Identifier");
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(new Color(20, 40, 62));
        title.setBounds(80, 25, 330, 35);
        add(title);

        JLabel info = new JLabel("Think of one mushroom and answer truthfully.");
        info.setBounds(55, 80, 370, 25);
        add(info);

        JButton identifyBtn = new JButton("Start Identification");
        identifyBtn.setBounds(60, 130, 190, 45);
        identifyBtn.setBackground(new Color(27, 153, 139));
        identifyBtn.setForeground(Color.WHITE);
        add(identifyBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(270, 130, 130, 45);
        add(cancelBtn);

        resultLabel = new JLabel("Your mushroom will appear here.");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(new Color(20, 40, 62));
        resultLabel.setBounds(45, 205, 390, 60);
        add(resultLabel);

        identifyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                identify();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void identify() {
        int answer = JOptionPane.showConfirmDialog(
                this,
                "Does your mushroom have a ring?",
                "Question 1",
                JOptionPane.YES_NO_OPTION
        );

        if (answer == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (answer == JOptionPane.YES_OPTION) {

            answer = JOptionPane.showConfirmDialog(
                    this,
                    "Does it grow in a forest?",
                    "Question 2",
                    JOptionPane.YES_NO_OPTION
            );

            if (answer == JOptionPane.CLOSED_OPTION) {
                return;
            }

            if (answer == JOptionPane.YES_OPTION) {
                resultLabel.setText("Your mushroom is Amanite tue-mouche.");
            } else {
                answer = JOptionPane.showConfirmDialog(
                        this,
                        "Does it have a convex cup?",
                        "Question 3",
                        JOptionPane.YES_NO_OPTION
                );

                if (answer == JOptionPane.CLOSED_OPTION) {
                    return;
                }

                if (answer == JOptionPane.YES_OPTION) {
                    resultLabel.setText("Your mushroom is Agaric jaunissant.");
                } else {
                    resultLabel.setText("Your mushroom is Coprin chevelu.");
                }
            }

        } else {

            answer = JOptionPane.showConfirmDialog(
                    this,
                    "Does it have gills?",
                    "Question 2",
                    JOptionPane.YES_NO_OPTION
            );

            if (answer == JOptionPane.CLOSED_OPTION) {
                return;
            }

            if (answer == JOptionPane.NO_OPTION) {
                resultLabel.setText("Your mushroom is Cepe de Bordeaux.");
            } else {
                answer = JOptionPane.showConfirmDialog(
                        this,
                        "Does it have a convex cup?",
                        "Question 3",
                        JOptionPane.YES_NO_OPTION
                );

                if (answer == JOptionPane.CLOSED_OPTION) {
                    return;
                }

                if (answer == JOptionPane.YES_OPTION) {
                    resultLabel.setText("Your mushroom is Pied bleu.");
                } else {
                    resultLabel.setText("Your mushroom is Girolle.");
                }
            }
        }
    }
}
