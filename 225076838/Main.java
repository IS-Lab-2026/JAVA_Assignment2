import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    public static final String SCREEN_WELCOME = "WELCOME";
    public static final String SCREEN_BICYCLE = "BICYCLE_RENTAL";
    public static final String SCREEN_MUSHROOM = "MUSHROOM";

    private CardLayout cardLayout;
    private JPanel mainContainer;

    public Main() {
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
        mainContainer.add(FeaturePanels.createBicycleRentalPanel(this), SCREEN_BICYCLE);
        mainContainer.add(FeaturePanels.createMushroomPanel(this), SCREEN_MUSHROOM);

        add(mainContainer);
        showScreen(SCREEN_WELCOME);
    }

    public void showScreen(String screenName) {
        cardLayout.show(mainContainer, screenName);
    }

    // 1st Interface: Welcome + Bicycle Rental + Mushroom + Exit
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
                showScreen(SCREEN_BICYCLE);
            }
        });
        panel.add(btnBicycle);

        JButton btnMushroom = new JButton("Mushroom");
        btnMushroom.setBounds(215, 95, 130, 35);
        btnMushroom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScreen(SCREEN_MUSHROOM);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main app = new Main();
                app.setVisible(true);
            }
        });
    }
}
