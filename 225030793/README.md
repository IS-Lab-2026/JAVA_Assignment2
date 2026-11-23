# Bicycle Rental GUI (`Rental.java`)

A Java Swing desktop application built in Apache NetBeans (`com.mycompany.gui_main`) that calculates bicycle rental fees based on start and end hours.

## Features
- **Start & End Time Input:** Enter rental start and end hours (`Txtstart` and `TxtEnd`).
- **Hourly Rate Calculation:** Calculates total payment across time-of-day rate tiers and displays the result in `TxtPay`.
- **Input Validation:** Displays `"Invalid"` for invalid hour ranges, out-of-order start/end times, or non-numeric entries.
- **Navigation:** Includes a **Cancel** button (`btncancel`) to return to the `Welcome` screen.

## Rate Tiers (Per Hour Slot `[i, i+1)`)
- **500 per hour:** `00:00–07:00` (`0 <= i < 7`) and `21:00–24:00` (`21 <= i < 24`)
- **1,000 per hour:** `07:00–14:00` (`7 <= i < 14`) and `19:00–21:00` (`19 <= i < 21`)
- **1,500 per hour:** `14:00–19:00` (`14 <= i < 19`)

## Project Structure
 — Destination frame opened when clicking **Cancel**

## How to Run
1. Open the `GUI_main` project in Apache NetBeans.
2. Ensure there are no stray methods outside `public class Rental` or unmatched braces.
3. Run `Rental.java` (or the project main class).

# Mushroom Identification GUI (`Mushroom.java`)

An interactive Java Swing decision-tree form in Apache NetBeans (`com.mycompany.gui_main`) that identifies mushroom species from **Yes / No** trait selections.

## Features
- **Guided Yes/No Questions:** Radio buttons for ring presence, forest habitat, convex cup shape, and gills.
- **Result Output:** Displays the matched mushroom name—or `"Invalid input"` when a selection path is incomplete—in the **Mushroom name** field.
- **Selection Controls:** Supports grouping radio buttons with `ButtonGroup`s, limiting selections, clearing answers, and returning to `Welcome` via **Cancel**.

## Decision Paths
- **Ring = Yes + Forest = Yes** $\rightarrow$ *Amanite tue-mouche*.
- **Ring = Yes + Forest = No + Convex cup = Yes** $\rightarrow$ *Agaric Jaunissant*.
- **Ring = Yes + Forest = No + Convex cup = No** $\rightarrow$ *Coprin chevelu*
- **Ring = No + Gills = Yes + Convex cup = Yes** $\rightarrow$ *Pied bleu*
- **Ring = No + Gills = Yes + Convex cup = No** $\rightarrow$ *Girolle*
- **Ring = No + Gills = No** $\rightarrow$ *Cepe de bordeau*

## Project Structure
- `src/main/java/com/mycompany/gui_main/Mushroom.java` — Swing `JFrame` form, `btnexecuteActionPerformed`, and `btnCancelActionPerformed`.
- `src/main/java/com/mycompany/gui_main/Welcome.java` — Frame opened on **Cancel**.

## How to Run
1. Open the `GUI_main` project in Apache NetBeans.
2. Assign each Yes/No radio button pair to its own `ButtonGroup` in **Design** view.
3. Run `Mushroom.java` and select options before clicking **Execute**.
