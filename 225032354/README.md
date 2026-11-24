# Java Swing Desktop Suite (`1200x600`)

A multi-screen Java Swing desktop suite built with absolute positioning (`setLayout(null)` and `setBounds`), large readable fonts, and a central **Home** launcher.

## Screens & Features

### Home (`HomeGUI.java`)
The main entry frame featuring:
- Title and brief suite description
- **Bicycle** button to launch the rental cost calculator
- **Mushroom** button to launch the mushroom decision-tree identifier
- **Quit** button to exit the application

### Bicycle Rental Calculator (`BicycleRentalGUI.java`)
Computes bicycle rental costs in Rwandan Francs (**RWF**) based on starting (`0–23`) and ending (`1–24`) hours:
- Validates hour ranges and ensures `end > start`
- Alerts on invalid numbers or out-of-range inputs
- **Clear** button to reset inputs and total, plus a **Home** button to return to the hub

### Mushroom Identifier (`MushroomIdentifierGUI.java`)
Guides the user step by step through **Yes / No** questions to identify one of six mushrooms:
- *Agaric jaunissant*
- *Amanite tue-mouches*
- *Cèpe de Bordeaux*
- *Coprin chevelu*
- *Girolle*
- *Pied bleu*
- Displays step progress, final match result, **Start Again** button, and a **Home** button

## Prerequisites
- **Java Development Kit (JDK) 8** or higher

## How to Compile and Run

1. Place `HomeGUI.java`, `BicycleRentalGUI.java`, `BicycleRental.java`, and `MushroomIdentifierGUI.java` in the same directory.
2. Compile all Java files:
   ```bash
   javac *.java
