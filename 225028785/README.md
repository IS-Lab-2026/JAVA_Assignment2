# Java Assignment 2 — Graphical User Interfaces (Swing)

**Registration Number:** `225028785`  
**Course:** Information Systems Lab (IS-Lab-2026)  

## Overview
This project is a Java Swing desktop application featuring two interactive GUI tools accessible from a main welcome menu:
1. **Mushroom Guess Game:** An interactive yes/no decision-tree classifier that identifies mushroom species (*Agaric jaunissant*, *Amanite tue-mouche*, *Coprin chevelu*, *Pied bleu*, *Girolle*, and *Cèpe de Bordeaux*) based on physical traits.
2. **Bicycle Rental Calculator (BRC):** Calculates total bicycle rental fees based on start and end hours using time-of-day pricing tiers (500 RWF, 1,000 RWF, and 1,500 RWF per hour).

---

## Project Structure
```text
225028785/
├── Main.java       # Application entry point, event listeners, and business logic
├── MushGUI.java    # Swing GUI frames, panels, buttons, and text fields
└── README.md       # Project documentation
```

---

## How to Compile and Run

1. Open a terminal inside the `225028785` folder:
   ```bash
   cd 225028785
   ```
2. Compile all Java source files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java Main
   ```

---

## Features & Pricing Logic (BRC)
* **Off-Peak Hours (`00:00 – 07:00` & `21:00 – 24:00`):** 500 RWF / hour
* **Mid-Peak Hours (`07:00 – 14:00` & `19:00 – 21:00`):** 1,000 RWF / hour
* **Peak Hours (`14:00 – 19:00`):** 1,500 RWF / hour
