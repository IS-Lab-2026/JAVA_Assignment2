package com.mycompany.assignment2;

import javax.swing.JOptionPane;

public class Mushroom extends javax.swing.JFrame {

    public Mushroom() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public static String identifyMushroom(Boolean hasRing, Boolean inForest, Boolean hasConvexCup, Boolean hasGills) {
        if (hasRing == null) {
            return "Please answer question 1 (Ring).";
        }
        if (hasRing) {
            if (inForest == null) {
                return "Please answer question 2 (Forest).";
            }
            if (inForest) {
                return "Amanite tue-mouche";
            } else {
                if (hasConvexCup == null) {
                    return "Please answer question 3 (Convex cup).";
                }
                return hasConvexCup ? "Agaric Jaunissant" : "Coprin chevelu";
            }
        } else {
            if (hasGills == null) {
                return "Please answer question 4 (Gills).";
            }
            if (hasGills) {
                if (hasConvexCup == null) {
                    return "Please answer question 3 (Convex cup).";
                }
                return hasConvexCup ? "Pied bleu" : "Girolle";
            } else {
                return "Cepe de bordeaux";
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgRing = new javax.swing.ButtonGroup();
        bgForest = new javax.swing.ButtonGroup();
        bgConvex = new javax.swing.ButtonGroup();
        bgGills = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblRing = new javax.swing.JLabel();
        rbRingYes = new javax.swing.JRadioButton();
        rbRingNo = new javax.swing.JRadioButton();
        lblForest = new javax.swing.JLabel();
        rbForestYes = new javax.swing.JRadioButton();
        rbForestNo = new javax.swing.JRadioButton();
        lblConvex = new javax.swing.JLabel();
        rbConvexYes = new javax.swing.JRadioButton();
        rbConvexNo = new javax.swing.JRadioButton();
        lblGills = new javax.swing.JLabel();
        rbGillsYes = new javax.swing.JRadioButton();
        rbGillsNo = new javax.swing.JRadioButton();
        lblResult = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        btnExecute = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mushroom Identification");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Mushroom Identification");

        lblRing.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRing.setText("Does your mushroom have a ring?");

        bgRing.add(rbRingYes);
        rbRingYes.setText("Yes");

        bgRing.add(rbRingNo);
        rbRingNo.setText("No");

        lblForest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblForest.setText("Does your mushroom grow in forest?");

        bgForest.add(rbForestYes);
        rbForestYes.setText("Yes");

        bgForest.add(rbForestNo);
        rbForestNo.setText("No");

        lblConvex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblConvex.setText("Does your mushroom have a convex cup?");

        bgConvex.add(rbConvexYes);
        rbConvexYes.setText("Yes");

        bgConvex.add(rbConvexNo);
        rbConvexNo.setText("No");

        lblGills.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGills.setText("Does your mushroom have gills?");

        bgGills.add(rbGillsYes);
        rbGillsYes.setText("Yes");

        bgGills.add(rbGillsNo);
        rbGillsNo.setText("No");

        lblResult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblResult.setText("Mushroom name:");

        txtResult.setEditable(false);

        btnExecute.setText("Execute");
        btnExecute.addActionListener(this::btnExecuteActionPerformed);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRing)
                            .addComponent(lblForest)
                            .addComponent(lblConvex)
                            .addComponent(lblGills)
                            .addComponent(lblResult))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbRingYes)
                                .addGap(15, 15, 15)
                                .addComponent(rbRingNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbForestYes)
                                .addGap(15, 15, 15)
                                .addComponent(rbForestNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbConvexYes)
                                .addGap(15, 15, 15)
                                .addComponent(rbConvexNo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbGillsYes)
                                .addGap(15, 15, 15)
                                .addComponent(rbGillsNo))
                            .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnExecute, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRing)
                    .addComponent(rbRingYes)
                    .addComponent(rbRingNo))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblForest)
                    .addComponent(rbForestYes)
                    .addComponent(rbForestNo))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConvex)
                    .addComponent(rbConvexYes)
                    .addComponent(rbConvexNo))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGills)
                    .addComponent(rbGillsYes)
                    .addComponent(rbGillsNo))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResult)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExecute)
                    .addComponent(btnClear)
                    .addComponent(btnCancel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
        Boolean hasRing = rbRingYes.isSelected() ? true : (rbRingNo.isSelected() ? false : null);
        Boolean inForest = rbForestYes.isSelected() ? true : (rbForestNo.isSelected() ? false : null);
        Boolean hasConvexCup = rbConvexYes.isSelected() ? true : (rbConvexNo.isSelected() ? false : null);
        Boolean hasGills = rbGillsYes.isSelected() ? true : (rbGillsNo.isSelected() ? false : null);

        if (hasRing == null) {
            JOptionPane.showMessageDialog(this, "Please answer question 1 (Ring).", "Warning", JOptionPane.WARNING_MESSAGE);
            txtResult.setText("Invalid input");
            return;
        }

        String result = identifyMushroom(hasRing, inForest, hasConvexCup, hasGills);
        if (result.startsWith("Please answer")) {
            JOptionPane.showMessageDialog(this, result, "Warning", JOptionPane.WARNING_MESSAGE);
            txtResult.setText("Invalid input");
        } else {
            txtResult.setText(result);
        }
    }//GEN-LAST:event_btnExecuteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        bgRing.clearSelection();
        bgForest.clearSelection();
        bgConvex.clearSelection();
        bgGills.clearSelection();
        txtResult.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Welcome welcome = new Welcome();
        welcome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Mushroom().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgConvex;
    private javax.swing.ButtonGroup bgForest;
    private javax.swing.ButtonGroup bgGills;
    private javax.swing.ButtonGroup bgRing;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExecute;
    private javax.swing.JLabel lblConvex;
    private javax.swing.JLabel lblForest;
    private javax.swing.JLabel lblGills;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblRing;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rbConvexNo;
    private javax.swing.JRadioButton rbConvexYes;
    private javax.swing.JRadioButton rbForestNo;
    private javax.swing.JRadioButton rbForestYes;
    private javax.swing.JRadioButton rbGillsNo;
    private javax.swing.JRadioButton rbGillsYes;
    private javax.swing.JRadioButton rbRingNo;
    private javax.swing.JRadioButton rbRingYes;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
