1. Import Statements
import javax.swing.*; import java.awt.*;
javax.swing.* provides GUI components such as buttons, labels and windows. java.awt.* provides layouts, colors and fonts.
2. Class Declaration
public class MainMenu extends JFrame {
Creates the MainMenu class. JFrame allows it to create an application window.
3. Variables

CardLayout – switches between screens.

JPanel – holds GUI components.

JLabel – displays text and results.

JButton – creates clickable buttons.

JTextField – accepts user input.

Mushroom and TimeManager – connect the GUI to separate logic classes.
4. Constructor
public MainMenu()
Initializes the application window, sets its size, title and position, creates the screens and displays the main menu.
5. Main Menu Method
private JPanel createMenu()
Creates the main menu with three buttons: Mushroom – opens mushroom identification; Time Manager – opens the time manager; Exit – closes the application.
6. Mushroom GUI
private JPanel createMushroom()
Creates the mushroom identification screen using labels and YES/NO buttons. The Back button returns to the main menu.
7. Answer Method
private void answerMushroom(boolean answer)
Sends the user's answer to the separate Mushroom class and displays the next question or final result.
8. Reset Method
private void resetMushroom()
Restarts the mushroom identification process and enables the YES/NO buttons.
9. Time Manager GUI
private JPanel createTimeManager()
Creates a screen with starting-time and ending-time text fields, a Calculate button and a result label.
10. Calculate Method
private void calculateTime()
Reads the entered times, sends them to the TimeManager class and displays the result. It also handles invalid input.
11. Main Method
public static void main(String[] args)
Starts the application using SwingUtilities.invokeLater().
12. Java Concepts Used
Classes and objects, inheritance, variables and methods, constructors, event handling, exception handling, Java Swing, layout managers and CardLayout.
Conclusion
The MainMenu.java program provides a graphical interface for two problems: Mushroom Identification and Time Manager. It uses Java Swing for the interface and separate classes for problem-solving logic.
