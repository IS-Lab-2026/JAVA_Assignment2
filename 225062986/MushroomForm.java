import javax.swing.*;
import java.awt.event.*;

public class MushroomForm extends JFrame implements ActionListener {

    JLabel question = new JLabel("Does your mushroom have a ring?");
    JButton yesButton = new JButton("Yes");
    JButton noButton = new JButton("No");
    JButton cancelButton = new JButton("Cancel");

    int step = 1;

    public MushroomForm() {
        setTitle("Mushroom Id");
        setSize(400, 260);
        setLayout(null);

        question.setBounds(20, 30, 360, 30);
        yesButton.setBounds(60, 100, 100, 35);
        noButton.setBounds(220, 100, 100, 35);
        cancelButton.setBounds(270, 170, 100, 30);

        add(question);
        add(yesButton);
        add(noButton);
        add(cancelButton);

        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void showResult(String name) {
        question.setText("Your mushroom is: " + name);
        yesButton.setVisible(false);
        noButton.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            dispose();
            return;
        }

        boolean yes = false;
        if (e.getSource() == yesButton) {
            yes = true;
        }

        if (step == 1) {
            if (yes) {
                step = 2;
                question.setText("Does your mushroom grow in a forest?");
            } else {
                step = 4;
                question.setText("Does your mushroom have gills?");
            }
        } else if (step == 2) {
            if (yes) {
                showResult("Amanite tue-mouche");
            } else {
                step = 3;
                question.setText("Does your mushroom have a convex cup?");
            }
        } else if (step == 3) {
            if (yes) {
                showResult("Agaric jaunissant");
            } else {
                showResult("Coprin chevelu");
            }
        } else if (step == 4) {
            if (yes) {
                step = 5;
                question.setText("Does your mushroom have a convex cup?");
            } else {
                showResult("Cepe de Bordeaux");
            }
        } else if (step == 5) {
            if (yes) {
                showResult("Pied bleu");
            } else {
                showResult("Girolle");
            }
        }
    }
}