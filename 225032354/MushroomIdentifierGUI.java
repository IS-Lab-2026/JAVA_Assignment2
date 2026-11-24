import javax.swing.*;
import java.awt.*;

public class MushroomIdentifierGUI extends JFrame {

    private static class DecisionNode {
        final String question;
        final String result;
        final String stepLabel;
        final DecisionNode yesBranch;
        final DecisionNode noBranch;

        DecisionNode(String stepLabel, String question, DecisionNode yesBranch, DecisionNode noBranch) {
            this.stepLabel = stepLabel;
            this.question = question;
            this.result = null;
            this.yesBranch = yesBranch;
            this.noBranch = noBranch;
        }

        DecisionNode(String result) {
            this.stepLabel = "Match Found";
            this.question = null;
            this.result = result;
            this.yesBranch = null;
            this.noBranch = null;
        }

        boolean isLeaf() {
            return result != null;
        }
    }

    private final DecisionNode root;
    private DecisionNode currentNode;

    private final JLabel titleLabel;
    private final JLabel optionsLabel;
    private final JLabel stepBadgeLabel;
    private final JLabel promptLabel;
    private final JButton yesButton;
    private final JButton noButton;
    private final JButton restartButton;

    public MushroomIdentifierGUI() {
        this.root = buildTree();
        this.currentNode = root;

        setTitle("Mushroom Identifier");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(248, 250, 249));

        Font topBtnFont = new Font("SansSerif", Font.BOLD, 16);
        Font titleFont = new Font("SansSerif", Font.BOLD, 30);
        Font subtitleFont = new Font("SansSerif", Font.PLAIN, 21);
        Font badgeFont = new Font("SansSerif", Font.BOLD, 16);
        Font promptFont = new Font("SansSerif", Font.BOLD, 28);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 22);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(topBtnFont);
        homeButton.setBackground(new Color(226, 232, 240));
        homeButton.setForeground(new Color(30, 41, 59));
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setBounds(40, 24, 120, 42);
        homeButton.addActionListener(e -> {
            new HomeGUI().setVisible(true);
            dispose();
        });
        add(homeButton);

        titleLabel = new JLabel("Think of one of these mushrooms:", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(28, 35, 33));
        titleLabel.setBounds(170, 24, 860, 42);
        add(titleLabel);

        optionsLabel = new JLabel(
            "<html><center>Agaric jaunissant &bull; Amanite tue-mouches &bull; C&egrave;pe de Bordeaux<br>"
            + "Coprin chevelu &bull; Girolle &bull; Pied bleu</center></html>",
            SwingConstants.CENTER
        );
        optionsLabel.setFont(subtitleFont);
        optionsLabel.setForeground(new Color(85, 98, 92));
        optionsLabel.setBounds(50, 78, 1100, 66);
        add(optionsLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 218, 214));
        separator.setBounds(80, 160, 1040, 2);
        add(separator);

        stepBadgeLabel = new JLabel("", SwingConstants.CENTER);
        stepBadgeLabel.setFont(badgeFont);
        stepBadgeLabel.setForeground(new Color(46, 125, 50));
        stepBadgeLabel.setBounds(50, 180, 1100, 28);
        add(stepBadgeLabel);

        promptLabel = new JLabel("", SwingConstants.CENTER);
        promptLabel.setFont(promptFont);
        promptLabel.setBounds(50, 220, 1100, 95);
        add(promptLabel);

        yesButton = new JButton("Yes");
        yesButton.setFont(buttonFont);
        yesButton.setBackground(new Color(46, 125, 50));
        yesButton.setForeground(Color.WHITE);
        yesButton.setOpaque(true);
        yesButton.setBorderPainted(false);
        yesButton.setFocusPainted(false);
        yesButton.setBounds(350, 365, 220, 72);
        yesButton.addActionListener(e -> choose(true));
        add(yesButton);

        noButton = new JButton("No");
        noButton.setFont(buttonFont);
        noButton.setBackground(new Color(198, 40, 40));
        noButton.setForeground(Color.WHITE);
        noButton.setOpaque(true);
        noButton.setBorderPainted(false);
        noButton.setFocusPainted(false);
        noButton.setBounds(630, 365, 220, 72);
        noButton.addActionListener(e -> choose(false));
        add(noButton);

        restartButton = new JButton("Start Again");
        restartButton.setFont(buttonFont);
        restartButton.setBackground(new Color(33, 78, 120));
        restartButton.setForeground(Color.WHITE);
        restartButton.setOpaque(true);
        restartButton.setBorderPainted(false);
        restartButton.setFocusPainted(false);
        restartButton.setBounds(460, 365, 280, 72);
        restartButton.setVisible(false);
        restartButton.addActionListener(e -> restart());
        add(restartButton);

        renderNode();
    }

    private DecisionNode buildTree() {
        DecisionNode agaric = new DecisionNode("Result: Your mushroom is Agaric jaunissant.");
        DecisionNode amanite = new DecisionNode("Result: Your mushroom is Amanite tue-mouches.");
        DecisionNode piedBleu = new DecisionNode("Result: Your mushroom is Pied bleu.");

        DecisionNode ringForConvex = new DecisionNode(
            "Step 3 of 3",
            "3. Does your mushroom have a ring?",
            amanite,
            piedBleu
        );

        DecisionNode meadowBranch = new DecisionNode(
            "Step 2 of 3",
            "2. Does your mushroom grow in a meadow?",
            agaric,
            ringForConvex
        );

        DecisionNode cepe = new DecisionNode("Result: Your mushroom is Cèpe de Bordeaux.");
        DecisionNode coprin = new DecisionNode("Result: Your mushroom is Coprin chevelu.");
        DecisionNode girolle = new DecisionNode("Result: Your mushroom is Girolle.");

        DecisionNode ringForNonConvex = new DecisionNode(
            "Step 3 of 3",
            "3. Does your mushroom have a ring?",
            coprin,
            girolle
        );

        DecisionNode poresBranch = new DecisionNode(
            "Step 2 of 3",
            "2. Does your mushroom have pores?",
            cepe,
            ringForNonConvex
        );

        return new DecisionNode(
            "Step 1 of 3",
            "1. Does your mushroom have a convex cup?",
            meadowBranch,
            poresBranch
        );
    }

    private void choose(boolean answerYes) {
        if (currentNode == null || currentNode.isLeaf()) {
            return;
        }
        currentNode = answerYes ? currentNode.yesBranch : currentNode.noBranch;
        renderNode();
    }

    private void restart() {
        currentNode = root;
        renderNode();
    }

    private void renderNode() {
        stepBadgeLabel.setText(currentNode.stepLabel.toUpperCase());
        if (currentNode.isLeaf()) {
            stepBadgeLabel.setForeground(new Color(27, 94, 32));
            promptLabel.setText("<html><center>" + currentNode.result + "</center></html>");
            promptLabel.setForeground(new Color(27, 94, 32));
            yesButton.setVisible(false);
            noButton.setVisible(false);
            restartButton.setVisible(true);
        } else {
            stepBadgeLabel.setForeground(new Color(33, 78, 120));
            promptLabel.setText("<html><center>" + currentNode.question + "</center></html>");
            promptLabel.setForeground(new Color(28, 35, 33));
            yesButton.setVisible(true);
            noButton.setVisible(true);
            restartButton.setVisible(false);
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MushroomIdentifierGUI().setVisible(true));
    }
}