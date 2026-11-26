import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FeaturePanels {

    // 2nd Interface: Bicycle Rental + Calculate + Cancel (back to 1st interface)
    public static JPanel createBicycleRentalPanel(final Main appFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Bicycle Rental");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setBounds(30, 15, 200, 25);
        panel.add(lblTitle);

        JLabel lblStart = new JLabel("StartTime");
        lblStart.setBounds(30, 55, 90, 25);
        panel.add(lblStart);

        final JTextField startTimeField = new JTextField("8");
        startTimeField.setBounds(130, 55, 130, 25);
        panel.add(startTimeField);

        JLabel lblEnd = new JLabel("EndTime");
        lblEnd.setBounds(30, 90, 90, 25);
        panel.add(lblEnd);

        final JTextField endTimeField = new JTextField("17");
        endTimeField.setBounds(130, 90, 130, 25);
        panel.add(endTimeField);

        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(30, 125, 90, 25);
        panel.add(lblTotal);

        final JTextField totalField = new JTextField();
        totalField.setBounds(130, 125, 130, 25);
        totalField.setEditable(false);
        panel.add(totalField);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(65, 180, 115, 32);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int startTime = Integer.parseInt(startTimeField.getText().trim());
                    int endTime = Integer.parseInt(endTimeField.getText().trim());
                    int total = 0;
                    int rate;

                    for (int hour = startTime; hour < endTime; hour++) {
                        if (hour < 7 || hour >= 21) {
                            rate = 500;
                        } else if (hour < 14 || hour >= 19) {
                            rate = 1000;
                        } else {
                            rate = 1500;
                        }
                        total = total + rate;
                    }

                    totalField.setText(total + " RWF");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        appFrame,
                        "Please enter valid integer hours (e.g. StartTime: 8, EndTime: 17).",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        panel.add(btnCalculate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 180, 115, 32);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalField.setText("");
                appFrame.showScreen(Main.SCREEN_WELCOME);
            }
        });
        panel.add(btnCancel);

        return panel;
    }

    // 3rd Interface: Mushroom Identification + Cancel (back to 1st interface)
    public static JPanel createMushroomPanel(final Main appFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Mushroom");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setBounds(30, 12, 200, 25);
        panel.add(lblTitle);

        String[] yesNo = {"yes", "no"};

        JLabel lblGills = new JLabel("Has gills?");
        lblGills.setBounds(30, 48, 150, 25);
        panel.add(lblGills);

        final JComboBox<String> gillsBox = new JComboBox<>(yesNo);
        gillsBox.setBounds(190, 48, 90, 25);
        panel.add(gillsBox);

        JLabel lblForest = new JLabel("Grows in forest?");
        lblForest.setBounds(30, 80, 150, 25);
        panel.add(lblForest);

        final JComboBox<String> forestBox = new JComboBox<>(yesNo);
        forestBox.setBounds(190, 80, 90, 25);
        panel.add(forestBox);

        final JLabel cupOrRingLabel = new JLabel("Has a ring?");
        cupOrRingLabel.setBounds(30, 112, 150, 25);
        panel.add(cupOrRingLabel);

        final JComboBox<String> cupOrRingBox = new JComboBox<>(yesNo);
        cupOrRingBox.setBounds(190, 112, 90, 25);
        panel.add(cupOrRingBox);

        ActionListener branchUpdater = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasGills = "yes".equals(gillsBox.getSelectedItem());
                boolean inForest = "yes".equals(forestBox.getSelectedItem());

                if (!hasGills) {
                    forestBox.setEnabled(false);
                    cupOrRingLabel.setText("N/A (No gills)");
                    cupOrRingBox.setEnabled(false);
                } else {
                    forestBox.setEnabled(true);
                    cupOrRingBox.setEnabled(true);
                    if (!inForest) {
                        cupOrRingLabel.setText("Has a convex cup?");
                    } else {
                        cupOrRingLabel.setText("Has a ring?");
                    }
                }
            }
        };
        gillsBox.addActionListener(branchUpdater);
        forestBox.addActionListener(branchUpdater);
        branchUpdater.actionPerformed(null);

        final JLabel mushroomResultLabel = new JLabel("Result: ");
        mushroomResultLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        mushroomResultLabel.setBounds(30, 148, 360, 25);
        panel.add(mushroomResultLabel);

        JButton btnIdentify = new JButton("Identify");
        btnIdentify.setBounds(65, 200, 115, 32);
        btnIdentify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gills = (String) gillsBox.getSelectedItem();
                String forest = (String) forestBox.getSelectedItem();
                String thirdAnswer = (String) cupOrRingBox.getSelectedItem();

                String mushroomName;
                if ("no".equals(gills)) {
                    mushroomName = "Cepe de Bordeaux";
                } else {
                    if ("no".equals(forest)) {
                        if ("yes".equals(thirdAnswer)) {
                            mushroomName = "Agaric Jaunissant";
                        } else {
                            mushroomName = "Coprin chevelu";
                        }
                    } else {
                        if ("yes".equals(thirdAnswer)) {
                            mushroomName = "Amanite tue-mouche";
                        } else {
                            mushroomName = "Unknown (no ring in forest)";
                        }
                    }
                }

                mushroomResultLabel.setText("Your mushroom is " + mushroomName + ".");
            }
        });
        panel.add(btnIdentify);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 200, 115, 32);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mushroomResultLabel.setText("Result: ");
                appFrame.showScreen(Main.SCREEN_WELCOME);
            }
        });
        panel.add(btnCancel);

        return panel;
    }
}
