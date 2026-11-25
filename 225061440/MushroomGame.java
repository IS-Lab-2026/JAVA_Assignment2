import javax.swing.*;
import java.awt.event.*;

public class MushroomGame extends JFrame implements ActionListener {
    JLabel lblInfo, lblQuestion, lblCount;
    JButton btnYes, btnNo, btnRestart;
    int step = 1;
    int count = 1;

    public MushroomGame() {
        setTitle("Mushroom Identifier");
        setSize(430, 260);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] mushrooms = {
            "Agaric Jaunissant",
            "Amanite tue-mouche",
            "Cepe de bordeaux",
            "Coprin chevelu",
            "Girolle",
            "Pied bleu"
        };

        String text = "Think of one: ";
        for (int i = 0; i < mushrooms.length; i++) {
            text = text + mushrooms[i];
            if (i < mushrooms.length - 1) {
                text = text + ", ";
            }
        }

        lblInfo = new JLabel("<html>" + text + "</html>");
        lblInfo.setBounds(25, 15, 370, 45);
        add(lblInfo);

        lblQuestion = new JLabel("Does your mushroom have a ring?");
        lblQuestion.setBounds(25, 80, 370, 25);
        add(lblQuestion);

        lblCount = new JLabel("Question: 1 / 3");
        lblCount.setBounds(25, 110, 200, 25);
        add(lblCount);

        btnYes = new JButton("Yes");
        btnYes.setBounds(45, 155, 90, 30);
        btnYes.addActionListener(this);
        add(btnYes);

        btnNo = new JButton("No");
        btnNo.setBounds(155, 155, 90, 30);
        btnNo.addActionListener(this);
        add(btnNo);

        btnRestart = new JButton("Restart");
        btnRestart.setBounds(265, 155, 95, 30);
        btnRestart.addActionListener(this);
        add(btnRestart);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRestart) {
            step = 1;
            count = 1;
            lblQuestion.setText("Does your mushroom have a ring?");
            lblCount.setText("Question: 1 / 3");
            btnYes.setEnabled(true);
            btnNo.setEnabled(true);
            return;
        }

        boolean yes = (e.getSource() == btnYes);

        if (step == 1) {
            count++;
            lblCount.setText("Question: " + count + " / 3");
            if (yes) {
                step = 2;
                lblQuestion.setText("Does your mushroom grow in a forest ?");
            } else {
                step = 4;
                lblQuestion.setText("Does your mushroom have gills ?");
            }
        } else if (step == 2) {
            if (yes) {
                showResult("Amanite tue-mouche");
            } else {
                count++;
                step = 3;
                lblCount.setText("Question: " + count + " / 3");
                lblQuestion.setText("Does your mushroom have a convex cup?");
            }
        } else if (step == 3) {
            if (yes) {
                showResult("Agaric Jaunissant");
            } else {
                showResult("Coprin chevelu");
            }
        } else if (step == 4) {
            if (!yes) {
                showResult("Cepe de bordeaux");
            } else {
                count++;
                step = 5;
                lblCount.setText("Question: " + count + " / 3");
                lblQuestion.setText("Does your mushroom have a convex cup?");
            }
        } else if (step == 5) {
            if (yes) {
                showResult("Pied bleu");
            } else {
                showResult("Girolle");
            }
        }
    }

    void showResult(String name) {
        lblQuestion.setText("Your mushroom is: " + name);
        lblCount.setText("Done in " + count + " questions");
        btnYes.setEnabled(false);
        btnNo.setEnabled(false);
    }

    public static void main(String[] args) {
        new MushroomGame();
    }
}