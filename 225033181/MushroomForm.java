package com.mycompany.gui_mains;

/** Mushroom JFrame: the uploaded guessing game runs as GUI questions. */
public class MushroomForm extends javax.swing.JFrame {

    private static class UserCancelled extends RuntimeException { }

    public MushroomForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblInstructions = new javax.swing.JLabel();
        scrollMushrooms = new javax.swing.JScrollPane();
        areaMushrooms = new javax.swing.JTextArea();
        btnGuess = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mushroom Guessing Game");
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblTitle.setText("Mushroom");
        lblInstructions.setText("Think of one mushroom, then click Guess Mushroom:");

        areaMushrooms.setEditable(false);
        areaMushrooms.setColumns(20);
        areaMushrooms.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        areaMushrooms.setRows(6);
        areaMushrooms.setLineWrap(true);
        areaMushrooms.setWrapStyleWord(true);
        areaMushrooms.setText("1. Agaric Jaunissant\n2. Amanite tue-mouche\n3. Cepe de Bordeaux\n4. Coprin chevelu\n5. Girolle\n6. Pied bleu");
        areaMushrooms.setFocusable(false);
        scrollMushrooms.setViewportView(areaMushrooms);

        btnGuess.setText("Guess Mushroom");
        btnGuess.addActionListener(evt -> btnGuessActionPerformed(evt));

        lblResult.setText("Result:");
        txtResult.setEditable(false);
        txtResult.setFocusable(false);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(evt -> btnCancelActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(scrollMushrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblInstructions)
                .addGap(14, 14, 14)
                .addComponent(scrollMushrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResult)
                    .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuessActionPerformed
        try {
            String mushroom = MushroomGuess.identify(this::askYesNo);
            txtResult.setText(mushroom);
        } catch (UserCancelled ex) {
            txtResult.setText("Guess cancelled");
        }
    }//GEN-LAST:event_btnGuessActionPerformed

    private boolean askYesNo(String question) {
        Boolean answer = new MushroomQuestionDialog(this, true).ask(question);
        if (answer == null) {
            throw new UserCancelled();
        }
        return answer;
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        new GUI_mains().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MushroomForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMushrooms;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGuess;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrollMushrooms;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
