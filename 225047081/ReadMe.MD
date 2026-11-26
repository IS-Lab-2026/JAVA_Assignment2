# Bicycle Rental System

## Project Overview
The Bicycle Rental System is a Java Swing desktop application that calculates the rental cost of a bicycle based on the starting hour, ending hour, and hourly pricing periods.

## Features
- Welcome window with Continue and Exit buttons.
- Enter rental starting and ending hours.
- Display the hourly pricing table.
- Calculate total rental hours.
- Calculate the rental cost hour by hour.
- Handle rentals crossing different hourly price periods.
- Display the final rental amount in RWF.
- Clear inputs and results.
- Back to the Welcome window.
- Exit the application.
- Validate empty, non-numeric, and invalid inputs.

## Hourly Price Rules

| Hour Range | Price per Hour |
|---|---:|
| 00:00–07:00 | 500 RWF |
| 07:00–14:00 | 1,000 RWF |
| 14:00–19:00 | 1,500 RWF |
| 19:00–21:00 | 1,000 RWF |
| 21:00–24:00 | 500 RWF |

## Input Validation
- Starting hour must be between 0 and 23.
- Ending hour must be between 1 and 24.
- Starting hour must be less than ending hour.
- Inputs must be valid whole numbers.

## Project Structure

GUI_IS_BicycleRental/
- src/GUI_IS/
  - GUI_main.java
  - Welcome.java
  - Welcome.form
  - Rental.java
  - Rental.form
- nbproject/
- build.xml
- README.md

## Main Classes

**GUI_main.java:** Starts the application.

**Welcome.java:** Displays the welcome window.

**Welcome.form:** NetBeans GUI Builder form for the welcome window.

**Rental.java:** Contains the bicycle rental calculator and calculation logic.

**Rental.form:** NetBeans GUI Builder form for the rental window.

## Technologies Used
- Java
- Java Swing
- Apache NetBeans IDE
- NetBeans GUI Builder

## How to Open the Project
1. Extract the ZIP file.
2. Open NetBeans IDE.
3. Select File → Open Project.
4. Select the GUI_IS_BicycleRental folder.
5. Wait for the project to load.
6. Run the project.

## How to Edit the GUI
1. Expand Source Packages.
2. Open the GUI_IS package.
3. Open Welcome.java or Rental.java.
4. Select the Design tab to edit the interface visually.

## Example Calculation

Rental period: 06:00–09:00

- 06:00–07:00 = 500 RWF
- 07:00–08:00 = 1,000 RWF
- 08:00–09:00 = 1,000 RWF

Total rental hours: 3

Total cost: 2,500 RWF

## Purpose
This project demonstrates Java Swing GUI development, event handling, input validation, loops, conditional statements, and basic arithmetic calculations.






# Mushroom Identification System

## Project Overview
The Mushroom Identification System is a Java Swing desktop application that identifies a mushroom by following a series of Yes/No questions about its characteristics and environment.

## Features
- Welcome window with Continue and Exit buttons.
- Questions presented using Yes/No dropdown lists.
- Identify button.
- Displays the identified mushroom name.
- Validates answers before identification.
- Clear button to reset questions and results.
- Back button to return to the Welcome window.
- Exit button to close the application.

## Identification Rules

### Rule 1: Gills
Does the mushroom have gills?

- No → Cepe de bordeaux
- Yes → Continue to Rule 2

### Rule 2: Forest
Does it grow in a forest?

- No → Continue to Rule 3
- Yes → Continue to Rule 4

### Rule 3: Ring
Does it have a ring?

- Yes → Coprin chevelu
- No → Agaric jaunissant

### Rule 4: Convex Cup
Does it have a convex cup?

- No → Girolle
- Yes → Continue to Rule 5

### Rule 5: Ring
Does it have a ring?

- Yes → Amanite tue-mouches
- No → Pied bleu

## Project Structure

GUI_IS_Mushroom/
- src/GUI_IS/
  - GUI_main.java
  - Welcome.java
  - Welcome.form
  - Mushroom.java
  - Mushroom.form
- nbproject/
- build.xml
- README.md

## Main Classes

**GUI_main.java:** Starts the application.

**Welcome.java:** Displays the welcome window.

**Welcome.form:** NetBeans GUI Builder form for the welcome window.

**Mushroom.java:** Contains the identification questions, rules, validation, and result display.

**Mushroom.form:** NetBeans GUI Builder form for the mushroom identification window.

## Technologies Used
- Java
- Java Swing
- Apache NetBeans IDE
- NetBeans GUI Builder

## How to Open the Project
1. Extract the ZIP file.
2. Open NetBeans IDE.
3. Select File → Open Project.
4. Select the GUI_IS_Mushroom folder.
5. Wait for the project to load.
6. Run the project.

## How to Edit the GUI
1. Expand Source Packages.
2. Open the GUI_IS package.
3. Open Welcome.java or Mushroom.java.
4. Select the Design tab to edit the interface visually.

## Purpose
This project demonstrates Java Swing GUI development, dropdown lists, event handling, conditional statements, validation, and decision-tree logic.

