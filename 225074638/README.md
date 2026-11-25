# Java Graphical User Interface (GUI) - Lab 2 Assignment

**Registration Number:** [225074638]  
**Package:** `com.mycompany.gui`  
**Development Environment:** Apache NetBeans / Java Swing (`javax.swing`)

---

## 1. Project Overview
This folder contains my submission for the **Java GUI Lab 2 Assignment**. The application demonstrates event-driven programming, multi-window navigation, user input validation, and decision-making logic using Java Swing (`JFrame`, `JLabel`, `JTextField`, `JRadioButton`, `ButtonGroup`, and `JButton`).

From a central Welcome dashboard, the user can navigate between two interactive desktop utilities:
1. **Bicycle Rental Cost Calculator**
2. **Mushroom Species Classifier**

---

## 2. Folder Structure & File Descriptions
* **`GUI.java`**: The main entry point of the application containing the `main` method, which launches the `Welcome` window.
* **`Welcome.java` & `Welcome.form`**: The central navigation screen allowing the user to select either the Bicycle Rental or Mushroom Identifier tool.
* **`Bicycle_object.java` & `Bicycle_object.form`**: A GUI calculator that computes bicycle rental fees in Rwandan Francs (RWF) based on hourly usage and time-of-day pricing tiers.
* **`Mushroom_object.java` & `Mushroom_object.form`**: A rule-based classifier using grouped radio buttons to identify mushroom species from four physical and habitat traits.
* **`README.md`**: Documentation explaining the structure, logic, and execution steps of the project.

---

## 3. Application Logic & Features

### A. Bicycle Rental Calculator (`Bicycle_object`)
* Accepts **Start Time** (`0–23`) and **End Time** (`1–24`) from the user.
* Validates that input values are numeric and within valid daily bounds (`start < end`).
* Calculates the total cost hour-by-hour using the following pricing structure:
  * **Off-Peak Hours** (`00:00–07:00` and `21:00–24:00`): **500 RWF / hour**
  * **Mid-Day & Evening Hours** (`07:00–14:00` and `19:00–21:00`): **1,000 RWF / hour**
  * **Peak Hours** (`14:00–19:00`): **1,500 RWF / hour**

### B. Mushroom Classifier (`Mushroom_object`)
* Evaluates four **Yes/No** traits via `ButtonGroup` radio buttons:
  1. Presence of a ring
  2. Presence of gills
  3. Convex cap shape
  4. Forest habitat
* Identifies six mushroom species (*Cepe de Bordeaux*, *Agaric jaunissant*, *Amanite tue-mouche*, *Coprin chevelu*, *Girolle*, and *Pied bleu*) or alerts the user if selections are incomplete.

---

## 4. How to Compile and Run
1. Open **Apache NetBeans** (or any Java IDE supporting JDK 17+).
2. Place all `.java` and `.form` files inside a package named `com.mycompany.gui`.
3. Right-click **`GUI.java`** and select **Run File** (`Shift + F6`).
4. Use the buttons on the **Welcome** window to test both applications, and click **Cancel** inside either window to return to the main menu.
