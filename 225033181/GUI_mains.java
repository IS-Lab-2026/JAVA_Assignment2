package com.mycompany.gui_mains;

/** First window: mirrors the provided hand-drawn navigation diagram. */
public class GUI_mains extends javax.swing.JFrame {

    public GUI_mains() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblWelcome = new javax.swing.JLabel();
        btnBicycle = new javax.swing.JButton();
        btnMushroom = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome - Java GUI Project");
        setResizable(false);

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome");

        btnBicycle.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnBicycle.setText("Bicycle Rental");
        btnBicycle.addActionListener(evt -> btnBicycleActionPerformed(evt));

        btnMushroom.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnMushroom.setText("Mushroom");
        btnMushroom.addActionListener(evt -> btnMushroomActionPerformed(evt));

        btnExit.setText("Exit");
        btnExit.addActionListener(evt -> btnExitActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnBicycle, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnMushroom, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBicycle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMushroom, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBicycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBicycleActionPerformed
        new BicycleRentalForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBicycleActionPerformed

    private void btnMushroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMushroomActionPerformed
        new MushroomForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMushroomActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Use Java's default look and feel when Nimbus is not available.
        }
        java.awt.EventQueue.invokeLater(() -> new GUI_mains().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBicycle;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMushroom;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
