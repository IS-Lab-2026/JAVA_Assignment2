# GUI_mains — Java Swing assignment

The program opens a Welcome window with two exercises. **Bicycle Rental** calculates a charge in Rwandan francs (RWF). **Mushroom** identifies one of six mushrooms from a series of yes/no answers.

## What each class does

| Java file | Role |
| --- | --- |
| `GUI_mains.java` | Starts the application in `main()` and displays the Welcome frame. The Bicycle Rental and Mushroom buttons open their respective frames and close Welcome. Exit ends the program. |
| `BicycleRentalForm.java` | Reads the starting and ending hours, calls the rental calculation, and displays the result. Invalid input clears the result and shows a warning. |
| `BicycleRental.java` | Validates the hours and adds the price of each rental hour in `calculateRent(startTime, endTime)`. |
| `MushroomForm.java` | Displays the mushroom list, starts the game, opens a dialog for each question, and displays the final name or “Guess cancelled”. |
| `MushroomGuess.java` | Uses `if/else` decisions in `identify()` to choose the next question or return a mushroom name. Its `QuestionAsker` interface defines one method that takes a question and returns a yes/no answer. |
| `MushroomQuestionDialog.java` | Shows one question and waits for a click. Yes returns `true`, No returns `false`, and Cancel or closing the dialog returns `null`. |

## How the buttons and classes work together

**Calculate Rent.** Clicking the button or pressing Enter in the ending-hour field runs `btnCalculateActionPerformed`. It converts the two text values into whole numbers and calls `BicycleRental.calculateRent()`. The loop counts from the starting hour up to, but excluding, the ending hour. For a rental from 12:00 to 16:00, two hours cost 1,000 RWF each and two cost 1,500 RWF each. The form displays **5000 RWF**.

**Guess Mushroom.** The Guess button calls `MushroomGuess.identify(this::askYesNo)`. Here, `this::askYesNo` tells the decision code which method to call whenever it needs an answer. That method opens the question dialog. For example, answering **No** to “Does your mushroom have gills?” returns **Cepe de Bordeaux**. Cancelling the dialog stops the current guess. Clicking Cancel on either exercise frame returns to Welcome.

## How to run and edit

Open the project folder containing `pom.xml` in NetBeans and press **F6**. The three frames and the question dialog each have a matching `.java` and `.form` file. NetBeans reads the `.form` layout in **Design** view. At runtime, `initComponents()` creates the controls, arranges them, and connects each button to its event handler. Double-click a button in Design to edit what happens when it is clicked.

The two exercise classes also have console entry points. They read keyboard input and reuse the same rental calculation and mushroom decisions as the graphical application.
