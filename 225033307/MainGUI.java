import javax.swing.SwingUtilities;

/**
 * Main class: run this to start the program.
 * It opens the home page (HomeGUI), where you choose Bicycle, Mushroom or Exit.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeGUI().setVisible(true));
    }
}
