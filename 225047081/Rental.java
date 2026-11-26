package GUI_IS;

public class Rental extends javax.swing.JFrame {
    private int total;
    private int hours;

    public Rental() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        lbltitle = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        lblstart = new javax.swing.JLabel();
        lblend = new javax.swing.JLabel();
        txtstart = new javax.swing.JTextField();
        txtend = new javax.swing.JTextField();
        Aresult = new javax.swing.JTextArea();
        arearesult = new javax.swing.JScrollPane();
        btncalculate = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        tblprices = new javax.swing.JTable();
        areaprice = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bicycle Rental Services");

        lbltitle.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lbltitle.setText("Bicycle Rental Services");

        lblprice.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblprice.setText("Hourly Price Table");

        lblstart.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblstart.setText("Starting time (0-23)");

        lblend.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblend.setText("Ending time (1-24)");

        tblprices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"00:00 - 07:00 and 21:00 - 24:00", "500 RWF"},
                {"07:00 - 14:00 and 19:00 - 21:00", "1,000 RWF"},
                {"14:00 - 19:00", "1,500 RWF"}
            },
            new String [] {"Rental time", "Price per hour"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tblprices.setRowHeight(25);
        areaprice.setViewportView(tblprices);

        Aresult.setColumns(25);
        Aresult.setRows(5);
        Aresult.setEditable(false);
        arearesult.setViewportView(Aresult);

        btncalculate.setText("Calculate");
        btncalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalculateActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
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
                .addGap(35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltitle)
                    .addComponent(lblprice)
                    .addComponent(areaprice, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblstart)
                            .addComponent(lblend))
                        .addGap(25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtstart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncalculate)
                        .addGap(25)
                        .addComponent(btnclear)
                        .addGap(25)
                        .addComponent(btnexit))
                    .addComponent(arearesult, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25)
                .addComponent(lbltitle)
                .addGap(12)
                .addComponent(lblprice)
                .addGap(8)
                .addComponent(areaprice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstart)
                    .addComponent(txtstart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblend)
                    .addComponent(txtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncalculate)
                    .addComponent(btnclear)
                    .addComponent(btnexit))
                .addGap(15)
                .addComponent(arearesult, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void btncalculateActionPerformed(java.awt.event.ActionEvent evt) {
        int time1;
        int time2;

        try {
            time1 = Integer.parseInt(txtstart.getText().trim());
            time2 = Integer.parseInt(txtend.getText().trim());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Please enter valid whole numbers for both times.",
                "Invalid Input", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (time1 < 0 || time1 > 23) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Starting time must be between 0 and 23.",
                "Invalid Starting Time", javax.swing.JOptionPane.ERROR_MESSAGE);
            txtstart.requestFocus();
            return;
        }

        if (time2 < 1 || time2 > 24) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Ending time must be between 1 and 24.",
                "Invalid Ending Time", javax.swing.JOptionPane.ERROR_MESSAGE);
            txtend.requestFocus();
            return;
        }

        if (time1 >= time2) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Starting time must be less than ending time.",
                "Invalid Rental Period", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        hours = time2 - time1;
        total = 0;

        for (int hour = time1; hour < time2; hour++) {
            if (hour < 7) {
                total = total + 500;
            } else if (hour < 14) {
                total = total + 1000;
            } else if (hour < 19) {
                total = total + 1500;
            } else if (hour < 21) {
                total = total + 1000;
            } else {
                total = total + 500;
            }
        }

        Aresult.setText("RENTAL SUMMARY\n"
            + "------------------------------\n"
            + "Starting time : " + String.format("%02d:00", time1) + "\n"
            + "Ending time   : " + String.format("%02d:00", time2) + "\n"
            + "Total hours   : " + hours + "\n"
            + "Total cost    : " + String.format("%,d", total) + " RWF\n"
            + "------------------------------\n"
            + "Thank you for using our service!");
    }

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {
        txtstart.setText("");
        txtend.setText("");
        Aresult.setText("");
    }

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {
        Welcome back = new Welcome();
        back.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rental().setVisible(true);
            }
        });
    }

    private javax.swing.JTextArea Aresult;
    private javax.swing.JScrollPane arearesult;
    private javax.swing.JScrollPane areaprice;
    private javax.swing.JButton btncalculate;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnexit;
    private javax.swing.JLabel lblend;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblstart;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTable tblprices;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtstart;
}
