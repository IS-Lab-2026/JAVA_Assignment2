# Java Swing Mini Apps (Welcome, Bicycle Rental, Mushroom Identifier)

**Student Registration Number:** 225034054

A Java Swing project with a main page (`MainGUI`) that opens two pop-up apps:

1. **Bicycle Rent**: calculates the cost of renting a bicycle between two hours.
2. **Mushrooms**: a mushroom identifier. The user answers yes/no questions and the program names the mushroom.

The third button, **Exit**, closes the whole program. Inside each app, the **Exit** (rental) and **Cancel** (mushrooms) buttons, or the window's X, take the user back to the main page.

## Project structure

```
src/main/java/com/mycompany/bicyclerentals
├── MainGUI.java             (main page with 3 buttons)
├── RentalGUI.java           (Bicycle rental window)
├── RentalCalculator.java    (logic: rental cost)
├── MushroomGUI.java         (Mushroom identifier window)
├── MushroomIdentifier.java  (logic: which mushroom)
└── BicycleRentals.java      (Lab 1: console version with Scanner)
```

Every app follows the same Object-Oriented design:
- a **GUI class** (the "face"): the window, text boxes, radio buttons and buttons
- a **logic class** (the "brain"): the actual rules, with no windows inside it

The GUI creates an object of the logic class and calls its method.

## How to run

1. Open the project in NetBeans.
2. Right-click `MainGUI.java` and choose **Run File**.
3. Click **Bicycle Rent** or **Mushrooms** to open an app, or **Exit** to quit.
4. Inside an app, **Exit** / **Cancel** returns to the main page.

---

## App 1: Bicycle Rent

Enter a start time (0-23) and an end time (1-24), then click **Calculate**. Click **Exit** to go back to the main page.

| Hours of the day | Price per hour |
|---|---|
| 21:00 - 07:00 (night) | 500 RWF |
| 07:00 - 14:00 and 19:00 - 21:00 | 1000 RWF |
| 14:00 - 19:00 (peak) | 1500 RWF |

Example: start 5, end 9 gives 500 + 500 + 1000 + 1000 = **3000 RWF**.

### RentalCalculator.java
- `calculateTotal(int startTime, int endTime)` loops over every hour from the start up to (but not including) the end.
- For each hour it adds 500, 1000 or 1500 to `totalCost` depending on the time band, then returns `totalCost`.

### RentalGUI.java
- `extends JFrame` makes the class a window. `setLayout(null)` and `setBounds()` place each component by hand.
- The result box uses `setEditable(false)` because only the program should write in it.
- The Calculate button uses an `ActionListener`. When it is clicked, `actionPerformed` runs.
- Inside it, `Integer.parseInt(...getText().trim())` turns the typed text into numbers.
- If the times are invalid, a `JOptionPane` pop-up shows "Invalid Time Range!" and `return` stops the code.
- Otherwise it creates the logic object with `new RentalCalculator()`, calls `calculateTotal(start, end)`, and shows the answer with `resultField.setText(...)`.
- A `try / catch (NumberFormatException)` shows "Please enter valid numbers!" if the user types letters or leaves a box empty.
- The **Exit** button calls `dispose()`, which closes this window. A `WindowListener` with `windowClosed` then opens `new MainGUI()`, so the user is back on the main page (this also works when the X is clicked).
- `setDefaultCloseOperation(DISPOSE_ON_CLOSE)` closes only this window, not the whole program.

---

## App 2: Mushroom Identifier

The window asks four yes/no questions (ring, forest, convex cup, gills). Each question has a **Yes** and a **No** radio button. When the user clicks **Execute**, the mushroom name appears in the "Mushroom name is" box.

| Forest | Convex cup | Ring | Gills | Mushroom |
|---|---|---|---|---|
| No | Yes | - | - | Agaric Jaunissant |
| No | No | - | - | Coprin chevelu |
| Yes | Yes | Yes | - | Amanite tue-mouche |
| Yes | Yes | No | - | Pied bleu |
| Yes | No | - | Yes | Girolle |
| Yes | No | - | No | Cepe de bordeaux |

A dash means that answer does not matter for that path.

### MushroomIdentifier.java
- `identify(boolean forest, boolean convex, boolean ring, boolean gills)` returns the mushroom name as a `String`.
- It uses nested `if / else`. First it checks the forest answer, then the convex cup, then the ring or the gills, depending on the path.
- It has no window code, so it can be reused anywhere.

### MushroomGUI.java
- Four `ButtonGroup` objects, one per question. `group.add(yes); group.add(no);` makes the two radio buttons exclusive, so choosing **Yes** automatically unselects **No**.
- The helper method `addYesNo(...)` creates the pair and adds them to a group. The helper `addQuestionLabel(...)` adds the question text. This avoids repeating the same code four times.
- **Execute button**
  - If any group has no selection (`getSelection() == null`), a pop-up says "Please answer all the questions!".
  - Otherwise it reads each answer with `isSelected()`, creates `new MushroomIdentifier()`, calls `identify(...)`, and shows the name in the result box.
- **Clear button**: `clearSelection()` on each group unselects every radio button, and `resultField.setText("")` empties the result.
- **Cancel button**: `dispose()` closes this window, and a `WindowListener` (`windowClosed`) opens `new MainGUI()`, so the user is back on the main page (the X works the same way).
- The result box is read-only (`setEditable(false)`), and the three buttons have colored text (`setForeground`).

---

## Main page

### MainGUI.java
- A `JFrame` with a "Welcome" label and three buttons: **Mushrooms**, **Bicycle Rent** and **Exit**.
- The **Mushrooms** button runs `new MushroomGUI().setVisible(true);` to show the mushroom window, then `dispose();` to close the main page.
- The **Bicycle Rent** button runs `new RentalGUI().setVisible(true);` to show the rental window, then `dispose();` to close the main page.
- The **Exit** button runs `System.exit(0);` to close the whole program.
- `setDefaultCloseOperation(EXIT_ON_CLOSE)` on the main page means closing it with the X ends the program.
- `main` starts the program with `SwingUtilities.invokeLater(...)`, the recommended way to start a Swing app safely.

---

## Concepts used

- **Object-Oriented Programming:** separate logic classes and GUI classes, connected by creating objects.
- **Swing components:** `JFrame`, `JLabel`, `JTextField`, `JButton`, `JRadioButton`, `ButtonGroup`, `JOptionPane`.
- **Event handling:** `ActionListener`, `actionPerformed` and `WindowAdapter`.
- **Navigation between frames:** `new SomeFrame().setVisible(true)`, `dispose()`, `WindowListener` / `windowClosed`, and `System.exit(0)`.
- **Input validation and exception handling:** range checks and `try / catch`.
- **Absolute positioning:** `setLayout(null)` with `setBounds()`.

