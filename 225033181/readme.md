# Java Swing GUI Projects

A collection of beginner-friendly Java desktop applications built with **Java Swing**.  
The projects demonstrate graphical user interface design, event handling, input validation, and basic decision-making logic.

## Projects

- [Bicycle Rental System](#-bicycle-rental-system)
- [Mushroom Identifier](#-mushroom-identifier)

---

##  Bicycle Rental System

A desktop application that calculates the rental cost of a bicycle based on the selected start and end hours.

### Features

- Enter a rental start time and end time.
- Validate that the entered hours are within the accepted range.
- Calculate the rental cost using different hourly rates.
- Display the total payment in RWF.
- Cancel the rental screen and return to the welcome screen.

### Hourly Pricing

| Time period | Rate per hour |
|---|---:|
| 00:00–07:00 | 500 RWF |
| 07:00–14:00 | 1,000 RWF |
| 14:00–19:00 | 1,500 RWF |
| 19:00–21:00 | 1,000 RWF |
| 21:00–24:00 | 500 RWF |

The application calculates the cost one hour at a time. If a rental crosses more than one pricing period, each hour is charged at the rate for that period.

### Input Validation

- Start time must be from `0` to `23`.
- End time must be from `1` to `24`.
- Start time must be earlier than end time.
- Non-numeric input displays an error message.

### Main Java Concepts

- `JFrame`, `JLabel`, `JTextField`, and `JButton`
- `ActionListener` event handling
- `Integer.parseInt()` for converting input
- `try-catch` for handling invalid numeric input
- `if-else` statements and `for` loops
- `JOptionPane` for displaying error messages

---

##  Mushroom Identifier

A Java Swing application that uses a set of Yes/No questions to identify a mushroom from a small predefined set of outcomes.

### Questions

The interface asks the user questions about the mushroom, including:

1. Does it have gills?
2. Does it grow in a forest?
3. Does it have a convex cup?
4. Does it have a ring?

The user selects answers using radio buttons and clicks the **Action** button to display the result.

### Possible Results

Depending on the selected answers, the current program can display:

- Pied bleu
- Cepe de bordeaux
- Coprin chevelu
- Amanite tue-mouche
- Agaric Jaunissant

If the first question has no selected answer, the application displays `Invalid input`.

> **Important:** This application is a simple programming demonstration, not a reliable mushroom safety or identification tool. Never eat a mushroom based on this program's result.

### Main Java Concepts

- `JFrame` for the application window
- `JRadioButton` for Yes/No choices
- `ButtonGroup` for mutually exclusive selections
- `JButton` for triggering the identification logic
- `if-else` statements for decision-making
- `setText()` for displaying the result

---

##  Technologies Used

- **Language:** Java
- **GUI Framework:** Java Swing
- **IDE / GUI Builder:** NetBeans (as indicated by the generated Swing form code)
- **Look and Feel:** Nimbus (when available)

##  How to Run

1. Install a Java Development Kit (JDK).
2. Open the project in NetBeans or another Java IDE that supports Swing.
3. Make sure the source files are in the package:

   ```text
   com.mycompany.gui.maine
   ```

4. Build the project.
5. Run the relevant class:
   - `Bicyclerental` to launch the Bicycle Rental application.
   - `Mushroom` to launch the Mushroom Identifier.

The Mushroom Identifier's cancel button and the Bicycle Rental screen's cancel button expect a `Welcome` class to exist in the same package.

## 📁 Main Source Files

| File | Description |
|---|---|
| `Bicyclerental.java` | Bicycle rental cost calculator GUI |
| `Mushroom.java` | Yes/No mushroom decision application |
| `Welcome.java` | Welcome screen opened by the cancel buttons; required by the applications |

## 📚 Learning Objectives

These projects provide practice with:

- Building desktop interfaces with Java Swing
- Organizing Java classes and packages
- Responding to button clicks
- Reading and validating user input
- Using conditional statements and loops
- Displaying results and error messages

