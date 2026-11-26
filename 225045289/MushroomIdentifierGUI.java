import javax.swing.*;
import java.awt.*;

/**
 * Mushroom identification screen. Same questions and decision tree as the
 * console Mushroom program:
 * gills -> forest -> convex cap -> ring.
 */
public class MushroomIdentifierGUI extends JFrame {

    /**
     * One step of the decision tree: either a question with Yes/No branches, or a
     * final result.
     */
    private static class Node {
        final String question;
        final String result;
        final Node yesBranch;
        final Node noBranch;

        // A question node
        Node(String question, Node yesBranch, Node noBranch) {
            this.question = question;
            this.result = null;
            this.yesBranch = yesBranch;
            this.noBranch = noBranch;
        }

        // A result (leaf) node
        Node(String result) {
            this.question = null;
            this.result = result;
            this.yesBranch = null;
            this.noBranch = null;
        }

        boolean isLeaf() {
            return result != null;
        }
    }

    private final Node root;
    private Node currentNode;
    private int questionNumber = 1;

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

        // Cancel goes back to the home page
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(topBtnFont);
        cancelButton.setBackground(new Color(226, 232, 240));
        cancelButton.setForeground(new Color(30, 41, 59));
        cancelButton.setOpaque(true);
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.setBounds(40, 24, 120, 42);
        cancelButton.addActionListener(e -> {
            new HomeGUI().setVisible(true);
            dispose();
        });
        add(cancelButton);

        JLabel titleLabel = new JLabel("Think of one of these mushrooms:", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(28, 35, 33));
        titleLabel.setBounds(170, 24, 860, 42);
        add(titleLabel);

        JLabel optionsLabel = new JLabel(
                "<html><center>Agaric Jaunissant &bull; Amanite Tue-Mouche &bull; C&egrave;pe de Bordeaux<br>"
                        + "Coprin Chevelu &bull; Girolle &bull; Pied Bleu</center></html>",
                SwingConstants.CENTER);
        optionsLabel.setFont(subtitleFont);
        optionsLabel.setForeground(new Color(85, 98, 92));
        optionsLabel.setBounds(50, 78, 1100, 66);
        add(optionsLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(80, 160, 1040, 2);
        add(separator);

        stepBadgeLabel = new JLabel("", SwingConstants.CENTER);
        stepBadgeLabel.setFont(badgeFont);
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

    /** Builds the same decision tree as the console program. */
    private Node buildTree() {
        // Forest branch: convex cap? -> ring?
        Node amanite = new Node("Amanite Tue-Mouche");
        Node piedBleu = new Node("Pied Bleu");
        Node girolle = new Node("Girolle");
        Node ringQuestion = new Node("Does your mushroom have a ring?", amanite, piedBleu);
        Node capInForest = new Node("Does your mushroom have a convex cap?", ringQuestion, girolle);

        // Meadow branch: convex cap?
        Node agaric = new Node("Agaric Jaunissant");
        Node coprin = new Node("Coprin Chevelu");
        Node capInMeadow = new Node("Does your mushroom have a convex cap?", agaric, coprin);

        // Start: gills? -> forest?
        Node cepe = new Node("Cèpe de Bordeaux");
        Node forestQuestion = new Node("Does your mushroom grow in a forest?", capInForest, capInMeadow);
        return new Node("Does your mushroom have gills?", forestQuestion, cepe);
    }

    private void choose(boolean answerYes) {
        if (currentNode == null || currentNode.isLeaf()) {
            return;
        }
        currentNode = answerYes ? currentNode.yesBranch : currentNode.noBranch;
        if (!currentNode.isLeaf()) {
            questionNumber++;
        }
        renderNode();
    }

    private void restart() {
        currentNode = root;
        questionNumber = 1;
        renderNode();
    }

    private void renderNode() {
        if (currentNode.isLeaf()) {
            stepBadgeLabel.setText("MATCH FOUND");
            stepBadgeLabel.setForeground(new Color(27, 94, 32));
            promptLabel.setText("<html><center>Your mushroom is: " + currentNode.result + "</center></html>");
            promptLabel.setForeground(new Color(27, 94, 32));
            yesButton.setVisible(false);
            noButton.setVisible(false);
            restartButton.setVisible(true);
        } else {
            stepBadgeLabel.setText("QUESTION " + questionNumber);
            stepBadgeLabel.setForeground(new Color(33, 78, 120));
            promptLabel.setText("<html><center>" + questionNumber + ". " + currentNode.question + "</center></html>");
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
