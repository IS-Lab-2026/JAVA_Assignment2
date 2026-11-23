import javax.swing.*;
import java.awt.event.*;

public class MainForm extends JFrame implements ActionListener {

    JLabel welcome = new JLabel("Welcome");
    JButton rentalButton = new JButton("Rental System");
    JButton mushroomButton = new JButton("Mushroom Identifier");
    JButton exitButton = new JButton("Exit");

    public MainForm() {
        setTitle("Form 1");
        setSize(400, 250);
        setLayout(null);

        welcome.setBounds(170, 20, 100, 30);
        rentalButton.setBounds(30, 80, 160, 35);
        mushroomButton.setBounds(200, 80, 170, 35);
        exitButton.setBounds(140, 140, 120, 35);

        add(welcome);
        add(rentalButton);
        add(mushroomButton);
        add(exitButton);

        rentalButton.addActionListener(this);
        mushroomButton.addActionListener(this);
        exitButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rentalButton) {
            new RentalForm();
        }
        if (e.getSource() == mushroomButton) {
            new MushroomForm();
        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MainForm();
    }
}