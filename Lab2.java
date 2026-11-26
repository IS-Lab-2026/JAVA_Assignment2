
package com.mycompany.quitbuttonexample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class Lab2 extends JFrame {

    public Lab2() {

        setTitle("Lab 2 - Mushroom Identification");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));

        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        // Welcome message
        JLabel titleLabel = new JLabel(
            "<html><center>" +
            "<h2>LAB 2 - MUSHROOM IDENTIFICATION</h2>" +
            "Think of one of the six mushroom types.<br>" +
            "Answer the questions truthfully using YES or NO." +
            "</center></html>",
            SwingConstants.CENTER
        );

        mainPanel.add(titleLabel, BorderLayout.CENTER);

        // Buttons
        JButton startButton = new JButton("Start Identification");
        JButton backButton = new JButton("Go back to Lab 1");
        JButton quitButton = new JButton("Quit");

        JPanel buttonPanel = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 15, 10)
        );

        buttonPanel.add(startButton);
        buttonPanel.add(backButton);
        buttonPanel.add(quitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Start mushroom identification
        startButton.addActionListener(e -> identifyMushroom());

        // Go back to Lab 1
        backButton.addActionListener(e -> {
            dispose();
            new Lab1().setVisible(true);
        });

        // Quit application
        quitButton.addActionListener(e -> quitApplication());
    }

    // Method for asking YES or NO questions
    private Boolean askQuestion(String question, int number) {

        int answer = JOptionPane.showConfirmDialog(
            this,
            question,
            "Mushroom Identification - Question " + number,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Return null if the user closes the dialog
        if (answer == JOptionPane.CLOSED_OPTION) {
            return null;
        }

        return answer == JOptionPane.YES_OPTION;
    }

    // Mushroom identification logic
    private void identifyMushroom() {

        int questionsAsked = 0;
        String mushroom;

        // QUESTION 1: Does the mushroom have a ring?
        Boolean hasRing = askQuestion(
            "Does your mushroom have a ring?",
            ++questionsAsked
        );

        if (hasRing == null) {
            showCancelledMessage();
            return;
        }

        if (hasRing) {

            // QUESTION 2: Does the mushroom grow in a forest?
            Boolean growsInForest = askQuestion(
                "Does your mushroom grow in a forest?",
                ++questionsAsked
            );

            if (growsInForest == null) {
                showCancelledMessage();
                return;
            }

            if (growsInForest) {

                mushroom = "AMANITE TUE-MOUCHE";

            } else {

                // QUESTION 3: Does the mushroom have a convex cup?
                Boolean hasConvexCup = askQuestion(
                    "Does your mushroom have a convex cup?",
                    ++questionsAsked
                );

                if (hasConvexCup == null) {
                    showCancelledMessage();
                    return;
                }

                if (hasConvexCup) {
                    mushroom = "AGARIC JAUNISSANT";
                } else {
                    mushroom = "COPRIN CHEVELU";
                }
            }

        } else {

            // QUESTION 2: Does the mushroom have gills?
            Boolean hasGills = askQuestion(
                "Does your mushroom have gills?",
                ++questionsAsked
            );

            if (hasGills == null) {
                showCancelledMessage();
                return;
            }

            if (!hasGills) {

                mushroom = "CEPE DE BORDEAUX";

            } else {

                // QUESTION 3: Does the mushroom have a convex cup?
                Boolean hasConvexCup = askQuestion(
                    "Does your mushroom have a convex cup?",
                    ++questionsAsked
                );

                if (hasConvexCup == null) {
                    showCancelledMessage();
                    return;
                }

                if (hasConvexCup) {
                    mushroom = "PIED BLEU";
                } else {
                    mushroom = "GIROLLE";
                }
            }
        }

        // Display the identified mushroom
        JOptionPane.showMessageDialog(
            this,
            "MUSHROOM IDENTIFIED SUCCESSFULLY!\n\n" +
            "Your mushroom is: " + mushroom +
            "\n\nQuestions asked: " + questionsAsked +
            " out of 4.",
            "Identification Result",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Message displayed when the user cancels
    private void showCancelledMessage() {

        JOptionPane.showMessageDialog(
            this,
            "Mushroom identification was cancelled.\n" +
            "Click Start Identification to try again.",
            "Identification Cancelled",
            JOptionPane.WARNING_MESSAGE
        );
    }

    // Quit application
    private void quitApplication() {

        int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to quit?",
            "Quit Application",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Lab2().setVisible(true);
        });
    }
}
