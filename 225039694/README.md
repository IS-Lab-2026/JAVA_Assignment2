# Java Swing GUI Application: Bicycle Rental & Mushroom Classifier

**Student Registration Number:** `225039694`  
**Package:** `com.mycompany.byiclerental`  
**Framework:** Java Swing (NetBeans GUI Builder / Matisse)

---

## Project Overview

This repository contains a desktop GUI application built with Java Swing. It acts as a dual-module utility launched from a central navigation dashboard:
1. **Bicycle Rental Cost Calculator (`ByicleRental1`):** Computes hourly rental fees in Rwandan Francs (RWF) using tiered, time-of-day pricing rules.
2. **Mushroom Identification System (`mushroom`):** An expert-system style decision tree that classifies six species of mushrooms based on morphological and environmental traits.

---

## Project Structure & File Breakdown

NetBeans GUI Builder separates Swing forms into two synchronized files per window:
* **`.java` files:** Contain the event-handling logic, `main` entry points, and the auto-generated `initComponents()` layout code.
* **`.form` files:** XML metadata files used exclusively by the NetBeans Visual Designer to serialize component properties, layout constraints (`GroupLayout`), and event bindings.

---

## Line-by-Line Code Walkthrough

### 1. Application Entry Point: `ByicleRental.java`

This class serves as the primary driver for the application.

* **Lines 1–5:** Standard NetBeans license header and package declaration (`package com.mycompany.byiclerental;`), grouping all classes into the same namespace.
* **Lines 7–11:** Javadoc author tag (`@author D amour`) and the `public class ByicleRental` declaration.
* **Lines 13–17 (`main` method):** 
  * `public static void main(String[] args)`: The JVM entry point.
  * `Welcome wells = new Welcome();`: Instantiates the main menu `JFrame` object.
  * `wells.setVisible(true);`: Renders the `Welcome` window on the screen.
* **Lines 19–22 (`setVisible` stub):** An auto-generated placeholder method left over from IDE refactoring that throws an `UnsupportedOperationException` if called directly on this non-UI driver class.

---

### 2. Main Navigation Menu: `Welcome.java` & `Welcome.form`

This `JFrame` acts as the central router between the two modules.

#### UI & Layout (`Welcome.form` & `initComponents()`)
* **Window Setup:** Configures `EXIT_ON_CLOSE` so closing the main menu terminates the JVM process, and sets the initial screen coordinates to `(300, 250)`.
* **Components:** Initializes `jLabel1` ("welcome" header in 24pt bold Segoe UI) alongside two cyan-styled (`RGB: 51, 204, 255`) navigation buttons: `jButton1` ("BicycleRental") and `jButton2` ("Mushroom").
* **Layout Management:** Uses `javax.swing.GroupLayout` to define horizontal and vertical alignment gaps and padding across the frame.

#### Event Handlers (`Welcome.java`)
* **Lines 97–102 (`jButton1ActionPerformed`):**
  * `ByicleRental1 rental1 = new ByicleRental1();`: Instantiates the bicycle rental calculator frame.
  * `rental1.setVisible(true);`: Displays the calculator window.
  * `this.setVisible(false);`: Hides the current `Welcome` frame to prevent window clutter.
* **Lines 104–108 (`jButton2ActionPerformed`):**
  * `mushroom detect = new mushroom();`: Instantiates the mushroom identifier frame.
  * `detect.setVisible(true);`: Displays the classifier window.
  * `this.setVisible(false);`: Hides the `Welcome` frame.
* **Lines 113–138 (`main` method):** Configures the **Nimbus** Look and Feel via `UIManager` (catching reflection/UI exceptions) and schedules the frame creation safely on the Swing Event Dispatch Thread (EDT) using `java.awt.EventQueue.invokeLater`.

---

### 3. Bicycle Rental Calculator: `ByicleRental1.java` & `ByicleRental1.form`

This module calculates rental costs based on a 24-hour clock (`0` to `24`).

#### UI & Layout (`ByicleRental1.form` & `initComponents()`)
* **Labels & Inputs:** Uses `jLabel1` through `jLabel4` for titles (`BICYCLE RENTAL`, `START TIME`, `END TIME`, `TOTAL`). Three `JTextArea` components (`jTextArea1`, `jTextArea2`, `jTextArea3`) wrapped inside `JScrollPane` containers (with scrollbars disabled via `HORIZONTAL_SCROLLBAR_NEVER` and `VERTICAL_SCROLLBAR_NEVER`) act as single-line input/output boxes.
* **Action Buttons:** `jButton1` ("CALCURATE"), `jButton2` ("CLEAR"), and `jButton3` ("BACK").

