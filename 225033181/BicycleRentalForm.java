package com.mycompany.gui_mains;

/** Bicycle Rental JFrame, connected to the uploaded BicycleRental algorithm. */
public class BicycleRentalForm extends javax.swing.JFrame {

    public BicycleRentalForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        txtStartTime = new javax.swing.JTextField();
        txtEndTime = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        lblRates = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bicycle Rental");
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblTitle.setText("Bicycle Rental");
        lblStart.setText("Starting time (0-23):");
        lblEnd.setText("Ending time (1-24):");

        btnCalculate.setText("Calculate Rent");
        btnCalculate.addActionListener(evt -> btnCalculateActionPerformed(evt));
        txtEndTime.addActionListener(evt -> btnCalculateActionPerformed(evt));

        lblResult.setText("Result:");
        txtResult.setEditable(false);
        txtResult.setFocusable(false);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(evt -> btnCancelActionPerformed(evt));

        lblRates.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblRates.setText("Hourly rates: 500 RWF (0-7, 21-24) | 1,000 RWF (7-14, 19-21) | 1,500 RWF (14-19)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStart, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblRates, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStart)
                    .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnd)
                    .addComponent(txtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResult)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblRates)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        try {
            int startTime = Integer.parseInt(txtStartTime.getText().trim());
            int endTime = Integer.parseInt(txtEndTime.getText().trim());
            int total = BicycleRental.calculateRent(startTime, endTime);
            txtResult.setText(total + " RWF");
        } catch (NumberFormatException ex) {
            txtResult.setText("");
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Please enter whole-number hours for both times.",
                    "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException ex) {
            txtResult.setText("");
            javax.swing.JOptionPane.showMessageDialog(this,
                    ex.getMessage(), "Invalid Hours", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new GUI_mains().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new BicycleRentalForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblRates;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtEndTime;
    private javax.swing.JTextField txtResult;
    private javax.swing.JTextField txtStartTime;
    // End of variables declaration//GEN-END:variables
}
