# GUI INTERFACE
This project initializes and displays the main graphical user interface (`Welcome` window) centered on the user's screen.

## Project Structure
* **`GUImain.java`**: The main entry point of the application. It instantiates the `Welcome` frame, makes it visible, and centers it on the screen.
* **`Welcome.java`**: The primary GUI window component displayed upon launch.

## Requirements
* **Java Development Kit (JDK)**: Version 17 or higher recommended.
* **IDE**: Apache NetBeans, IntelliJ IDEA, or Eclipse (or command-line `javac`/`java`).

## How to Run
1. Clone or download this repository.
2. Open the project in your preferred Java IDE (e.g., NetBeans) or navigate to the source directory in your terminal.
3. Compile and run `GUImain.java`:
   ```bash
   javac GUImain.java Welcome.java
   java GUImain
# WELCOME
The application opens a centered `Welcome` window where users can navigate to either the **Bicycle Rental** calculator or the **Mushroom Identification** tool, or exit the program.

## Project Structure
* **`GUImain.java`**: The main entry point. Initializes, centers, and displays the `Welcome` frame.
* **`Welcome.java`**: The main menu GUI featuring buttons to launch sub-applications (`btnbicycle`, `btnmushroom`) or close the program (`btnexit`).
* **`BicycleRent.java`**: GUI module for calculating bicycle rental costs.
* **`MUSHROOM.java`**: GUI module for rule-based mushroom identification.

## Requirements
* **Java Development Kit (JDK)**: Version 17 or higher recommended.
* **IDE**: Apache NetBeans, IntelliJ IDEA, or Eclipse (or command-line `javac`/`java`).

## How to Run
1. Clone or download this repository.
2. Open the project in your preferred Java IDE (e.g., NetBeans) or navigate to the source directory in your terminal.
3. Compile and run `GUImain.java`:
   ```bash
   javac *.java
   java GUImain
# BICYCLE RENT
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
StartTime must be a whole number from 0 to 23
EndTime must be a whole number from 1 to 24
StartTime must be less than End Time
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
btncalculate:	Calculates the rental cost
btnclear:	Clears all text fields
btncancel:	Returns to the Welcome window

# MUSHROOM IDENTIFICATION
A simple Java Swing application that identifies a mushroom species based on four observable physical and habitat characteristics.

## Features
* Select mushroom traits using checkboxes (**Gills**, **Forest**, **Ring**, **Cup**)
* Identify the matching mushroom species
* Clear all selections and reset the output field
* Cancel to go back to the `Welcome` window

## Identification Rules
The program evaluates the selected checkboxes in the following decision order:

| Gills | Habitat (Forest) | Ring | Cup | Identified Mushroom |
| :--- | :--- | :--- | :--- | :--- |
| Unchecked | Any | Any | Any | **Cepe de Bordeaux** |
| Checked | Unchecked (Meadow) | Any | Checked | **Agaric Jaunissant** |
| Checked | Unchecked (Meadow) | Any | Unchecked | **Coprin Chevelu** |
| Checked | Checked | Checked | Any | **Amanite Tue-Mouche** |
| Checked | Checked | Unchecked | Checked | **Pied Bleu** |
| Checked | Checked | Unchecked | Unchecked | **Girolle** |

## Requirements
* Java Development Kit (JDK) 8 or later
* The `Welcome` class in the same project (used by the Cancel button)

## How to Run
### Using an IDE (NetBeans, IntelliJ, Eclipse)
1. Open the project.
2. Make sure `MUSHROOM.java` and `Welcome.java` are included.
3. Right-click `MUSHROOM.java` and choose **Run File** (or launch it from `GUImain.java`).

## Main Components

| Component | Purpose |
| :--- | :--- |
| `checkgills` | Checkbox indicating whether the mushroom has gills |
| `checkforest` | Checkbox indicating whether the mushroom grows in a forest (unchecked = meadow) |
| `checkring` | Checkbox indicating whether the mushroom has a ring on its stem |
| `checkcup` | Checkbox indicating whether the mushroom has a cup (volva) at its base |
| `resultField` | Displays the identified mushroom name |
| `btnidentify` | Evaluates the checkboxes and displays the result |
| `btnclear` | Unchecks all boxes and clears `resultField` |
| `btncancel` | Returns to the `Welcome` window |
