public class Welcome extends javax.swing.JFrame {
    public Welcome() {
        initComponents();
        setMinimumSize(new java.awt.Dimension(460, getHeight()));
        setSize(getMinimumSize());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        headingLabel = new javax.swing.JLabel();
        studentLabel = new javax.swing.JLabel();
        bicycleButton = new javax.swing.JButton();
        mushroomButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Java Assignment 2");
        getContentPane().setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        headingLabel.setText("Java Assignment 2");
        getContentPane().add(headingLabel);

        studentLabel.setText("ISHIMWE Divine (225038614)");
        getContentPane().add(studentLabel);

        bicycleButton.setText("Bicycle Rental");
        bicycleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bicycleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(bicycleButton);

        mushroomButton.setText("Mushroom Identification");
        mushroomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mushroomButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mushroomButton);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bicycleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bicycleButtonActionPerformed
        new BicycleRentalForm().setVisible(true);
    }//GEN-LAST:event_bicycleButtonActionPerformed

    private void mushroomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mushroomButtonActionPerformed
        new MushroomIdentificationForm().setVisible(true);
    }//GEN-LAST:event_mushroomButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        for (java.awt.Window window : java.awt.Window.getWindows()) {
            window.dispose();
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Welcome().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headingLabel;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JButton bicycleButton;
    private javax.swing.JButton mushroomButton;
    private javax.swing.JButton exitButton;
    // End of variables declaration//GEN-END:variables
}
