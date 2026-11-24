package com.mycompany.mush_giu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author alain
 */
public class Mushroom extends JFrame {

    private int questionNumber = 1;
    private int branchStep = 0;
    private boolean hasRing;
    private boolean hasGills;

    private final JLabel lblQuestion;
    private final JLabel lblResult;
    private final JRadioButton rbYes;
    private final JRadioButton rbNo;
    private final ButtonGroup groupAnswers;
    private final JButton btnNext;
    private final JButton btnReset;
    private final JButton btnReturn;

    public Mushroom() {
        super("Mushroom Identification");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500, 380);
        setLocationRelativeTo(null);

        JPanel outerPanel = new JPanel(new BorderLayout(0, 12));
        outerPanel.setBackground(new Color(245, 246, 248));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(12, 16, 14, 16));

        // 1. Top green banner
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(46, 125, 50));
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(27, 94, 32), 2, true),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));

        JLabel lblTitle = new JLabel("MUSHROOM IDENTIFICATION SYSTEM", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle, BorderLayout.CENTER);

        outerPanel.add(headerPanel, BorderLayout.NORTH);

        // Center stack: Question card + Result box
        JPanel centerStack = new JPanel(new BorderLayout(0, 12));
        centerStack.setOpaque(false);

        // 2. Question card
        JPanel questionCard = new JPanel(new GridBagLayout());
        questionCard.setBackground(new Color(220, 237, 200));
        questionCard.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(139, 195, 74), 1, true),
            BorderFactory.createEmptyBorder(14, 16, 14, 16)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 12, 0);

        lblQuestion = new JLabel("1. Does your mushroom have a ring ?", SwingConstants.CENTER);
        lblQuestion.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblQuestion.setForeground(new Color(25, 25, 25));
        questionCard.add(lblQuestion, gbc);

        rbYes = new JRadioButton("Yes");
        rbNo = new JRadioButton("No");
        rbYes.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbNo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        rbYes.setOpaque(false);
        rbNo.setOpaque(false);

        groupAnswers = new ButtonGroup();
        groupAnswers.add(rbYes);
        groupAnswers.add(rbNo);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 8, 28);
        questionCard.add(rbYes, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 0, 8, 0);
        questionCard.add(rbNo, gbc);

        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNext.setBackground(new Color(33, 150, 243));
        btnNext.setForeground(Color.WHITE);
        btnNext.setFocusPainted(false);
        btnNext.setPreferredSize(new Dimension(75, 28));
        btnNext.addActionListener(e -> handleNext());

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(4, 0, 0, 0);
        questionCard.add(btnNext, gbc);

        centerStack.add(questionCard, BorderLayout.CENTER);

        // 3. Result box
        JPanel resultCard = new JPanel(new BorderLayout());
        resultCard.setBackground(new Color(224, 215, 245));
        resultCard.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(149, 117, 205), 1, true),
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));

        lblResult = new JLabel(
            "<html><center>Result:<br/>Think of: Agaric jaunissant, Amanite tue-mouche, Cepe de Bordeaux,<br/>Coprin chevelu, Girolle, or Pied bleu</center></html>",
            SwingConstants.CENTER
        );
        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblResult.setForeground(new Color(74, 20, 140));
        resultCard.add(lblResult, BorderLayout.CENTER);

        centerStack.add(resultCard, BorderLayout.SOUTH);
        outerPanel.add(centerStack, BorderLayout.CENTER);

        // 4. Bottom Reset & Return buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 2));
        bottomPanel.setOpaque(false);

        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReset.setBackground(new Color(123, 31, 162));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFocusPainted(false);
        btnReset.setPreferredSize(new Dimension(95, 32));
        btnReset.addActionListener(e -> resetQuiz());

        btnReturn = new JButton("Return");
        btnReturn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReturn.setBackground(new Color(229, 115, 115));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFocusPainted(false);
        btnReturn.setPreferredSize(new Dimension(95, 32));
        btnReturn.addActionListener(e -> {
            new page().setVisible(true);
            dispose();
        });

        bottomPanel.add(btnReset);
        bottomPanel.add(btnReturn);
        outerPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(outerPanel);
        resetQuiz();
    }

    private void resetQuiz() {
        questionNumber = 1;
        branchStep = 0;
        hasRing = false;
        hasGills = false;
        groupAnswers.clearSelection();
        btnNext.setEnabled(true);
        rbYes.setEnabled(true);
        rbNo.setEnabled(true);
        lblQuestion.setText(questionNumber + ". Does your mushroom have a ring ?");
        lblResult.setText(
            "<html><center>Result:<br/>1. Agaric jaunissant &nbsp; 2. Amanite tue-mouche &nbsp; 3. Cepe de Bordeaux<br/>"
            + "4. Coprin chevelu &nbsp; 5. Girolle &nbsp; 6. Pied bleu</center></html>"
        );
    }

    private void handleNext() {
        if (!rbYes.isSelected() && !rbNo.isSelected()) {
            JOptionPane.showMessageDialog(
                this,
                "Please select Yes or No.",
                "Selection Required",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        boolean answer = rbYes.isSelected();
        groupAnswers.clearSelection();
        questionNumber++;

        switch (branchStep) {
            case 0:
                hasRing = answer;
                if (hasRing) {
                    branchStep = 1;
                    lblQuestion.setText(questionNumber + ". Does your mushroom have gills ?");
                } else {
                    branchStep = 2;
                    lblQuestion.setText(questionNumber + ". Does your mushroom grow in a forest ?");
                }
                break;

            case 1:
                hasGills = answer;
                if (!hasGills) {
                    showFinalResult("Cepe de Bordeaux");
                } else {
                    branchStep = 3;
                    lblQuestion.setText(questionNumber + ". Does your mushroom grow in a forest ?");
                }
                break;

            case 2:
                if (!answer) {
                    showFinalResult("Coprin chevelu");
                } else {
                    branchStep = 4;
                    lblQuestion.setText(questionNumber + ". Does your mushroom have a convex cup ?");
                }
                break;

            case 3:
                showFinalResult(answer ? "Amanite tue-mouche" : "Agaric jaunissant");
                break;

            case 4:
                showFinalResult(answer ? "Pied bleu" : "Girolle");
                break;
        }
    }

    private void showFinalResult(String mushroomName) {
        lblResult.setText("<html><center>Result:<br/>Your mushroom is " + mushroomName + ".</center></html>");
        btnNext.setEnabled(false);
        rbYes.setEnabled(false);
        rbNo.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Mushroom().setVisible(true));
    }

    void setVisible(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
