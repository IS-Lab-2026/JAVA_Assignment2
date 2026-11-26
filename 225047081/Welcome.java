package GUI_IS;

public class Welcome extends javax.swing.JFrame {
    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        lblwelcome = new javax.swing.JLabel();
        btncontinue = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bicycle Rental Services");

        lblwelcome.setFont(new java.awt.Font("Segoe UI", 0, 30));
        lblwelcome.setText("Welcome to Bicycle Rental");

        btncontinue.setText("Continue");
        btncontinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontinueActionPerformed(evt);
            }
        });

        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45)
                .addComponent(lblwelcome)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                .addGap(80)
                .addComponent(btncontinue, 120, 120, 120)
                .addGap(40)
                .addComponent(btnexit, 120, 120, 120)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70)
                .addComponent(lblwelcome)
                .addGap(65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncontinue, 45, 45, 45)
                    .addComponent(btnexit, 45, 45, 45))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btncontinueActionPerformed(java.awt.event.ActionEvent evt) {
        Rental details = new Rental();
        details.setVisible(true);
        this.setVisible(false);
    }

    private javax.swing.JButton btncontinue;
    private javax.swing.JButton btnexit;
    private javax.swing.JLabel lblwelcome;
}
