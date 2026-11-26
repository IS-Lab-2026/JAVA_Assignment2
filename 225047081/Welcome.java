package GUI_IS;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {
    public Welcome() { initComponents(); }
    private void initComponents() {
        setTitle("Welcome"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setResizable(false);
        JLabel title = new JLabel("MUSHROOM IDENTIFICATION SYSTEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        JLabel message = new JLabel("Welcome! Press Continue to open the application.", SwingConstants.CENTER);
        JButton continueButton = new JButton("Continue");
        JButton exitButton = new JButton("Exit");
        continueButton.addActionListener(e -> { new Mushroom().setVisible(true); dispose(); });
        exitButton.addActionListener(e -> System.exit(0));
        JPanel buttons = new JPanel(); buttons.add(continueButton); buttons.add(exitButton);
        JPanel panel = new JPanel(new GridLayout(3,1,8,8)); panel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        panel.add(title); panel.add(message); panel.add(buttons); setContentPane(panel);
        pack(); setSize(480,220); setLocationRelativeTo(null);
    }
}
