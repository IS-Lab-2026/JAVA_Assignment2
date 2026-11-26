package com.mycompany.quitbuttonexample;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Starter window for the Mushroom identification program.
 *
 * IMPORTANT: The Mushroom code supplied with the request was an exact copy
 * of the Bicycle Rental code. The six mushroom names and their Yes/No
 * characteristics were not included, so the identification decision tree
 * cannot be completed accurately yet.
 */
public class Mushroom extends JFrame {

    public Mushroom() {
        setTitle("Mushroom Identification");
        setSize(550, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel message = new JLabel(
                "Mushroom identification starter",
                SwingConstants.CENTER
        );

        JLabel explanation = new JLabel(
                "Add the six mushroom types and their Yes/No characteristics "
                        + "to complete the identification questions.",
                SwingConstants.CENTER
        );

        JPanel textPanel = new JPanel(new BorderLayout(5, 5));
        textPanel.add(message, BorderLayout.CENTER);
        textPanel.add(explanation, BorderLayout.SOUTH);

        JButton identifyButton = new JButton("Identify Mushroom");
        JButton bicycleButton = new JButton("Back to Bicycle Rental");
        JButton quitButton = new JButton("Quit");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(identifyButton);
        buttonPanel.add(bicycleButton);
        buttonPanel.add(quitButton);

        mainPanel.add(textPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        identifyButton.addActionListener(e -> showMissingIdentificationData());

        bicycleButton.addActionListener(e -> {
            dispose();
            new Bicycle_rental().setVisible(true);
        });

        quitButton.addActionListener(e -> confirmQuit());
    }

    private void showMissingIdentificationData() {
        JOptionPane.showMessageDialog(
                this,
                "The identification questions are not configured yet.\n\n"
                        + "The Mushroom code pasted in the request was the same "
                        + "as the Bicycle Rental code.\n"
                        + "Please add the names of the six mushroom types and "
                        + "the Yes/No characteristics used to distinguish them.",
                "Mushroom Data Needed",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void confirmQuit() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to quit?",
                "Exit Application",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Mushroom().setVisible(true));
    }
}
