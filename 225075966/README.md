# GUI_IR

A simple Java Swing application that launches and centers the `Welcome` GUI window.

## What It Does
* Instantiates the Welcome frame (new Welcome()).
* Displays the window on screen (setVisible(true)).
* Centers the window on the display (setLocationRelativeTo(null)).

## Requirements
* **Java Development Kit (JDK):** Version 8 or higher.
* **`Welcome.java`:** Must exist in the same package/project (extending javax.swing.JFrame).

## How to Run
Compile and run both files from your terminal:

```bash
javac GUI_IR.java Welcome.java
java GUI_IR

# Welcome

A simple Java Swing main menu window (`JFrame`) that routes users to **Bicycle Rental** and **Mushroom** screens.

## Features
* **BICYCLE RENT:** Opens the `BicycleRental` window and closes the `Welcome` screen.
* **MUSHROOM:** Opens the `Mushroom` window and closes the `Welcome` screen.
* **EXIT:** Closes the application (`System.exit(0)`).

## Requirements
* **Java Development Kit (JDK):** Version 8 or higher.
* **Required Classes:** `Welcome.java`, `BicycleRental.java`, and `Mushroom.java` in the same package/project.

## How to Run
Compile and run `Welcome.java` from your terminal:

```bash
javac Welcome.java BicycleRental.java Mushroom.java
java Welcome


 Bicycle Rental

A simple Java Swing application that calculates the cost of renting a bicycle based on the start and end hour of the rental. Prices are in Rwandan francs (RWF).

Features
Enter a Start Time and End Time (in 24-hour format, whole hours)
Calculate the total rental cost
Clear all fields
Cancel to go back to the Welcome window
Pricing (per hour)
Time of day	   Price per hour
00:00 - 07:00	  500 RWF
07:00 - 14:00	  1000 RWF
14:00 - 19:00	  1500 RWF
19:00 - 21:00	  1000 RWF
21:00 - 24:00	  500 RWF

The program adds up the price of every hour the bicycle is kept, from the start hour up to (but not including) the end hour.

Example: Start = 6, End = 9 gives 500 (06-07) + 1000 (07-08) + 1000 (08-09) = 2500 RWF

Input Rules
Start Time must be a whole number from 0 to 23
End Time must be a whole number from 1 to 24
Start Time must be less than End Time
Anything else shows Invalid input! in the Total field
Requirements
Java Development Kit (JDK) 8 or later
The Welcome class in the same project (used by the Cancel button)
How to Run
Using an IDE (NetBeans, IntelliJ, Eclipse)
Open the project.
Make sure BicycleRental.java and Welcome.java are included.
Right-click BicycleRental.java and choose Run File.
Main Components
Component and their Purpose
StartField:	Input for start hour
EndField:	Input for end hour
TotalField:	Displays the total cost
BTNcalculate:	Calculates the rental cost
BTNclear:	Clears all text fields
BTNcancel:	Returns to the Welcome window


 Mushroom

A simple Java Swing application that identifies a mushroom by answering four Yes/No questions.

How It Works

Answer the questions, then click Identify Mushroom. The result appears in the "Mushroom is" field.

Question	Options
Has a gills?	Yes / No
Grow in a forest?	Yes / No
Has a ring?	Yes / No
Has a convex cup?	Yes / No

If any question is left unanswered, the result shows Answer all questions.

Identification Rules
Gills	Forest	Ring	Cup	Result
No	any	any	any	Cepe de Bordeaux
Yes	No	any	Yes	Agaric Jaunissant
Yes	No	any	No	Coprin Chevelu
Yes	Yes	Yes	any	Amanite Tue-Mouche
Yes	Yes	No	Yes	Pied Bleu
Yes	Yes	No	No	Girolle
Buttons
Identify Mushroom: shows the mushroom name based on the answers
Clear: unselects all answers and empties the result
Cancel: returns to the Welcome window
Requirements
JDK 8 or later
Welcome.java in the same project (used by the Cancel button)
How to Run

IDE (NetBeans, IntelliJ, Eclipse): right-click Mushroom.java and choose Run File.

Command line:

bash
javac Mushroom.java Welcome.java
java Mushroom
