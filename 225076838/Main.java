import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JavaMultiScreenApp extends JFrame {

    private static final String SCREEN_WELCOME = "WELCOME";
    private static final String SCREEN_BICYCLE = "BICYCLE_RENTAL";
    private static final String SCREEN_MUSHROOM = "MUSHROOM";

    private CardLayout cardLayout;
    private JPanel mainContainer;

    // Bicycle Rental components
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField totalField;

    // Mushroom Identification components
    private JComboBox<String> gillsBox;
    private JComboBox<String> forestBox;
    private JComboBox<String> cupOrRingBox;
    private JLabel cupOrRingLabel;
    private JLabel mushroomResultLabel;

    public JavaMultiScreenApp() {
        initUI();
    }

    private void initUI() {
        setTitle("Java Swing Multi-Screen App");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        mainContainer.add(createWelcomePanel(), SCREEN_WELCOME);
        mainContainer.add(createBicycleRentalPanel(), SCREEN_BICYCLE);
        mainContainer.add(createMushroomPanel(), SCREEN_MUSHROOM);

        add(mainContainer);
        cardLayout.show(mainContainer, SCREEN_WELCOME);
    }

    // 1st Interface: Welcome Screen with Bicycle Rental, Mushroom, and Exit buttons
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblWelcome.setBounds(80, 25, 250, 35);
        panel.add(lblWelcome);

        JButton btnBicycle = new JButton("Bicycle Rental");
        btnBicycle.setBounds(60, 95, 130, 35);
        btnBicycle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainContainer, SCREEN_BICYCLE);
            }
        });
        panel.add(btnBicycle);

        JButton btnMushroom = new JButton("Mushroom");
        btnMushroom.setBounds(215, 95, 130, 35);
        btnMushroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainContainer, SCREEN_MUSHROOM);
            }
        });
        panel.add(btnMushroom);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(145, 165, 115, 35);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnExit);

        return panel;
    }

    // 2nd Interface: Bicycle Rental + Calculate + Cancel (back to 1st interface)
    private JPanel createBicycleRentalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Bicycle Rental");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitle.setBounds(30, 15, 200, 25);
        panel.add(lblTitle);

        JLabel lblStart = new JLabel("StartTime");
        lblStart.setBounds(30, 55, 90, 25);
        panel.add(lblStart);

        startTimeField = new JTextField("8");
        startTimeField.setBounds(130, 55, 130, 25);
        panel.add(startTimeField);

        JLabel lblEnd = new JLabel("EndTime");
        lblEnd.setBounds(30, 90, 90, 25);
        panel.add(lblEnd);

        endTimeField = new JTextField("17");
        endTimeField.setBounds(130, 90, 130, 25);
        panel.add(endTimeField);

        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(30, 125, 90, 25);
        panel.add(lblTotal);

        totalField = new JTextField();
        totalField.setBounds(130, 125, 130, 25);
        totalField.setEditable(false);
        panel.add(totalField);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(65, 180, 115, 32);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateRentalCost();
            }
        });
        panel.add(btnCalculate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 180, 115, 32);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalField.setText("");
                cardLayout.show(mainContainer, SCREEN_WELCOME);
            }
        });
        panel.add(btnCancel);

        return panel;
    }

    private void calculateRentalCost() {
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
                this,
                "Please enter valid integer hours (e.g. StartTime: 8, EndTime: 17).",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // 3rd Interface: Mushroom Identification + Cancel (back to 1st interface)
    private JPanel createMushroomPanel() {
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

        gillsBox = new JComboBox<>(yesNo);
        gillsBox.setBounds(190, 48, 90, 25);
        panel.add(gillsBox);

        JLabel lblForest = new JLabel("Grows in forest?");
        lblForest.setBounds(30, 80, 150, 25);
        panel.add(lblForest);

        forestBox = new JComboBox<>(yesNo);
        forestBox.setBounds(190, 80, 90, 25);
        panel.add(forestBox);

        cupOrRingLabel = new JLabel("Has a ring?");
        cupOrRingLabel.setBounds(30, 112, 150, 25);
        panel.add(cupOrRingLabel);

        cupOrRingBox = new JComboBox<>(yesNo);
        cupOrRingBox.setBounds(190, 112, 90, 25);
        panel.add(cupOrRingBox);

        // Update 3rd question prompt to match MushroomIdentification.java branches
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

        mushroomResultLabel = new JLabel("Result: ");
        mushroomResultLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        mushroomResultLabel.setBounds(30, 148, 360, 25);
        panel.add(mushroomResultLabel);

        JButton btnIdentify = new JButton("Identify");
        btnIdentify.setBounds(65, 200, 115, 32);
        btnIdentify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                identifyMushroom();
            }
        });
        panel.add(btnIdentify);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 200, 115, 32);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mushroomResultLabel.setText("Result: ");
                cardLayout.show(mainContainer, SCREEN_WELCOME);
            }
        });
        panel.add(btnCancel);

        return panel;
    }

    private void identifyMushroom() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JavaMultiScreenApp app = new JavaMultiScreenApp();
                app.setVisible(true);
            }
        });
    }
}