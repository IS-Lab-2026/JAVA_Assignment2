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
