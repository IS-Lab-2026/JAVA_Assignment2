# Bicycle Rental and Mushroom Identifier (Java Swing GUI)

A lab assignment that turns two console programs, **Bicycle Rental** and **Mushroom Identification**, into a Java Swing graphical user interface with a home page.

## Files

| File | Purpose |
| --- | --- |
| `Main.java` | Main class. **Run this class to start the program.** |
| `HomeGUI.java` | Home page with **Bicycle**, **Mushroom** and **Exit** buttons. |
| `BicycleRentalGUI.java` | Bicycle rental screen. **Cancel** goes back to the home page. |
| `MushroomIdentifierGUI.java` | Mushroom identification screen. **Cancel** goes back to the home page. |

## Bicycle rental rules

* Start hour must be between 0 and 23, end hour between 1 and 24, and the start must be less than the end.
* Each rented hour is charged by the hour it starts in:

| Hours | Rate per hour |
| --- | --- |
| 0 to 7 | 500 RWF |
| 7 to 14 | 1000 RWF |
| 14 to 19 | 1500 RWF |
| 19 to 21 | 1000 RWF |
| 21 to 24 | 500 RWF |

Example: 9 to 17 is 5 hours at 1000 RWF plus 3 hours at 1500 RWF = 9500 RWF.

## Mushroom decision tree

The six mushrooms are Agaric Jaunissant, Amanite Tue-Mouche, Cèpe de Bordeaux, Coprin Chevelu, Girolle and Pied Bleu.

```
Has gills?
├─ No  -> Cèpe de Bordeaux
└─ Yes -> Grows in a forest?
          ├─ Yes -> Has a convex cap?
          │         ├─ No  -> Girolle
          │         └─ Yes -> Has a ring?
          │                   ├─ Yes -> Amanite Tue-Mouche
          │                   └─ No  -> Pied Bleu
          └─ No  -> Has a convex cap?
                    ├─ Yes -> Agaric Jaunissant
                    └─ No  -> Coprin Chevelu
```

## How to run in NetBeans

1. Choose **File > New Project > Java with Ant > Java Application** and click **Next**.
2. Name the project, untick **Create Main Class**, and click **Finish**.
3. Copy `Main.java`, `HomeGUI.java`, `BicycleRentalGUI.java` and `MushroomIdentifierGUI.java` into the project's `src` folder (the default package), so all four appear under **Source Packages**.
4. Right-click `Main.java` and choose **Run File** (Shift+F6).

To start the program with **Run Project** (F6) instead, open **File > Project Properties > Run** and set **Main Class** to `Main`. If NetBeans asks which main class to use the first time, choose `Main`.

## How to run from the command line

Needs JDK 11 or newer. Open a terminal in this folder and run:

```
javac -encoding UTF-8 *.java
java Main
```

In other IDEs (IntelliJ, Eclipse, VS Code), put the four files in one project and run `Main`.
