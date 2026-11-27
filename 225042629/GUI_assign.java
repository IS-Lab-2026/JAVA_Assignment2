package com.mycompany.gui_assign;

import javax.swing.SwingUtilities;

public class GUI_assign {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
        });
    }
}
