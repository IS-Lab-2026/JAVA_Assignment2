package Welcome;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {

    public Welcome() {
        setTitle("Welcome");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("WELCOME");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(heading, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(3, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 60, 40, 60));

        JButton bicycleButton = new JButton("Bicyclerental");
        JButton mushroomButton = new JButton("Mushroom");
        JButton exitButton = new JButton("Exit");

        styleButton(bicycleButton, new Color(33, 150, 243));
        styleButton(mushroomButton, new Color(46, 125, 50));
        styleButton(exitButton, new Color(211, 47, 47));

        panel.add(bicycleButton);
        panel.add(mushroomButton);
        panel.add(exitButton);
        add(panel, BorderLayout.CENTER);

        bicycleButton.addActionListener(e -> {
            setVisible(false);
            new BicycleRental(this);
        });

        mushroomButton.addActionListener(e -> {
            setVisible(false);
            new Mushroom(this);
        });

        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit the system?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Welcome());
    }
}