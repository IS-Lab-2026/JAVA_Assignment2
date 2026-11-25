public class BicycleRentalForm extends javax.swing.JFrame {
    public BicycleRentalForm() {
        initComponents();
        setMinimumSize(new java.awt.Dimension(460, getHeight()));
        setSize(getMinimumSize());
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        startLabel = new javax.swing.JLabel();
        startField = new javax.swing.JTextField();
        endLabel = new javax.swing.JLabel();
        endField = new javax.swing.JTextField();
        calculateButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        mushroomButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bicycle Rental");
        getContentPane().setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        startLabel.setText("Start time (0–23)");
        getContentPane().add(startLabel);

        startField.setColumns(24);
        getContentPane().add(startField);

        endLabel.setText("End time (1–24)");
        getContentPane().add(endLabel);

        endField.setColumns(24);
        getContentPane().add(endField);

        calculateButton.setText("Calculate cost");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(calculateButton);

        resultLabel.setText("Enter both hours to calculate the cost.");
        getContentPane().add(resultLabel);

        mushroomButton.setText("Open Mushroom Identification");
        mushroomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mushroomButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mushroomButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        try {
            int start = Integer.parseInt(startField.getText().trim());
            int end = Integer.parseInt(endField.getText().trim());
            if (start < 0 || start > 23 || end < 1 || end > 24 || start >= end) {
                resultLabel.setText("Enter valid hours with the start before the end.");
                return;
            }

            int total = 0;
            for (int hour = start; hour < end; hour++) {
                if (hour < 7 || hour >= 21) {
                    total += 500;
                } else if (hour < 14 || hour >= 19) {
                    total += 1000;
                } else {
                    total += 1500;
                }
            }
            resultLabel.setText("Total cost: " + total + " RWF");
        } catch (NumberFormatException exception) {
            resultLabel.setText("Enter whole numbers for both hours.");
        }
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void mushroomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mushroomButtonActionPerformed
        new MushroomIdentificationForm().setVisible(true);
    }//GEN-LAST:event_mushroomButtonActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new BicycleRentalForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel startLabel;
    private javax.swing.JTextField startField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JTextField endField;
    private javax.swing.JButton calculateButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton mushroomButton;
    // End of variables declaration//GEN-END:variables
}
