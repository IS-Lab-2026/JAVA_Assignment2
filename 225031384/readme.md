# GUI Assignment (`gui_assign`)

A Java Swing desktop application featuring a central welcome menu that launches two standalone utility modules: a **Mushroom Identifier** and a **Bicycle Rental** fare calculator. Built with NetBeans GUI Forms (`javax.swing.JFrame`).

---

## Project Structure & Components

The project is organized under the `com.mycompany.gui_assign` package:

* **`GUI_assign.java`** — Application entry point (`main` method) that initializes and displays the `Welcome` screen.
* **`Welcome.java`** — Main dashboard providing navigation buttons to open **BicycleRental**, open **MushroomIdentifier**, or **EXIT** the application.
* **'MushroomIdentification.java`** — Rule-based identification form using radio button groups (`ring`, `forest`, `convex` cap, and `gills`) to classify mushrooms and display the matched result, with input validation, a **Clear** button, and a **Cancel** button to return to `Welcome`.
  **"BicycleRental.java"** — Hourly rental cost calculator that takes a `StartTime` (`0`–`23`) and `EndTime` (`1`–`24`), validates numeric ranges and time order, calculates total cost at **500 RWF per hour**, and displays the total alongside the number of hours.

---

 Features

 1. Welcome Launcher
.Central hub with direct buttons for **BicycleRental** and **MushroomIdentifier**.
.Clean exit control (`System.exit(0)`).

 2. Mushroom Identifier
.Requires answers across four yes/no characteristic prompts:
  1. Does your mushroom have a ring?
  2. Does your mushroom grow in a forest?
  3. Does your mushroom have a convex cap?
  4. Does your mushroom have gills?
.Prompts with dialog alerts if any question is left unanswered.
.Identifies specific combinations (such as *Amanita Mushroom*, *Button Mushroom (Champignon)*, *Chanterelle Mushroom*, .Oyster Mushroom*, and *Porcini Mushroom*) or reports `"Unknown Mushroom - Not Identified"`.
.Includes **Execute**, **Clear** (resets radio selections and output field), and **Cancel** (returns to `Welcome`).

3. Bicycle Rental Calculator
.Accepts integer start and end hours (`StartTime` between `0` and `23`, `EndTime` between `1` and `24`, with `EndTime > StartTime`).
.Validates empty fields, out-of-range hours, and non-numeric input (`NumberFormatException`).
.Computes rental fees at **500 RWF/hour** and formats output as `<total> RWF (<hours> hours)`.
.Includes **Calculate**, **Clear**, and **Cancel** (returns to `Welcome`).

---
