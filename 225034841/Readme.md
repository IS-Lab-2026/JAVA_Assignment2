
# MushroomBayscle

A simple Java Swing desktop app with two tools: a bicycle rental calculator and a mushroom identifier.

## Features

- **Main Menu (`Welcome.java`)**: Lets you switch between the bicycle calculator and the mushroom identifier.
- **Bicycle Rental Calculator (`Bicycles.java`)**: Calculates rental fees in RWF based on the start and end hours you enter.
- **Mushroom Identifier (`Mushroom.java`)**: Asks a few Yes/No questions to identify a mushroom species, with a back button and a summary of your answers.

## Project Files

- `Welcome.java` - Main entry point and navigation window.
- `Welcome.form` - NetBeans GUI layout file for the welcome screen.
- `Bicycles.java` - Bicycle rental pricing logic and form.
- `Mushroom.java` - Mushroom identification questions and logic.

## Requirements

- Java 17 or higher
- NetBeans (optional, helpful if you want to edit `Welcome.form`)

## How to Run

1. Open the project in NetBeans, IntelliJ, or Eclipse, or place the files inside a `com/mycompany/mushroombayscle` folder.
2. Compile the files:
   ```bash
   javac com/mycompany/mushroombayscle/*.java
   ```
3. Run the main window:
   ```bash
   java com.mycompany.mushroombayscle.Welcome
   ```

## Usage

### Bicycle Rental Rates
Enter a start hour (0–23) and an end hour (1–24). Rates change depending on the time of day:
- **00:00 – 07:00**: 500 RWF/hour
- **07:00 – 14:00**: 1,000 RWF/hour
- **14:00 – 19:00**: 1,500 RWF/hour
- **19:00 – 21:00**: 1,000 RWF/hour
- **21:00 – 24:00**: 500 RWF/hour

### Mushroom Types
Answer the prompts to identify one of six mushrooms:
- *Cèpe de Bordeaux*
- *Amanite tue-mouches*
- *Pied bleu*
- *Girolle*
- *Agaric jaunissant*
- *Coprin chevelu*
