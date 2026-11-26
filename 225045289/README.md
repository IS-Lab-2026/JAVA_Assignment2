# Bicycle Rental and Mushroom Identifier (Java Swing GUI)

A lab assignment that turns two console programs, **Bicycle Rental** and **Mushroom Identification**, into a Java Swing graphical user interface with a home page.

## Contents

* [Files](#files)
* [Buttons](#buttons)
* [Logic used](#logic-used)
  * [How the screens connect](#how-the-screens-connect)
  * [Bicycle rental logic](#bicycle-rental-logic)
  * [Mushroom identification logic](#mushroom-identification-logic)

## Files

| File | Purpose |
| --- | --- |
| `Main.java` | Main class. Starts the program by opening the home page. |
| `HomeGUI.java` | Home page with the **Bicycle**, **Mushroom** and **Exit** buttons. |
| `BicycleRentalGUI.java` | Bicycle rental screen. |
| `MushroomIdentifierGUI.java` | Mushroom identification screen. |

## Buttons

### Home page (`HomeGUI`)

| Button | What it does |
| --- | --- |
| **Bicycle** | Opens the bicycle rental screen and closes the home page. |
| **Mushroom** | Opens the mushroom identification screen and closes the home page. |
| **Exit** | Closes the whole program. |

### Bicycle rental screen (`BicycleRentalGUI`)

| Button | What it does |
| --- | --- |
| **Calculate Cost** | Checks the two hours and shows the total, for example `Total: 9500 RWF`. Pressing Enter in the end hour box does the same. |
| **Clear** | Empties both hour boxes and resets the total to `Total: 0 RWF`. |
| **Cancel** | Goes back to the home page. |

### Mushroom identification screen (`MushroomIdentifierGUI`)

| Button | What it does |
| --- | --- |
| **Yes** | Answers the current question with yes and moves to the next question or to the result. |
| **No** | Answers the current question with no and moves to the next question or to the result. |
| **Start Again** | Appears only after a result is shown (Yes and No are hidden then). Goes back to question 1. |
| **Cancel** | Goes back to the home page. |

Closing any window with the window's X button closes the whole program.

## Logic used

The logic comes from the two original console programs. The console `Scanner` input is replaced by text boxes and buttons, and `System.out.println` output is replaced by labels and message boxes.

### How the screens connect

Every screen is its own window (`JFrame`). Moving between screens follows one pattern:

1. A button's action listener creates the next window and shows it with `setVisible(true)`.
2. The same listener calls `dispose()` to close the current window.

So **Bicycle** and **Mushroom** on the home page open their screens, and **Cancel** on each screen creates a new `HomeGUI`. Only one window is open at a time. `Main` simply starts `HomeGUI` on the Swing event thread with `SwingUtilities.invokeLater`.

### Bicycle rental logic

When **Calculate Cost** is clicked, the program runs these steps in order:

1. **Read the numbers.** Both boxes are converted to whole numbers. If either box is empty or not a whole number, it shows *Please enter valid whole numbers.* and stops.
2. **Validate the hours,** in the same order as the console program. The first rule that fails shows its message and stops:

   | Check | Message |
   | --- | --- |
   | Start hour is below 0 or above 23 | Start hour must be between 0 and 23. |
   | End hour is below 1 or above 24 | End hour must be between 1 and 24. |
   | Start hour is not less than end hour | Starting time must be less than ending time. |

3. **Add up the cost with a loop.** The loop starts at the start hour and runs for every hour before the end hour. Each hour is charged by the hour it starts in:

   | Hours | Rate per hour |
   | --- | --- |
   | 0 to 7 | 500 RWF |
   | 7 to 14 | 1000 RWF |
   | 14 to 19 | 1500 RWF |
   | 19 to 21 | 1000 RWF |
   | 21 to 24 | 500 RWF |

4. **Show the result** as `Total: <cost> RWF`.

Example: 9 to 17 is the hours 9, 10, 11, 12 and 13 at 1000 RWF each (5000), plus the hours 14, 15 and 16 at 1500 RWF each (4500), a total of 9500 RWF.

### Mushroom identification logic

The questions form a **decision tree**. Each point in the tree is a `Node` object that is either:

* a **question** with a Yes branch and a No branch, or
* a **result** (a leaf) holding the name of a mushroom.

The program keeps a `currentNode`, which starts at the first question. Clicking **Yes** moves `currentNode` to its Yes branch, and clicking **No** moves it to its No branch. After each move the screen is redrawn: a question node shows its text and the Yes and No buttons, and a leaf node shows the result and the **Start Again** button. **Start Again** sets `currentNode` back to the first question. The question number goes up by one each time a new question is shown.

The tree is the same as in the console program: gills, then forest, then convex cap, then ring.

```
1. Has gills?
├─ No  -> Cèpe de Bordeaux
└─ Yes -> 2. Grows in a forest?
          ├─ Yes -> 3. Has a convex cap?
          │         ├─ No  -> Girolle
          │         └─ Yes -> 4. Has a ring?
          │                     ├─ Yes -> Amanite Tue-Mouche
          │                     └─ No  -> Pied Bleu
          └─ No  -> 3. Has a convex cap?
                    ├─ Yes -> Agaric Jaunissant
                    └─ No  -> Coprin Chevelu
```

Because the questions are fixed, an answer can never be invalid, so unlike the console version there is no "please answer yes or no" message. The six mushrooms are Agaric Jaunissant, Amanite Tue-Mouche, Cèpe de Bordeaux, Coprin Chevelu, Girolle and Pied Bleu. Any of them is reached in at most four questions.
