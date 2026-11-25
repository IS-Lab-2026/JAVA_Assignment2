# Java Assignment 2

A Java Swing desktop application with two exercises, connected through a Welcome menu.

## Programs

- `GUI_assign.java`: starts the Welcome window.
- `Welcome.java`: opens either exercise or exits the application.
- `BicycleRental.java`: calculates rental cost at 500 RWF per hour using start and end times; validates input and provides Clear and Cancel buttons.
- `MushroomIdentification.java`: uses four Yes/No questions and if/else statements to demonstrate classroom classification rules. It is not suitable for real mushroom identification or food safety decisions.

The three `.form` files store the editable NetBeans JFrame designs. Keep each beside its corresponding `.java` file. The generated `initComponents()` code controls the interface; the `ActionPerformed` methods contain the button logic.

## Run using Java 17 or newer

Download these files into one directory, open a terminal there and run:

```sh
javac -encoding UTF-8 -d out GUI_assign.java Welcome.java BicycleRental.java MushroomIdentification.java
java -cp out com.mycompany.gui_assign.GUI_assign
```

No external libraries are required.

## Open in NetBeans

1. Create a Java Application project (Java with Ant or Maven).
2. Create the package `com.mycompany.gui_assign` under Source Packages.
3. Copy all four `.java` and all three `.form` files into the package's physical directory (`src/com/mycompany/gui_assign` for Ant, or `src/main/java/com/mycompany/gui_assign` for Maven).
4. Set the project main class to `com.mycompany.gui_assign.GUI_assign` in Project Properties > Run.
5. Clean and Build, then Run Project (F6).
6. Open any JFrame class and select Design to edit the interface, or Source to edit the logic.

## Example

Start time: 8; end time: 12. Rental duration: 4 hours. Total: 2,000 RWF.
