package com.mycompany.bicyclerentals;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    public MainGUI() {
        setTitle("Main Menu");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("Welcome");
        title.setBounds(130, 30, 120, 30);
        title.setFont(title.getFont().deriveFont(20f));
        add(title);

        JButton mushroomsButton = new JButton("Mushrooms");
        mushroomsButton.setBounds(90, 90, 160, 30);
        add(mushroomsButton);

        JButton rentalButton = new JButton("Bicycle Rent");
        rentalButton.setBounds(90, 135, 160, 30);
        add(rentalButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(90, 180, 160, 30);
        add(exitButton);

        mushroomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MushroomGUI().setVisible(true);   // open the Mushrooms frame
                dispose();                            // close this Main page
            }
        });

        rentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RentalGUI().setVisible(true);     // open the Rental frame
                dispose();                            // close this Main page
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);                       // close the whole program
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
}
