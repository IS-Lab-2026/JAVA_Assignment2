# Java GUI Assignment - 225051971

This directory contains a Java Swing graphical user interface application submitted for the Java GUI assignment. The program provides a welcome screen from which users can open a bicycle rental cost calculator or a mushroom identification tool.

## Files

| File | Description |
|---|---|
| `SchoolGUI.java` | Application entry point. Its `main` method opens the `WelcomeFrame` window. |
| `WelcomeFrame.java` | Main welcome window. It provides buttons for opening the hourly cost calculator or mushroom identifier, and for exiting the application. |
| `bicycleFrame.java` | Bicycle rental cost calculator. It accepts starting and ending hours, validates them, calculates the hourly total based on time-of-day rates, and can clear or return to the welcome screen. |
| `mushroomsFrame.java` | Mushroom identification interface. Users answer questions about forest location, cap shape, gills, and ring presence to identify one of several mushroom types. It also supports clearing selections and returning to the welcome screen. |

## Application Flow

1. Run `SchoolGUI.java` to display the welcome window.
2. Select **Hourly Cost Calculator** to open `bicycleFrame`.
3. Select **Mushroom Identifier** to open `mushroomsFrame`.
4. Use the exit or back buttons to close the current window or return to the welcome screen.

## Requirements

- Java Development Kit (JDK)
- A Java IDE or command-line Java compiler
- Swing support provided by the JDK
