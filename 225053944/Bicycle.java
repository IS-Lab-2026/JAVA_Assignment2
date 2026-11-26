/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bicycle_mushroom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rr
 */

public class Bicycle {
    
    static void velo() {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("Rent Cost Calculator");
        frame.setSize(380, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        // Create labels, text fields, and button
        JLabel startLabel = new JLabel("  Enter starting time:");
        JTextField startField = new JTextField();

        JLabel endLabel = new JLabel("  Enter ending time:");
        JTextField endField = new JTextField();
        
        JButton Back = new JButton("Back");

        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("  Amount to pay: ");
        
        // Add action listener to the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int start = Integer.parseInt(startField.getText().trim());
                    int end = Integer.parseInt(endField.getText().trim());

                    // Your exact validation and calculation logic kept as-is
                    if (start < 0) {
                        resultLabel.setText("  Invalid start time.");
                    } else if (start > 23) {
                        resultLabel.setText("  Invalid start time.");
                    } else if (end < 1) {
                        resultLabel.setText("  Invalid end time.");
                    } else if (end > 24) {
                        resultLabel.setText("  Invalid end time.");
                    } else if (start >= end) {
                        resultLabel.setText("  Start time must be before end time.");
                    } else {
                        int totalCost = 0;
                        int currentHour = start;

                        while (currentHour < end) {

                            if (currentHour >= 0 && currentHour < 7) {
                                totalCost = totalCost + 500;
                            } else if (currentHour >= 21 && currentHour < 24) {
                                totalCost = totalCost + 500;
                            }
                        
                            else if (currentHour >= 7 && currentHour < 14) {
                                totalCost = totalCost + 1000;
                            } else if (currentHour >= 19 && currentHour < 21) {
                                totalCost = totalCost + 1000;
                            }
                            
                            else if (currentHour >= 14 && currentHour < 19) {
                                totalCost = totalCost + 1500;
                            }

                            currentHour = currentHour + 1;
                        }

                        resultLabel.setText("  Total rent cost: " + totalCost + " RWF");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("  Please enter valid whole numbers.");
                }
            }
        });
        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     Bicycle_Mushroom home = new Bicycle_Mushroom();
                     home.setVisible(true);
                     frame.setVisible(false);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("  Please enter valid whole numbers.");
                }
            }
        });
                
                
        // Add components to the frame
        frame.add(startLabel);
        frame.add(startField);
        frame.add(endLabel);
        frame.add(endField);
        frame.add(new JLabel("")); // Empty cell for spacing
        frame.add(Back);
        frame.add(calculateButton);
        frame.add(resultLabel);

        //Center the window on screen and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
       
        }

    private static void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

