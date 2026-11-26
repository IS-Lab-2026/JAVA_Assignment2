import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private CardLayout layout = new CardLayout();
    private JPanel screens = new JPanel(layout);

    public App() {
        setTitle("App");
        setSize(450, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        screens.add(welcomeScreen(), "Welcome");
        screens.add(bicycleScreen(), "Bicycle");
        screens.add(mushroomScreen(), "Mushroom");

        add(screens);
    }

    private JPanel welcomeScreen() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 60, 25, 60));

        JLabel title = new JLabel("Welcome", SwingConstants.CENTER);
        JButton bikeBtn = new JButton("Bicycle rental");
        JButton mushroomBtn = new JButton("Mushroom");
        JButton exitBtn = new JButton("Exit");

        bikeBtn.addActionListener(e -> layout.show(screens, "Bicycle"));
        mushroomBtn.addActionListener(e -> layout.show(screens, "Mushroom"));
        exitBtn.addActionListener(e -> System.exit(0));

        panel.add(title);
        panel.add(bikeBtn);
        panel.add(mushroomBtn);
        panel.add(exitBtn);
        return panel;
    }

    private JPanel bicycleScreen() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JTextField startField = new JTextField();
        JTextField endField = new JTextField();
        JButton calcBtn = new JButton("Calculate");
        JButton cancelBtn = new JButton("Cancel");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        calcBtn.addActionListener(e -> {
            try {
                int start = Integer.parseInt(startField.getText().trim());
                int end = Integer.parseInt(endField.getText().trim());
                resultField.setText(BicycleRental.getRent(start, end));
            } catch (NumberFormatException ex) {
                resultField.setText("Enter valid numbers.");
            }
        });

        cancelBtn.addActionListener(e -> {
            startField.setText("");
            endField.setText("");
            resultField.setText("");
            layout.show(screens, "Welcome");
        });

        panel.add(new JLabel("Start time:"));
        panel.add(startField);
        panel.add(new JLabel("End time:"));
        panel.add(endField);
        panel.add(calcBtn);
        panel.add(cancelBtn);
        panel.add(resultLabel);
        panel.add(resultField);
        return panel;
    }

    private JPanel mushroomScreen() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 6, 6));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        String[] opts = {"yes", "no"};
        JComboBox<String> ringBox = new JComboBox<>(opts);
        JComboBox<String> forestBox = new JComboBox<>(opts);
        JComboBox<String> gillsBox = new JComboBox<>(opts);
        JComboBox<String> cupBox = new JComboBox<>(opts);

        JButton guessBtn = new JButton("Guess");
        JButton cancelBtn = new JButton("Cancel");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        guessBtn.addActionListener(e -> {
            String res = MushroomGuesser.guess(
                ringBox.getSelectedItem().toString(),
                forestBox.getSelectedItem().toString(),
                gillsBox.getSelectedItem().toString(),
                cupBox.getSelectedItem().toString()
            );
            resultField.setText(res);
        });

        cancelBtn.addActionListener(e -> {
            resultField.setText("");
            layout.show(screens, "Welcome");
        });

        panel.add(new JLabel("Ring (yes/no):"));
        panel.add(ringBox);
        panel.add(new JLabel("Forest (yes/no):"));
        panel.add(forestBox);
        panel.add(new JLabel("Gills (yes/no):"));
        panel.add(gillsBox);
        panel.add(new JLabel("Convex cup (yes/no):"));
        panel.add(cupBox);
        panel.add(guessBtn);
        panel.add(cancelBtn);
        panel.add(new JLabel("Result:"));
        panel.add(resultField);
        return panel;
    }

    public static void main(String[] args) {
        new App().setVisible(true);
    }
  }
            
