import javax.swing.*;
import java.awt.*;

public class HomeGUI extends JFrame {

    public HomeGUI() {
        setTitle("Java Swing Utility Suite - Home");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(246, 248, 250));

        Font titleFont = new Font("SansSerif", Font.BOLD, 34);
        Font descFont = new Font("SansSerif", Font.PLAIN, 20);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 22);

        JLabel titleLabel = new JLabel("Java Swing Mini-Apps Hub", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(24, 32, 42));
        titleLabel.setBounds(50, 55, 1100, 48);
        add(titleLabel);

        JLabel descLabel = new JLabel(
            "<html><center>Choose a tool below: calculate bicycle rental costs in RWF "
            + "or step through an interactive<br>decision tree to identify mushrooms.</center></html>",
            SwingConstants.CENTER
        );
        descLabel.setFont(descFont);
        descLabel.setForeground(new Color(82, 95, 110));
        descLabel.setBounds(100, 115, 1000, 72);
        add(descLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(210, 218, 226));
        separator.setBounds(100, 210, 1000, 2);
        add(separator);

        // Three centered buttons across 1200px width:
        // Bicycle: x=210..450 (240), gap=45, Mushroom: x=495..735 (240), gap=45, Quit: x=780..990 (210)
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

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(buttonFont);
        quitButton.setBackground(new Color(198, 40, 40));
        quitButton.setForeground(Color.WHITE);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);
        quitButton.setFocusPainted(false);
        quitButton.setBounds(780, 285, 210, 76);
        add(quitButton);

        bicycleButton.addActionListener(e -> {
            new BicycleRentalGUI().setVisible(true);
            dispose();
        });

        mushroomButton.addActionListener(e -> {
            new MushroomIdentifierGUI().setVisible(true);
            dispose();
        });

        quitButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeGUI().setVisible(true));
    }
}