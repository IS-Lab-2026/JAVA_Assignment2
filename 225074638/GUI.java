package com.mycompany.gui;

public class GUI {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Welcome().setVisible(true);
        });
    }
}
