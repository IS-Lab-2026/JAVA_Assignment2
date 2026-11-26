# Java Swing Multi-Screen App

This folder contains a small Java Swing application with a welcome screen, a bicycle rental calculator, and a mushroom identification form. The two Java files work together: `Main.java` manages the application window and navigation, while `FeaturePanels.java` builds the two feature screens.

## Files

### `Main.java` — application window and navigation

`Main` extends `JFrame`, so it is the main application window. Its `initUI()` method sets the window title, size, position, and close behavior, then creates a `CardLayout` and a containing `JPanel`.

A `CardLayout` lets the application keep multiple panels in the same window and display one at a time. The app adds three panels to the container:

- **Welcome** — created inside `Main`; its buttons open the Bicycle Rental and Mushroom screens, or exit the application.
- **Bicycle Rental** — created by `FeaturePanels.createBicycleRentalPanel(this)`.
- **Mushroom** — created by `FeaturePanels.createMushroomPanel(this)`.

The `showScreen(String screenName)` method asks the card layout to display the panel registered under that name. The screen-name constants prevent the navigation names from being repeated as string literals. In `main()`, `SwingUtilities.invokeLater(...)` starts and displays the GUI on Swing's Event Dispatch Thread, which is the recommended thread for Swing interface work.

### `FeaturePanels.java` — feature screens and their behavior

`FeaturePanels` contains static factory methods. Each method creates a `JPanel`, adds its Swing controls, connects event listeners, and returns the completed panel to `Main`.

#### Bicycle Rental

`createBicycleRentalPanel(Main appFrame)` builds text fields for start and end hours, a read-only total field, and Calculate and Cancel buttons.

When **Calculate** is clicked:

1. The start and end values are read from the text fields and parsed as integers.
2. The program loops over each hour from the start hour (inclusive) to the end hour (exclusive).
3. It adds the rate for each hour to the total:
   - Before 07:00 or from 21:00 onward: **500 RWF per hour**
   - From 07:00–13:00 or 19:00–20:00: **1,000 RWF per hour**
   - From 14:00–18:00: **1,500 RWF per hour**
4. The total is displayed with the `RWF` currency label.

If either field is not an integer, an error dialog is shown. **Cancel** clears the displayed total and returns to the welcome screen. The current code does not validate that the hours are within a particular range or that the end time is after the start time; if the end time is earlier than the start time, the loop does not run and the displayed total is zero.

#### Mushroom Identification

`createMushroomPanel(Main appFrame)` builds yes/no combo boxes for gills, forest growth, and a third feature. The third question changes based on the earlier choices:

- If the mushroom has no gills, the forest and third-feature controls are disabled.
- If it has gills and does not grow in a forest, the third question becomes **“Has a convex cup?”**
- If it has gills and grows in a forest, the third question is **“Has a ring?”**

Clicking **Identify** applies the nested decision logic and displays one of the configured names: Cepe de Bordeaux, Agaric Jaunissant, Coprin chevelu, Amanite tue-mouche, or an unknown-result message. **Cancel** resets the result text and returns to the welcome screen.

## How the files work together

1. `Main` creates the window and asks `FeaturePanels` to create the two feature panels.
2. Each panel receives the `Main` instance (`this`) so its Cancel button can call `showScreen(Main.SCREEN_WELCOME)`.
3. Button listeners react to user actions and update fields, labels, dialogs, or the currently visible card.

The panels use `setLayout(null)` and explicit `setBounds(...)` coordinates, so each control is positioned manually. This keeps the example straightforward, but layout managers are generally more adaptable to resizing and different display scales.

## Compile and run

Open a terminal in this folder and run:

```bash
javac Main.java FeaturePanels.java
java Main
```

A Java Development Kit (JDK) is required. The application opens as a desktop Swing window; it needs a graphical desktop environment to display the interface.
