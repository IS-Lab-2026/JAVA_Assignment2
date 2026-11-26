# Java Swing Assignment 2

**Student:** Niyigaba Vincent  
**Registration Number:** 225031571  

## Overview

This project is a Java Swing desktop application organized into a graphical user interface (`App.java`) and two business logic classes (`BicycleRental.java` and `MushroomGuesser.java`). It uses `CardLayout` inside a single `JFrame` to switch cleanly between screens without opening extra windows.

## Screens and Navigation (`App.java`)

- **Welcome Screen:** Displays the `Welcome` title and three buttons: `Bicycle rental`, `Mushroom`, and `Exit` (which terminates the application using `System.exit(0)`).
- **Bicycle Rental Screen:** Accepts `Start time` and `End time` integer inputs, calls `BicycleRental.getRent(start, end)` when `Calculate` is clicked, displays the output in a non-editable `Result` text field, and provides a `Cancel` button that clears the fields and returns to `Welcome`.
- **Mushroom Screen:** Provides `yes`/`no` selection options (`JComboBox`) for `Ring`, `Forest`, `Gills`, and `Convex cup`, calls `MushroomGuesser.guess(...)` when `Guess` is clicked, displays the result in a non-editable `Result` field, and provides a `Cancel` button that resets the result and returns to `Welcome`.

## Business Logic

- **`BicycleRental.java`:** Validates input hours (`start` must be between `0` and `23`, `end` between `1` and `24`, and `start < end`). It computes the rental amount in `RWF` across time brackets (`500 RWF/hr` for `0–7` and `21–24`, `1000 RWF/hr` for `7–14` and `19–21`, and `1500 RWF/hr` for `14–19`), splitting hours accurately when a rental spans multiple brackets.
- **`MushroomGuesser.java`:** Normalizes the four inputs (`ring`, `forest`, `gills`, and `cup`) by trimming whitespace and converting to lowercase, then matches combinations to return `Fly agaric`, `Field mushroom`, `Chanterelle`, `Puffball`, or `Unknown mushroom type.`.

## How to Run

1. Place `App.java`, `BicycleRental.java`, and `MushroomGuesser.java` in the same directory.
2. Compile the source files: `javac *.java`
3. Run the application: `java App`
