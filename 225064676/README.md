NAME: ISHIMWE Olivier   225064676
 # Java GUI Application Assignement

## 1. Project Overview

This project is a Java-based desktop application developed using Java Swing. It consists of two independent systems connected through one main menu:

1. Bicycle Rental System
2. Mushroom Identification System

The application provides a graphical user interface (GUI) that allows users to perform different operations by clicking buttons, entering information, and selecting answers.

The main menu is implemented in `WELCOME.java`, which acts as the starting point of the application and allows users to choose which system they want to use.



## 2. Main Menu (WELCOME)

The main menu is the first window displayed when the application starts.

It provides two main options:

- **Rental System:** Opens the Bicycle Rental System.
- **Mushroom Identification:** Opens the Mushroom Identification System.

When a user selects either option, the corresponding window opens and the main menu closes.

After finishing either system, the user can return to the main menu.



## 3. Bicycle Rental System

### Purpose

The Bicycle Rental System helps users calculate the cost of renting a bicycle based on the starting hour and ending hour of the rental period.

### How It Works

**Step 1: Enter Start Hour**

The user enters the hour when the bicycle rental begins.

**Step 2: Enter End Hour**

The user enters the hour when the bicycle rental ends.

**Step 3: Calculate Rental Cost**

The user clicks the Calculate button. The program reads both values and sends them to the bicycle rental calculation logic in `BicycleRental.java`.

The program calculates the total rental cost and displays the result in the interface.

**Step 4: Clear Information**

The Clear button removes the entered start hour and end hour and resets the displayed result. This allows the user to perform another calculation.

**Step 5: Cancel**

The Cancel button closes the Bicycle Rental System and returns the user to the main menu.

### Main Components

- Start Hour: Accepts the rental starting time.
- End Hour: Accepts the rental ending time.
- Calculate: Performs the rental cost calculation.
- Total Cost: Displays the calculated amount in RWF.
- Clear: Resets the input fields and result.
- Cancel: Returns to the main menu.


## 4. Mushroom Identification System

### Purpose

The Mushroom Identification System helps users identify different mushroom types by answering questions about their physical characteristics and growing environment.

### How It Works

The system uses a series of Yes/No questions. Each answer determines which question or identification result comes next.

**Step 1: Check for Gills**

The user is asked whether the mushroom has gills.

- If the answer is No, the mushroom is identified as Cepe de Bordeaux.
- If the answer is Yes, the system continues to the next question.

**Step 2: Check the Growing Environment**

The user is asked whether the mushroom grows in the forest.

- If the answer is No, the system asks about the convex cup.
- If the answer is Yes, the system asks whether the mushroom has a ring.

**Step 3: Check for a Convex Cup or Ring**

Depending on the previous answer:

If the mushroom does not grow in the forest:
- Yes to convex cup: Agaric Jaunissant.
- No to convex cup: Coprin Chevelu.

If the mushroom grows in the forest:
- Yes to having a ring: Amanite Tue-Mouche.
- No to having a ring: The system asks about the convex cup.
  - Yes: Pied Bleu.
  - No: Girolle.

**Step 4: Display the Identification Result**

After the user completes the required questions, the identified mushroom name is displayed in the result field.

**Step 5: Reset or Exit**

- Reset clears the selected answers and allows the user to start another identification.
- Exit closes the Mushroom Identification System and returns to the main menu.

### Mushroom Identification Results

| Conditions | Identified Mushroom |
|---|---|
| No gills | Cepe de Bordeaux |
| Gills, no forest, convex cup | Agaric Jaunissant |
| Gills, no forest, no convex cup | Coprin Chevelu |
| Gills, forest, ring | Amanite Tue-Mouche |
| Gills, forest, no ring, convex cup | Pied Bleu |
| Gills, forest, no ring, no convex cup | Girolle |

---

## 5. Technologies Used

- **Java:** Main programming language used to develop the application.
- **Java Swing:** Used to create the graphical user interfaces.
- **Apache Maven:** Used for project configuration and management.
- **NetBeans IDE:** Used for writing, designing, and running the application.

## 6. Project Structure

The project contains the following main files:

| File | Responsibility |
|---|---|
| `WELCOME.java` | Main menu and navigation |
| `WELCOME.form` | Main menu interface design |
| `BicycleRental.java` | Bicycle rental calculation logic |
| `BicycleRentalGUI.java` | Bicycle rental graphical interface |
| `Mushroom.java` | Mushroom identification logic |
| `Mushroomwindow.java` | Mushroom identification graphical interface |
| `Mushroomwindow.form` | Mushroom interface design |
| `pom.xml` | Maven project configuration |

## 7. System Requirements

- Java Development Kit (JDK) 17 or later.
- NetBeans IDE (recommended).
- A computer capable of running Java desktop applications.

## 8. How to Run the Application

1. Clone or download this repository.
2. Open NetBeans IDE.
3. Open the downloaded Maven project.
4. Allow Maven to load the project configuration.
5. Locate `WELCOME.java` inside the `my.mushroom` package.
6. Run `WELCOME.java` to open the main menu.
7. Select either the Bicycle Rental System or Mushroom Identification System.

## 9. Project Objective

The main objective of this project is to demonstrate practical Java programming skills, including:

- Object-oriented programming.
- Conditional statements and decision-making.
- Event handling.
- Graphical user interface development.
- User input and output.
- Methods and program organization.
- Navigation between multiple application windows.
