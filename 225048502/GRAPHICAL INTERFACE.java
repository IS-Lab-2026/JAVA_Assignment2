
import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    CardLayout cardLayout;
    JPanel mainPanel;

    JTextField startField;
    JTextField endField;
    JLabel rentResult;

    JLabel questionLabel;
    JLabel mushroomResult;

    JButton yesButton;
    JButton noButton;

    int step = 0;

    public MainMenu() {

        setTitle("WELCAME");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createMainMenu(), "MENU");
        mainPanel.add(createProblemOne(), "BICYLERENTAL");
        mainPanel.add(createProblemTwo(), "MUSHROOMIDENTIFICATION");

        add(mainPanel);

        cardLayout.show(mainPanel, "MENU");

        setVisible(true);
    }

    // ============ MAIN MENU ============

    private JPanel createMainMenu() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(230, 240, 250));

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(5, 1, 15, 15));
        content.setPreferredSize(new Dimension(350, 300));
        content.setBackground(new Color(230, 240, 250));

        JLabel title = new JLabel(
            "welcome",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel subtitle = new JLabel(
            "Select a problem",
            SwingConstants.CENTER
        );

        JButton problem1 = new JButton("bicycle rental");
        JButton problem2 = new JButton("mushroom identification");
        JButton exit = new JButton("EXIT");

        problem1.addActionListener(e -> {
            cardLayout.show(mainPanel, "BICYLERENTAL");
        });

        problem2.addActionListener(e -> {
            resetProblemTwo();
            cardLayout.show(mainPanel, "MUSHROOMIDENTIFICATION");
        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

        content.add(title);
        content.add(subtitle);
        content.add(problem1);
        content.add(problem2);
        content.add(exit);

        panel.add(content);

        return panel;
    }

    // ============ PROBLEM ONE ============

    private JPanel createProblemOne() {

        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(
            30, 50, 30, 50
        ));

        JLabel title = new JLabel(
            "BICYCLE RENTAL",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        JPanel form = new JPanel(new GridLayout(5, 1, 10, 10));

        form.add(new JLabel("Enter starting time:"));

        startField = new JTextField();
        form.add(startField);

        form.add(new JLabel("Enter ending time:"));

        endField = new JTextField();
        form.add(endField);

        JButton calculate = new JButton("CALCULATE COST");

        rentResult = new JLabel(
            "Total rent cost will appear here",
            SwingConstants.CENTER
        );

        rentResult.setFont(new Font("Arial", Font.BOLD, 16));

        calculate.addActionListener(e -> calculateRent());

        JButton back = new JButton("BACK TO MAIN MENU");

        back.addActionListener(e -> {
            cardLayout.show(mainPanel, "MENU");
        });

        JPanel bottom = new JPanel(new GridLayout(2, 1, 10, 10));

        bottom.add(calculate);
        bottom.add(back);

        panel.add(title, BorderLayout.NORTH);
        panel.add(form, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        resultPanel.add(rentResult);
        resultPanel.add(bottom);

        panel.add(resultPanel, BorderLayout.SOUTH);

        return panel;
    }

    // RENT CALCULATION

    private void calculateRent() {

        try {

            int start = Integer.parseInt(startField.getText());
            int end = Integer.parseInt(endField.getText());

            if (start < 0 || start > 23) {

                JOptionPane.showMessageDialog(
                    this, "Invalid starting time!"
                );

                return;
            }

            if (end < 1 || end > 24) {

                JOptionPane.showMessageDialog(
                    this, "Invalid ending time!"
                );

                return;
            }

            if (start >= end) {

                JOptionPane.showMessageDialog(
                    this, "Start time must be before end time!"
                );

                return;
            }

            int totalCost = 0;

            for (int hour = start; hour < end; hour++) {

                if (hour < 7 || hour >= 21) {

                    totalCost += 500;

                } else if (
                    (hour >= 7 && hour < 14) ||
                    (hour >= 19 && hour < 21)
                ) {

                    totalCost += 1000;

                } else if (hour >= 14 && hour < 19) {

                    totalCost += 1500;
                }
            }

            rentResult.setText(
                "Total Rent Cost: " + totalCost + " RWF"
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this, "Please enter valid numbers!"
            );
        }
    }

    // ============ PROBLEM TWO ============

    private JPanel createProblemTwo() {

        JPanel panel = new JPanel(new BorderLayout(20, 20));

        panel.setBorder(BorderFactory.createEmptyBorder(
            40, 40, 40, 40
        ));

        JLabel title = new JLabel(
            " MUSHROOM IDENTIFICATION",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 19));

        questionLabel = new JLabel(
            "Does your mushroom have gills?",
            SwingConstants.CENTER
        );

        questionLabel.setFont(
            new Font("Arial", Font.PLAIN, 18)
        );

        yesButton = new JButton("YES");
        noButton = new JButton("NO");

        JPanel buttons = new JPanel();

        buttons.add(yesButton);
        buttons.add(noButton);

        mushroomResult = new JLabel(
            "Answer the questions to identify the mushroom.",
            SwingConstants.CENTER
        );

        JButton back = new JButton("BACK TO MAIN MENU");

        yesButton.addActionListener(e -> answerQuestion(1));
        noButton.addActionListener(e -> answerQuestion(0));

        back.addActionListener(e -> {
            cardLayout.show(mainPanel, "MENU");
        });

        panel.add(title, BorderLayout.NORTH);
        panel.add(questionLabel, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.EAST);
        panel.add(mushroomResult, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        centerPanel.add(questionLabel, BorderLayout.CENTER);
        centerPanel.add(buttons, BorderLayout.SOUTH);

        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(2, 1, 10, 10));

        bottom.add(mushroomResult);
        bottom.add(back);

        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    // MUSHROOM QUESTIONS

    private void answerQuestion(int answer) {

        switch (step) {

            case 0:

                if (answer == 0) {

                    showResult("Cepe de bordeaux");

                } else {

                    questionLabel.setText(
                        "Does your mushroom grow in a forest?"
                    );

                    step = 1;
                }

                break;

            case 1:

                if (answer == 0) {

                    questionLabel.setText(
                        "Does your mushroom have a convex cup?"
                    );

                    step = 2;

                } else {

                    questionLabel.setText(
                        "Does your mushroom have a ring?"
                    );

                    step = 3;
                }

                break;

            case 2:

                if (answer == 1) {

                    showResult("Agaric jaunissant");

                } else {

                    showResult("Coprin chevelu");
                }

                break;

            case 3:

                if (answer == 1) {

                    showResult("Amanite tue-mouches");

                } else {

                    questionLabel.setText(
                        "Does your mushroom have a convex cup?"
                    );

                    step = 4;
                }

                break;

            case 4:

                if (answer == 1) {

                    showResult("Pied bleu");

                } else {
                    showResult("Girolle");
                }

                break;
        }
    }

    // DISPLAY RESULT

    private void showResult(String name) {

        questionLabel.setText("Identification completed!");

        mushroomResult.setText(
            "Your mushroom is: " + name
        );

        yesButton.setEnabled(false);
        noButton.setEnabled(false);
    }

    // RESET PROBLEM TWO

    private void resetProblemTwo() {

        step = 0;

        questionLabel.setText(
            "Does your mushroom have gills?"
        );

        mushroomResult.setText(
            "Answer the questions to identify the mushroom."
        );

        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }

    // ============ MAIN METHOD ============

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MainMenu();
        });
    }
}
