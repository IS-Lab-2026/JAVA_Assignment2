package Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mushroom extends JFrame {

    private final JLabel questionLabel;
    private final JLabel resultLabel;
    private final JButton yesButton;
    private final JButton noButton;
    private final JButton restartButton;
    private final JButton cancelButton;
    private Welcome welcome;

    private String step = "gills";

    private static final Color BACKGROUND = new Color(190, 190, 190);

    public Mushroom(Welcome welcome) {
        this.welcome = welcome;

        setTitle("MUSHROOM SYSTEM");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Mushroom.this.welcome.setVisible(true);
            }
        });

        JLabel title = new JLabel("MUSHROOM SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(30, 30, 30));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setBackground(BACKGROUND);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel instruction = new JLabel(
                "<html><center>Think of one of the six mushrooms.<br>Answer using Yes or No.</center></html>");
        instruction.setForeground(new Color(60, 60, 60));
        instruction.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(instruction);

        questionLabel = new JLabel("Does your mushroom have gills?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setForeground(new Color(30, 30, 30));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(questionLabel);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setForeground(new Color(0, 100, 0));
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(resultLabel);

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBackground(BACKGROUND);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 30, 30));

        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        restartButton = new JButton("Restart");
        cancelButton = new JButton("Cancel");

        styleButton(yesButton, new Color(46, 125, 50));
        styleButton(noButton, new Color(211, 47, 47));
        styleButton(restartButton, new Color(33, 150, 243));
        styleButton(cancelButton, new Color(245, 124, 0));

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        buttonPanel.add(restartButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        yesButton.addActionListener(e -> answer(true));
        noButton.addActionListener(e -> answer(false));
        restartButton.addActionListener(e -> restart());

        cancelButton.addActionListener(e -> {
            dispose();
            welcome.setVisible(true);
        });

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    private void answer(boolean yes) {
        switch (step) {
            case "gills":
                if (!yes) {
                    showResult("Cepe de Bordeaux");
                } else {
                    ask("forest", "Does your mushroom grow in a forest?");
                }
                break;

            case "forest":
                if (!yes) {
                    ask("convexNoForest", "Does your mushroom have a convex cup?");
                } else {
                    ask("convexForest", "Does your mushroom have a convex cup?");
                }
                break;

            case "convexNoForest":
                showResult(yes ? "Agaric jaunissant" : "Coprin chevelu");
                break;

            case "convexForest":
                if (yes) {
                    showResult("Pied bleu");
                } else {
                    ask("ring", "Does your mushroom have a ring?");
                }
                break;

            case "ring":
                showResult(yes ? "Amanite tue-mouche" : "Girolle");
                break;
        }
    }

    private void ask(String nextStep, String question) {
        step = nextStep;
        questionLabel.setText(question);
    }

    private void showResult(String mushroom) {
        step = "done";
        questionLabel.setText("Your mushroom is:");
        resultLabel.setText(mushroom);
        yesButton.setEnabled(false);
        noButton.setEnabled(false);
    }

    private void restart() {
        step = "gills";
        questionLabel.setText("Does your mushroom have gills?");
        resultLabel.setText("");
        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }
}