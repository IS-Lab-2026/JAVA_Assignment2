package com.mycompany.gui_assign;

import java.awt.*;
import javax.swing.*;

/** Mushroom identifier using the decision rules from the form interface. */
public class MushroomIdentification extends JFrame {
    private final ButtonGroup bgring = new ButtonGroup();
    private final ButtonGroup bgforest = new ButtonGroup();
    private final ButtonGroup bgconvex = new ButtonGroup();
    private final ButtonGroup bggills = new ButtonGroup();

    private final JRadioButton rbtnringyes = new JRadioButton("Yes");
    private final JRadioButton rbtnringno = new JRadioButton("No");
    private final JRadioButton rbtnforestyes = new JRadioButton("Yes");
    private final JRadioButton rbtnforestno = new JRadioButton("No");
    private final JRadioButton rbtnconvexyes = new JRadioButton("Yes");
    private final JRadioButton rbtnconvexno = new JRadioButton("No");
    private final JRadioButton rbtngillsyes = new JRadioButton("Yes");
    private final JRadioButton rbtngillsno = new JRadioButton("No");

    private final JTextField TxtMushroomName = new JTextField(25);

    public MushroomIdentification() {
        setTitle("Mushroom Identifier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 470);
        setMinimumSize(new Dimension(600, 430));
        setLocationRelativeTo(null);
        TxtMushroomName.setEditable(false);
        buildForm();
    }

    private void addQuestion(JPanel panel, GridBagConstraints c, int row, String question,
                             ButtonGroup group, JRadioButton yes, JRadioButton no) {
        yes.setOpaque(false);
        no.setOpaque(false);
        group.add(yes);
        group.add(no);

        c.gridy = row;
        c.gridx = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JLabel(question), c);

        JPanel choices = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
        choices.setOpaque(false);
        choices.add(yes);
        choices.add(no);

        c.gridx = 1;
        c.weightx = 0;
        panel.add(choices, c);
    }

    private void buildForm() {
        JPanel page = new JPanel(new BorderLayout(12, 18));
        page.setBorder(BorderFactory.createEmptyBorder(22, 25, 22, 25));
        page.setBackground(new Color(248, 250, 252));

        JLabel title = new JLabel("MUSHROOM IDENTIFIER", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 24));
        title.setForeground(new Color(31, 41, 55));
        page.add(title, BorderLayout.NORTH);

        JPanel questions = new JPanel(new GridBagLayout());
        questions.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 8, 10, 8);
        c.anchor = GridBagConstraints.WEST;

        addQuestion(questions, c, 0, "Does your mushroom have a ring?", bgring, rbtnringyes, rbtnringno);
        addQuestion(questions, c, 1, "Does your mushroom grow in a forest?", bgforest, rbtnforestyes, rbtnforestno);
        addQuestion(questions, c, 2, "Does your mushroom have a convex cap?", bgconvex, rbtnconvexyes, rbtnconvexno);
        addQuestion(questions, c, 3, "Does your mushroom have gills?", bggills, rbtngillsyes, rbtngillsno);

        c.gridy = 4;
        c.gridx = 0;
        c.weightx = 0;
        questions.add(new JLabel("Mushroom name:"), c);

        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        questions.add(TxtMushroomName, c);

        page.add(questions, BorderLayout.CENTER);

        JButton execute = new JButton("Execute");
        execute.setBackground(new Color(0, 153, 0));
        execute.setForeground(Color.WHITE);

        JButton clear = new JButton("Clear");
        JButton back = new JButton("Back to Welcome");

        execute.addActionListener(e -> btnexecuteActionPerformed());
        clear.addActionListener(e -> btnclearActionPerformed());
        back.addActionListener(e -> handleBackToWelcome());

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        buttons.setOpaque(false);
        buttons.add(execute);
        buttons.add(clear);
        buttons.add(back);
        page.add(buttons, BorderLayout.SOUTH);

        setContentPane(page);
    }

    private void handleBackToWelcome() {
        try {
            Class<?> welcomeClass = Class.forName("com.mycompany.gui_assign.Welcome");
            Object welcomeFrame = welcomeClass.getDeclaredConstructor().newInstance();
            if (welcomeFrame instanceof Window window) {
                window.setVisible(true);
            }
            dispose();
        } catch (ReflectiveOperationException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Welcome screen is not available yet.",
                "Navigation Notice",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void btnexecuteActionPerformed() {
        if (!(rbtnringyes.isSelected() || rbtnringno.isSelected())) {
            JOptionPane.showMessageDialog(this, "Please answer: Does your mushroom have a ring?");
            return;
        }
        if (!(rbtnforestyes.isSelected() || rbtnforestno.isSelected())) {
            JOptionPane.showMessageDialog(this, "Please answer: Does your mushroom grow in a forest?");
            return;
        }
        if (!(rbtnconvexyes.isSelected() || rbtnconvexno.isSelected())) {
            JOptionPane.showMessageDialog(this, "Please answer: Does your mushroom have a convex cap?");
            return;
        }
        if (!(rbtngillsyes.isSelected() || rbtngillsno.isSelected())) {
            JOptionPane.showMessageDialog(this, "Please answer: Does your mushroom have gills?");
            return;
        }

        boolean hasRing = rbtnringyes.isSelected();
        boolean inForest = rbtnforestyes.isSelected();
        boolean convexCap = rbtnconvexyes.isSelected();
        boolean hasGills = rbtngillsyes.isSelected();

        String result;
       if (!hasGills && inForest && !hasRing && !convexCap) {
            result = "Cepe de bordeau";
        } else if (hasGills && inForest && hasRing && convexCap) {
            result = "Amanite tue-mouche";
        } else if (hasGills && !inForest && hasRing && convexCap) {
            result = "Agaric Jaunissant";
        } else if (hasGills && !inForest && hasRing && !convexCap) {
            result = "Coprin chevelu";
        } else if (hasGills && inForest && !hasRing && convexCap) {
            result = "Pied bleu";
        } else if (hasGills && inForest && !hasRing && !convexCap) {
            result = "Girolle";
        } else {
            result = "Unknown Mushroom";
        }

        TxtMushroomName.setText(result);
    }

    private void btnclearActionPerformed() {
        bgring.clearSelection();
        bgforest.clearSelection();
        bgconvex.clearSelection();
        bggills.clearSelection();
        TxtMushroomName.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MushroomIdentification().setVisible(true));
    }
}