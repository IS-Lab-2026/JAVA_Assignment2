package com.mycompany.bicyclerentals;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MushroomGUI extends JFrame {

    private JRadioButton ringYes, ringNo;
    private JRadioButton forestYes, forestNo;
    private JRadioButton convexYes, convexNo;
    private JRadioButton gillsYes, gillsNo;
    private ButtonGroup ringGroup, forestGroup, convexGroup, gillsGroup;
    private JTextField resultField;
    private JButton executeButton, clearButton, cancelButton;

    public MushroomGUI() {
        setTitle("Mushroom Identifier");
        setSize(600, 470);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("THIS IS MUSHROOM IDENTIFIER!!");
        title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        title.setBounds(150, 20, 320, 30);
        add(title);

        // Question 1: ring
        addQuestionLabel("Does your mushroom have a ring?", 70);
        ringYes = new JRadioButton("Yes");
        ringNo = new JRadioButton("No");
        ringGroup = addYesNo(ringYes, ringNo, 70);

        // Question 2: forest
        addQuestionLabel("Does your mushroom grow in a forest?", 130);
        forestYes = new JRadioButton("Yes");
        forestNo = new JRadioButton("No");
        forestGroup = addYesNo(forestYes, forestNo, 130);

        // Question 3: convex cup
        addQuestionLabel("Does your mushroom have a convex cup?", 190);
        convexYes = new JRadioButton("Yes");
        convexNo = new JRadioButton("No");
        convexGroup = addYesNo(convexYes, convexNo, 190);

        // Question 4: gills
        addQuestionLabel("Does your mushroom have gills?", 250);
        gillsYes = new JRadioButton("Yes");
        gillsNo = new JRadioButton("No");
        gillsGroup = addYesNo(gillsYes, gillsNo, 250);

        // Result
        JLabel resultLabel = new JLabel("Mushroom name is:");
        resultLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        resultLabel.setBounds(20, 315, 160, 25);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(190, 315, 300, 28);
        resultField.setEditable(false);
        add(resultField);

        // Buttons
        executeButton = new JButton("Execute");
        executeButton.setForeground(new Color(0, 110, 0));
        executeButton.setBounds(50, 375, 110, 32);
        add(executeButton);

        clearButton = new JButton("Clear");
        clearButton.setForeground(new Color(0, 0, 170));
        clearButton.setBounds(240, 375, 110, 32);
        add(clearButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(new Color(150, 0, 0));
        cancelButton.setBounds(430, 375, 110, 32);
        add(cancelButton);

        // When this window closes (Cancel button or X), go back to the Main page
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                new MainGUI().setVisible(true);
            }
        });

        // EXECUTE: read the answers, call the logic object, show the name
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (forestGroup.getSelection() == null || convexGroup.getSelection() == null
                        || ringGroup.getSelection() == null || gillsGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(MushroomGUI.this, "Please answer all the questions!");
                    return;
                }

                boolean forest = forestYes.isSelected();
                boolean convex = convexYes.isSelected();
                boolean ring = ringYes.isSelected();
                boolean gills = gillsYes.isSelected();

                MushroomIdentifier identifier = new MushroomIdentifier();
                String name = identifier.identify(forest, convex, ring, gills);

                resultField.setText(name);
            }
        });

        // CLEAR: remove all answers and the result
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ringGroup.clearSelection();
                forestGroup.clearSelection();
                convexGroup.clearSelection();
                gillsGroup.clearSelection();
                resultField.setText("");
            }
        });

        // CANCEL: close this window, which brings back the Main page
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void addQuestionLabel(String text, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setBounds(20, y, 290, 25);
        add(label);
    }

    // Puts Yes/No in one ButtonGroup so only one can be selected
    private ButtonGroup addYesNo(JRadioButton yes, JRadioButton no, int y) {
        yes.setBounds(340, y, 60, 25);
        no.setBounds(410, y, 60, 25);
        add(yes);
        add(no);
        ButtonGroup group = new ButtonGroup();
        group.add(yes);
        group.add(no);
        return group;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MushroomGUI().setVisible(true);
            }
        });
    }
}
