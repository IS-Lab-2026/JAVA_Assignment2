import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {
    JLabel title, welcome;
    JButton bRent, bMush, bExit;

    public MainMenu() {
        setTitle("GreenWheel Hub - Main Menu");
        setSize(480, 380);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 70, 55));

        title = new JLabel("GreenWheel Hub", SwingConstants.CENTER);
        title.setBounds(40, 25, 400, 45);
        title.setFont(new Font("Georgia", Font.BOLD, 32));
        title.setForeground(new Color(255, 244, 214));
        add(title);

        welcome = new JLabel("Welcome! Pick a tool to begin.", SwingConstants.CENTER);
        welcome.setBounds(40, 80, 400, 30);
        welcome.setFont(new Font("Verdana", Font.PLAIN, 15));
        welcome.setForeground(new Color(200, 230, 210));
        add(welcome);

        bRent = new JButton("Rental System");
        bRent.setBounds(120, 140, 240, 45);
        bRent.setBackground(new Color(255, 190, 70));
        bRent.addActionListener(this);
        add(bRent);

        bMush = new JButton("Mushroom Identifier");
        bMush.setBounds(120, 205, 240, 45);
        bMush.setBackground(new Color(140, 210, 160));
        bMush.addActionListener(this);
        add(bMush);

        bExit = new JButton("Exit");
        bExit.setBounds(120, 270, 240, 45);
        bExit.setBackground(new Color(220, 110, 100));
        bExit.addActionListener(this);
        add(bExit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bRent) {
            new RentalForm();
        }
        if (e.getSource() == bMush) {
            new MushroomForm();
        }
        if (e.getSource() == bExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}