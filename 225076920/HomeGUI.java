import javax.swing.*;
import java.awt.*;

/**
 * Home page: choose the Bicycle program, the Mushroom program, or exit.
 * Run this class to start the application.
 */
public class HomeGUI extends JFrame {

    public HomeGUI() {
        setTitle("Bicycle Rental and Mushroom Identifier - Home");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(246, 248, 250));

        Font titleFont = new Font("SansSerif", Font.BOLD, 34);
        Font descFont = new Font("SansSerif", Font.PLAIN, 20);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 22);

        JLabel titleLabel = new JLabel("Bicycle Rental and Mushroom Identifier", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(24, 32, 42));
        titleLabel.setBounds(50, 55, 1100, 48);
        add(titleLabel);

        JLabel descLabel = new JLabel(
                "<html><center>Choose a program: work out a bicycle rental cost in RWF,"
                        + "<br>or answer Yes / No questions to identify a mushroom.</center></html>",
                SwingConstants.CENTER);
        descLabel.setFont(descFont);
        descLabel.setForeground(new Color(82, 95, 110));
        descLabel.setBounds(100, 115, 1000, 72);
        add(descLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(100, 210, 1000, 2);
        add(separator);

        JButton bicycleButton = new JButton("Bicycle");
        bicycleButton.setFont(buttonFont);
        bicycleButton.setBackground(new Color(25, 118, 210));
        bicycleButton.setForeground(Color.WHITE);
        bicycleButton.setOpaque(true);
        bicycleButton.setBorderPainted(false);
        bicycleButton.setFocusPainted(false);
        bicycleButton.setBounds(210, 285, 240, 76);
        add(bicycleButton);

        JButton mushroomButton = new JButton("Mushroom");
        mushroomButton.setFont(buttonFont);
        mushroomButton.setBackground(new Color(46, 125, 50));
        mushroomButton.setForeground(Color.WHITE);
        mushroomButton.setOpaque(true);
        mushroomButton.setBorderPainted(false);
        mushroomButton.setFocusPainted(false);
        mushroomButton.setBounds(495, 285, 240, 76);
        add(mushroomButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(new Color(198, 40, 40));
        exitButton.setForeground(Color.WHITE);
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setBounds(780, 285, 210, 76);
        add(exitButton);

        // Open the chosen screen and close the home page
        bicycleButton.addActionListener(e -> {
            new BicycleRentalGUI().setVisible(true);
            dispose();
        });

        mushroomButton.addActionListener(e -> {
            new MushroomIdentifierGUI().setVisible(true);
            dispose();
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeGUI().setVisible(true));
    }
}
