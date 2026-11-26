
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CampusDesk extends JFrame {

    public CampusDesk() {
        setTitle("CampusDesk - Student Utility");
        setSize(500, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(243, 246, 250));

        JLabel title = new JLabel("CampusDesk");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(new Color(20, 40, 62));
        title.setBounds(125, 35, 260, 45);
        add(title);

        JLabel welcome = new JLabel("Welcome! Choose a service below.");
        welcome.setBounds(100, 85, 320, 30);
        add(welcome);

        JButton rentalBtn = new JButton("Bicycle Rental");
        rentalBtn.setBounds(100, 140, 280, 45);
        rentalBtn.setBackground(new Color(27, 153, 139));
        rentalBtn.setForeground(Color.WHITE);
        add(rentalBtn);

        JButton mushroomBtn = new JButton("Mushroom Identifier");
        mushroomBtn.setBounds(100, 205, 280, 45);
        mushroomBtn.setBackground(new Color(27, 153, 139));
        mushroomBtn.setForeground(Color.WHITE);
        add(mushroomBtn);

        JButton projectBtn = new JButton("Student Project Form");
        projectBtn.setBounds(100, 270, 280, 45);
        projectBtn.setBackground(new Color(27, 153, 139));
        projectBtn.setForeground(Color.WHITE);
        add(projectBtn);

        JButton exitBtn = new JButton("Exit CampusDesk");
        exitBtn.setBounds(100, 335, 280, 45);
        exitBtn.setBackground(new Color(20, 40, 62));
        exitBtn.setForeground(Color.WHITE);
        add(exitBtn);

        rentalBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BicycleRental();
            }
        });

        mushroomBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MushroomIdentifier();
            }
        });

        projectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StudentProject();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CampusDesk();
    }
}
