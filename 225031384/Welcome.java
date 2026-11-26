package com.mycompany.gui_assign;

import java.awt.*;
import javax.swing.*;

/** Main menu for the two programs. */
public class Welcome extends JFrame {
    private static final Color INK = new Color(31, 41, 55);
    private static final Color TEAL = new Color(0, 160, 174);

    public Welcome() {
        setTitle("Welcome - Integrated Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 390);
        setMinimumSize(new Dimension(560, 340));
        setLocationRelativeTo(null);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(new Color(248, 250, 252));
        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel heading = new JLabel("WELCOME BACK!", SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 38));
        heading.setForeground(INK);
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton bicycleButton = makeButton("BicycleRental", new Color(125, 130, 138));
        JButton mushroomButton = makeButton("MushroomIdentifier", TEAL);
        JButton exitButton = makeButton("EXIT", new Color(190, 48, 38));
        exitButton.setForeground(Color.WHITE);
        bicycleButton.addActionListener(e -> openForm(new BicycleRental()));
        mushroomButton.addActionListener(e -> openForm(new MushroomIdentification()));
        exitButton.addActionListener(e -> System.exit(0));

        JPanel choices = new JPanel(new GridLayout(1, 2, 14, 0));
        choices.setOpaque(false);
        choices.add(bicycleButton);
        choices.add(mushroomButton);

        content.add(heading);
        content.add(Box.createVerticalStrut(12));
   
        content.add(Box.createVerticalStrut(48));
        content.add(choices);
        content.add(Box.createVerticalStrut(25));
        JPanel exitRow = new JPanel();
        exitRow.setOpaque(false);
        exitRow.add(exitButton);
        content.add(exitRow);
        page.add(content);
        setContentPane(page);
    }

    private JButton makeButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(220, 54));
        return button;
    }

    private void openForm(JFrame form) {
        form.setLocationRelativeTo(this);
        form.setVisible(true);
        dispose();
    }
}
