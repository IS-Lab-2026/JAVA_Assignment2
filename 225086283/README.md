# Java Programming Projects

## Project Overview

This repository contains Java programming projects developed using Java and Swing GUI. The projects demonstrate basic programming concepts, conditional statements, loops, user input, calculations, and graphical user interfaces.

The project includes three main applications:

1. **Welcome Application**
2. **Bicycle Rental System**
3. **Mushroom Identification System**


1. Welcome Application

The Welcome application serves as the main menu of the project. It allows users to choose which application they want to open.

>Features
- Displays a welcome message.
- Provides a button to open the Bicycle Rental System.
- Provides a button to open the Mushroom Identification System.
- Uses Java Swing components to create the graphical interface.

> Files
- `GUI.java` – Main class that launches the Welcome window.
- `Welcome.java` – Contains the Welcome GUI and navigation buttons.
- `Welcome.form` – Form XML template associated with the Welcome interface.


2. Bicycle Rental System

The Bicycle Rental System calculates the total rental cost based on the starting and ending rental times.

> Features
- Accepts starting and ending times.
- Validates user input.
- Calculates rental costs hour by hour.
- Displays the total rental cost in Rwandan Francs (RWF).
- Provides Calculate and Clear buttons.
- Displays the rental price schedule.

>Rental Price Schedule

| Time | Price per Hour |
|---|---:|
| 00:00 – 06:59 | 500 RWF |
| 07:00 – 13:59 | 1,000 RWF |
| 14:00 – 18:59 | 1,500 RWF |
| 19:00 – 20:59 | 1,000 RWF |
| 21:00 – 23:59 | 500 RWF |

>Files
- `BicycleRental.java` – Original console-based program.
- `Rental.java` – Graphical user interface for the rental system.
- `Rental.form` – Form file, if generated using NetBeans.

---

 3. Mushroom Identification System

The Mushroom Identification System uses answers provided by the user to produce a mushroom classification based on the conditions defined in the program.

>Features
- Accepts user answers about mushroom characteristics.
- Uses conditional statements to determine the classification.
- Displays the identification result.
- Includes a graphical user interface.

>Files
- "Mushroom.java" :Graphical user interface for mushroom identification.
- "Mushroom.form" :Form file, if generated using NetBeans.

Note: The classification is based on simplified assignment rules and must not be used to determine whether a real mushroom is safe to eat.

> Technologies Used

- Java
- Java Swing
- Object-Oriented Programming
- Visual Studio Code
- Git and GitHub

> Java Concepts Demonstrated

- Variables and data types
- User input using Scanner
- Conditional statements (`if`, `else if`, `else`)
- Loops (`for`)
- Exception handling (`try-catch`)
- Methods
- Classes and objects
- Graphical User Interfaces (GUI)
- Event handling
- Input validation


> How to Run the Project

1. Install the Java Development Kit (JDK).
2. Open the project folder in Visual Studio Code.
3. Make sure the Java Extension Pack is installed.
4. Open `GUI.java`.
5. Run the main method.
6. The Welcome window will appear.
7. Select either Bicycle Rental or Mushrooms to open the corresponding application.

>Conclusion

These projects demonstrate the use of Java programming fundamentals and graphical user interface development. They provide practical experience in developing interactive applications, handling user input, performing calculations, and organizing Java programs into separate classes.

---

**Development Environment:** Visual Studio Code  
**Programming Language:** Java  
**GUI Framework:** Java Swing  
**Repository:** Java Programming Projects