#### Core Calculation Logic (`jButton1ActionPerformed` — Lines 167–196)
* **Lines 169–170:** Extracts raw text from the start and end fields and strips leading/trailing whitespace via `.trim()`.
* **Lines 172–179 (Exception Handling):** Declares `start` and `end` integers and attempts to parse the strings using `Integer.parseInt()`. If the user enters non-numeric text or leaves a field blank, the `catch (NumberFormatException e)` block catches it, displays `"Invalid input time."` in `jTextArea3`, and exits early via `return;`.
* **Lines 181–184 (Domain Validation):** Enforces valid 24-hour boundaries (`start` must be between `0` and `23`, `end` between `1` and `24`, and `start < end`). Fails gracefully with `"Invalid input time."` if violated.
* **Lines 186–194 (Tiered Rate Loop):**
  * Initializes `int totalCost = 0;`.
  * Iterates hour-by-hour from `start` up to `end - 1` (`for (int hour = start; hour < end; hour++)`).
  * **Off-Peak (`00:00–07:00` and `21:00–24:00`):** Adds `500` RWF per hour.
  * **Standard (`07:00–14:00` and `19:00–21:00`):** Adds `1000` RWF per hour.
  * **Peak (`14:00–19:00`):** Adds `1500` RWF per hour.
* **Line 196:** Formats the final sum and outputs it to `jTextArea3` (e.g., `"2500 RWF"`).

#### Utility & Navigation Handlers
* **Lines 200–204 (`jButton2ActionPerformed` — Clear):** Resets `jTextArea1`, `jTextArea2`, and `jTextArea3` to empty strings (`""`).
* **Lines 207–211 (`jButton3ActionPerformed` — Back):** Instantiates a new `Welcome` screen, sets it visible, and hides `ByicleRental1`.
* **Lines 262–264 (`dispouse` stub):** An unused method stub throwing `UnsupportedOperationException`.

---

### 4. Mushroom Identification System: `mushroom.java` & `mushroom.form`

This module implements a binary decision tree using Swing radio buttons to classify six mushroom species.

#### UI & Button Grouping (`mushroom.form` & `initComponents()`)
* **Mutual Exclusion (`ButtonGroup`):** Four `ButtonGroup` instances (`buttonGroup1` through `buttonGroup4`) pair each question's "yes" and "no" `JRadioButton`s (`jRadioButton1`/`2` for convex cap, `3`/`4` for ring, `5`/`6` for forest habitat, and `7`/`8` for gills). This guarantees the user cannot select both "yes" and "no" for the same trait.
* **Unused Table Component:** `jTable1` inside `jScrollPane2` is initialized in `initComponents()` as a non-visual/unplaced artifact in the `.form` file.

#### Decision Tree Logic (`jButton1ActionPerformed` — Lines 227–266)
* **Lines 228–231 (Root Validation):** Checks if neither `jRadioButton1` (yes) nor `jRadioButton2` (no) is selected for the convex cap question. If unselected, prompts the user in `jTextArea1` and returns.
* **Lines 235–248 (Branch 1 — Convex Cap = Yes):**
  * Validates that the ring question (`jRadioButton3` or `4`) is answered.
  * If **No Ring (`jRadioButton4`)**: Classifies as `"Pied bleu"`.
  * If **Has Ring (`jRadioButton3`)**: Validates the forest habitat question (`jRadioButton5` or `6`). Uses a ternary operator to assign `"Amanite tue-mouches"` (forest = yes) or `"Agaric jaunissant"` (forest = no).
* **Lines 249–263 (Branch 2 — Convex Cap = No):**
  * Validates that the ring question (`jRadioButton3` or `4`) is answered.
  * If **Has Ring (`jRadioButton3`)**: Classifies as `"Coprin chevelu"`.
  * If **No Ring (`jRadioButton4`)**: Validates the gills question (`jRadioButton7` or `8`). Uses a ternary operator to assign `"Girolle"` (gills = yes) or `"Cepe de bordeaux"` (gills = no).
* **Line 265:** Displays `"Your mushroom is: " + mushroom` inside `jTextArea1`.

#### Reset & Navigation Handlers
* **Lines 269–274 (`jButton2ActionPerformed` — Clear):** Calls `.clearSelection()` on all four `ButtonGroup` objects to reset the radio buttons and clears `jTextArea1`.
* **Lines 277–280 (`jButton3ActionPerformed` — Back):** Returns to the `Welcome` frame and hides the `mushroom` frame.

---
3. Ensure JDK 8 or higher is configured.
4. Run `ByicleRental.java` (which invokes the `Welcome` GUI frame).
