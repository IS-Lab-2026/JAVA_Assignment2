1. # Bicycle Rental & Mushroom Identification 

## Project Overview
This is a Java Swing desktop application built in Apache NetBeans. The application acts as a central hub that connects a welcome dashboard to two independent functional modules:

1. Time-Tiered Cost Calculator: Computes usage charges automatically by applying different pricing rates depending on the duration entered.
2. Mushroom Identification Tool: Guides the user through physical traits to identify different mushroom species.

## Application Architecture
The project is organized under the 'com.mycompany.bicyclemushroom' package using a clean, event-driven GUI structure:

"Bicyclemushroom.java" The main entry point of the program. It initializes the graphical user interface safely on the Swing Event Dispatch Thread using EventQueue.invokeLater().
"Welcomee.java" . The landing window ('JFrame') that greets the user and provides navigation buttons to launch either the Cost Calculator or the Mushroom Identification form.
Module Forms ('JFrame').Separate GUI forms that handle user input, apply conditional logic, and display results clearly.
Used "java.awt.EventQueue.invokeLater()" in the "main" method to ensure UI components render reliably without thread conflicts.

2. # Bicycle Rental Cost Calculator ('Bicyclerent')
A Java Swing GUI form ('JFrame') that calculates bicycle rental charges from a start time and end time using tiered hourly rates.
## How It Works
* Takes integer inputs for **Start time** and **End time**.
* Validates that numbers are entered and that endtime > starttime.
* Calculates rental duration (endtime - starttime) and applies the rate tier:
  * Less than 5 hours: 1500 per unit/hour
  * 5 to 20 hours (less than 21): 1000 per unit/hour
  * 21 hours or more: 500 per unit/hour
* Displays the total cost in 'txtanswerbicycle' and lets the user return to 'Welcomee' via **Cancel**.

3. # Mushroom Identification ('Mushroomm')

A Java Swing GUI form ('JFrame') that identifies mushroom species using radio button selections and conditional decision logic.

## How It Works
* Groups Yes/No options with 'ButtonGroup' for four traits:
* Evaluates selections when **Action** is clicked and outputs the matching species in 'txtanswermushroom' (*Cepe de Bordeaux*, *Agaric Jaunissant*, *Coprin chevelu*, *Amanite tue-mouche*, *Pied bleu*, or *Girolle*).
* Provides a **Cancel** button to return to 'Welcomee'.
  
4. # Welcome Navigation Screen (`Welcomee`)

A Java Swing start window ('JFrame') that serves as the main menu to open the application modules or exit the program.

## How It Works
* **Bicycle rental:** Opens Bicyclerent.
* **Mushroom:** Opens 'Mushroomm' and closes the current welcome window ('this.dispose()').
* **EXIT:** Closes the application ('System.exit(0)').


2. Run `Bicyclerent.java` (**Run File** / `Shift + F6`) or open it from `Welcomee`.
