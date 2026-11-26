public class MushroomIdentificationForm extends javax.swing.JFrame {
    public MushroomIdentificationForm() {
        initComponents();
        setMinimumSize(new java.awt.Dimension(460, getHeight()));
        setSize(getMinimumSize());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        questionLabel = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        educationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mushroom Identification");
        getContentPane().setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        questionLabel.setText("Does your mushroom have gills?");
        getContentPane().add(questionLabel);

        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(yesButton);

        noButton.setText("No");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });
        getContentPane().add(noButton);

        resetButton.setText("Start again");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton);

        resultLabel.setText(" ");
        getContentPane().add(resultLabel);

        educationLabel.setText("Classroom exercise only. Do not use to judge edibility.");
        getContentPane().add(educationLabel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private enum Question {
        GILLS, FOREST, FIELD_RING, FOREST_RING, CAP
    }

    private Question currentQuestion = Question.GILLS;

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        answer(true);
    }//GEN-LAST:event_yesButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        answer(false);
    }//GEN-LAST:event_noButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        ask(Question.GILLS, "Does your mushroom have gills?");
        resultLabel.setText(" ");
        yesButton.setEnabled(true);
        noButton.setEnabled(true);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void answer(boolean yes) {
        switch (currentQuestion) {
            case GILLS:
                if (yes) {
                    ask(Question.FOREST, "Does your mushroom grow in a forest?");
                } else {
                    showResult("Cèpe de Bordeaux");
                }
                break;
            case FOREST:
                ask(yes ? Question.FOREST_RING : Question.FIELD_RING,
                        "Does your mushroom have a ring?");
                break;
            case FIELD_RING:
                showResult(yes ? "Agaric jaunissant" : "Coprin chevelu");
                break;
            case FOREST_RING:
                if (yes) {
                    showResult("Amanite tue-mouche");
                } else {
                    ask(Question.CAP, "Does your mushroom have a convex cap?");
                }
                break;
            case CAP:
                showResult(yes ? "Pied bleu" : "Girolle");
                break;
        }
    }

    private void ask(Question question, String text) {
        currentQuestion = question;
        questionLabel.setText(text);
    }

    private void showResult(String mushroom) {
        resultLabel.setText("Exercise result: " + mushroom);
        yesButton.setEnabled(false);
        noButton.setEnabled(false);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MushroomIdentificationForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel questionLabel;
    private javax.swing.JButton yesButton;
    private javax.swing.JButton noButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel educationLabel;
    // End of variables declaration//GEN-END:variables
}
