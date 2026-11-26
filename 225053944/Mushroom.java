
package com.mycompany.bicycle_mushroom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Mushroom extends JFrame {

    private enum QuestionKey {
        GILLS("Does the mushroom have gills?"),
        FOREST("Does the mushroom grow in a forest?"),
        CONVEX("Does the mushroom have a convex cup?"),
        RING("Does the mushroom have a ring?");

        final String prompt;

        QuestionKey(String prompt) {
            this.prompt = prompt;
        }
    }

    private record StepRecord(QuestionKey question, boolean answer) {
        String featureDescription() {
            String status = answer ? "Yes" : "No";
            return switch (question) {
                case GILLS -> "Gills: " + status;
                case FOREST -> "Grows in a forest: " + status;
                case CONVEX -> "Convex cup: " + status;
                case RING -> "Has a ring: " + status;
            };
        }
    }

    private final Deque<StepRecord> history = new ArrayDeque<>();
    private QuestionKey currentQuestion = QuestionKey.GILLS;
    private boolean showingResult = false;
    private String identifiedMushroom = null;

    private final JLabel titleLabel = new JLabel("Mushroom Identifier", SwingConstants.CENTER);
    private final JLabel promptLabel = new JLabel("", SwingConstants.CENTER);
    private final JTextArea featuresArea = new JTextArea();
    private final JScrollPane featuresScrollPane = new JScrollPane(featuresArea);

    private final JButton yesButton = new JButton("Yes");
    private final JButton noButton = new JButton("No");
    private final JButton backButton = new JButton("Back");
    private final JButton startAgainButton = new JButton("Start Again");

    private final JPanel answerButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 28, 10));
    private final JPanel resultActionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 28, 10));
    private final JPanel centerCardPanel = new JPanel(new CardLayout());
    private final JPanel bottomCardPanel = new JPanel(new CardLayout());

    public Mushroom() {
        super("Mushroom Identifier - Problem 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 340);
        setMinimumSize(new Dimension(500, 300));
        setLocationRelativeTo(null);

        initComponents();
        refreshView();
    }

    private void initComponents() {
        Color bgColor = new Color(248, 249, 250);
        Color cardBg = Color.WHITE;
        Color primaryText = new Color(33, 37, 41);
        Color yesColor = new Color(33, 37, 41);
        Color noColor = new Color(33, 37, 41);
        Color neutralBtnColor = new Color(108, 117, 125);
        Color restartColor = new Color(13, 110, 253);

        JPanel root = new JPanel(new BorderLayout(0, 18));
        root.setBackground(bgColor);
        root.setBorder(new EmptyBorder(24, 36, 24, 36));
        setContentPane(root);

        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        titleLabel.setForeground(primaryText);
        root.add(titleLabel, BorderLayout.NORTH);

        // Question card
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBackground(cardBg);
        questionPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 215, 220), 2, true),
                new EmptyBorder(30, 28, 30, 28)
        ));

        promptLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        promptLabel.setForeground(primaryText);
        questionPanel.add(promptLabel, BorderLayout.CENTER);

        // Result & features card
        JPanel resultPanel = new JPanel(new BorderLayout(0, 14));
        resultPanel.setBackground(cardBg);
        resultPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 215, 220), 2, true),
                new EmptyBorder(20, 28, 20, 28)
        ));

        featuresArea.setEditable(false);
        featuresArea.setFocusable(false);
        featuresArea.setFont(new Font("SansSerif", Font.PLAIN, 21));
        featuresArea.setForeground(primaryText);
        featuresArea.setBackground(new Color(250, 251, 252));
        featuresArea.setBorder(new EmptyBorder(12, 16, 12, 16));

        featuresScrollPane.setBorder(BorderFactory.createLineBorder(new Color(225, 230, 235), 1));
        resultPanel.add(featuresScrollPane, BorderLayout.CENTER);

        centerCardPanel.setBackground(bgColor);
        centerCardPanel.add(questionPanel, "QUESTION");
        centerCardPanel.add(resultPanel, "RESULT");
        root.add(centerCardPanel, BorderLayout.CENTER);

        // Buttons styling
        styleButton(yesButton, yesColor, new Dimension(70, 42));
        styleButton(noButton, noColor, new Dimension(70, 42));
        styleButton(backButton, neutralBtnColor, new Dimension(140, 42));
        styleButton(startAgainButton, restartColor, new Dimension(150, 42));

        answerButtonsPanel.setBackground(bgColor);
        answerButtonsPanel.add(yesButton);
        answerButtonsPanel.add(noButton);
        answerButtonsPanel.add(backButton);

        resultActionPanel.setBackground(bgColor);
        resultActionPanel.add(startAgainButton);

        bottomCardPanel.setBackground(bgColor);
        bottomCardPanel.add(answerButtonsPanel, "QUESTION");
        bottomCardPanel.add(resultActionPanel, "RESULT");
        root.add(bottomCardPanel, BorderLayout.SOUTH);

        // Actions
        yesButton.addActionListener(e -> handleAnswer(true));
        noButton.addActionListener(e -> handleAnswer(false));
        backButton.addActionListener(e -> handleBack());
        startAgainButton.addActionListener(e -> handleStartAgain());
    }

    private void styleButton(JButton button, Color bg, Dimension size) {
        button.setFont(new Font("SansSerif", Font.BOLD, 22));
        button.setBackground(bg);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setPreferredSize(size);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void handleAnswer(boolean answer) {
        if (showingResult) {
            return;
        }

        history.addLast(new StepRecord(currentQuestion, answer));

        switch (currentQuestion) {
            case GILLS -> {
                if (!answer) {
                    finishIdentification("Cepe de bordeaux");
                } else {
                    currentQuestion = QuestionKey.FOREST;
                }
            }
            case FOREST -> {
                if (!answer) {
                    currentQuestion = QuestionKey.CONVEX;
                } else {
                    currentQuestion = QuestionKey.RING;
                }
            }
            case RING -> {
                if (answer) {
                    finishIdentification("Amanite tue-mouches");
                } else {
                    currentQuestion = QuestionKey.CONVEX;
                }
            }
            case CONVEX -> {
                boolean grewInForest = getAnswerFor(QuestionKey.FOREST);
                if (!grewInForest) {
                    finishIdentification(answer ? "Agaric jaunissant" : "Coprin chevelu");
                } else {
                    finishIdentification(answer ? "Pied bleu" : "Girolle");
                }
            }
        }

        refreshView();
    }

    private boolean getAnswerFor(QuestionKey key) {
        for (StepRecord step : history) {
            if (step.question() == key) {
                return step.answer();
            }
        }
        return false;
    }

    private void finishIdentification(String mushroomName) {
        this.identifiedMushroom = mushroomName;
        this.showingResult = true;
    }

    private void handleBack() {
        if (showingResult) {
            showingResult = false;
            identifiedMushroom = null;
            if (!history.isEmpty()) {
                StepRecord last = history.removeLast();
                currentQuestion = last.question();
            }
            refreshView();
            return;
        }

        if (!history.isEmpty()) {
            StepRecord last = history.removeLast();
            currentQuestion = last.question();
            refreshView();
        } else {
            Bicycle_Mushroom home = new Bicycle_Mushroom();
            home.setVisible(true);
            this.setVisible(false);
            //System.exit(0);
        }
    }

    private void handleStartAgain() {
        history.clear();
        currentQuestion = QuestionKey.GILLS;
        showingResult = false;
        identifiedMushroom = null;
        refreshView();
    }

    private void refreshView() {
        CardLayout centerLayout = (CardLayout) centerCardPanel.getLayout();
        CardLayout bottomLayout = (CardLayout) bottomCardPanel.getLayout();

        if (!showingResult) {
            titleLabel.setText("Question " + (history.size() + 1));
            promptLabel.setText("<html><div style='text-align:center;'>" + currentQuestion.prompt + "</div></html>");
            //backButton.setEnabled(!history.isEmpty());
            centerLayout.show(centerCardPanel, "QUESTION");
            bottomLayout.show(bottomCardPanel, "QUESTION");
        } else {
            titleLabel.setText("Your mushroom is: " + identifiedMushroom);

            StringBuilder sb = new StringBuilder();
            sb.append("Identified Features:\n\n");
            List<StepRecord> steps = new ArrayList<>(history);
            for (StepRecord step : steps) {
                sb.append("• ").append(step.featureDescription()).append("\n");
            }

            featuresArea.setText(sb.toString());
            featuresArea.setCaretPosition(0);

            centerLayout.show(centerCardPanel, "RESULT");
            bottomLayout.show(bottomCardPanel, "RESULT");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mushroom frame = new Mushroom();
            frame.setVisible(true);
        });
    }
}
    

