# Bicycle Rental Calculator (`BicycleRental.java`)

A Java Swing desktop application (generated in NetBeans under `com.mycompany.didiproject1`) that calculates the total rental cost of a bicycle in **RWF** based on hourly time-of-day tiers.

## Features

- **Hourly Rate Calculation:** Loops through each hour from `Start` (inclusive) to `End` (exclusive) and sums the applicable hourly rate.
- **Input Range Validation:** Checks that `Start` is between `0` and `23`, `End` is between `1` and `24`, and `Start` is strictly less than `End`.
- **Navigation on Cancel:** Hides the `BicycleRental` window and opens `WelcomeDidi`.

## Hourly Pricing Schedule

Each hour slot `[hour, hour + 1)` is billed according to its starting hour (`hour` from `0` to `23`):

| Time Slot (`hour` to `hour + 1`) | Hourly Condition (`hour`) | Rate (RWF) |
| :--- | :--- | :--- |
| `00:00 – 07:00` | `hour < 7` | **500 RWF** |
| `07:00 – 14:00` | `7 <= hour < 14` | **1,000 RWF** |
| `14:00 – 19:00` | `14 <= hour < 19` | **1,500 RWF** |
| `19:00 – 21:00` | `19 <= hour < 21` | **1,000 RWF** |
| `21:00 – 24:00` | `hour >= 21` | **500 RWF** |

## How to Use

1. Launch `BicycleRental` (either via its `main` method or from `WelcomeDidi`).
2. Enter a **Start** hour (`0`–`23`) in `txtstart` and an **End** hour (`1`–`24`) in `txtend` (24-hour format).
3. Click **Calculate** (`Btncalc`):
   - Valid inputs display `<totalCost> RWF` in `txtcost`.
   - Out-of-range or `start >= end` values display `Invalid time entered.` in `txtcost`.
4. Click **Cancel** (`Btncancel`) to return to `WelcomeDidi`.

## Project Structure & Notes

- **Package:** `com.mycompany.didiproject1`
- **Main Class:** `BicycleRental` (`javax.swing.JFrame`)
- **Related Class:** `WelcomeDidi` (referenced inside `BtncancelActionPerformed`)
- **NetBeans GUI Warning:** Avoid manually editing code inside `initComponents()` if using the NetBeans Matisse Form Editor, as it regenerates that block automatically.
- **Improvement Note:** Entering non-numeric text (such as letters or blank fields) into `txtstart` or `txtend` currently throws a `NumberFormatException` from `Integer.parseInt(...)`; wrapping parsing in a `try/catch` block can prevent runtime errors.



# Mushroom Classifier (`Mushroom.java`)

A Java Swing desktop application (generated in NetBeans under `com.mycompany.didiproject1`) that identifies mushroom species using a nested `if / else` decision tree based on four morphological and habitat traits selected via radio buttons.

## Features

- **Trait-Based Classification:** Evaluates selected radio button states in `BtnactionActionPerformed` and outputs the matching mushroom name into `txtmushroom`.
- **Grouped Radio Buttons:** Uses four `ButtonGroup` instances (`buttonGroup1` through `buttonGroup4`) so only one option (`Yes` or `No`) can be chosen per trait:
  - **Ring (`buttonGroup1`):** `rdoyesring` / `rdonoring` (*"Does it have ring?"*)
  - **Gills (`buttonGroup2`):** `rdoyesgills` / `rdonogills` (*"Does it have gills?"*)
  - **Forest Habitat (`buttonGroup3`):** `rdoyesforest` / `rdonoforest` (*"Does it grow in forest?"*)
  - **Convex Cup (`buttonGroup4`):** `rdoyescup` / `rdonocup` (*"Does it have convex cup?"*)
- **Navigation on Cancel:** Hides the `Mushroom` window and opens `WelcomeDidi`.

## Classification Decision Logic

`BtnactionActionPerformed` evaluates branches in the following order:

| Gills (`buttonGroup2`) | Forest (`buttonGroup3`) | Ring (`buttonGroup1`) | Convex Cup (`buttonGroup4`) | Output (`txtmushroom`) |
| :--- | :--- | :--- | :--- | :--- |
| `No` (`rdonogills`) | Any | Any | Any | `Cepe de bordeaux` |
| `Yes` (`rdoyesgills`) | `Yes` (`rdoyesforest`) | Any | `Yes` (`rdoyescup`) | `Agaric jaunissant` |
| `Yes` (`rdoyesgills`) | `Yes` (`rdoyesforest`) | Any | `No` / unselected | `Coprin chevelu` |
| `Yes` (`rdoyesgills`) | `No` / unselected | `Yes` (`rdoyesring`) | Any | `Amanite tue-mouches` |
| `Yes` (`rdoyesgills`) | `No` / unselected | `No` / unselected | `Yes` (`rdoyescup`) | `Pied bleu` |
| `Yes` (`rdoyesgills`) | `No` / unselected | `No` / unselected | `No` / unselected | `Girolle` |
| Neither gill radio selected | — | — | — | `Invalid answer` |

## How to Use

1. Launch `Mushroom` (via its `main` method or from `WelcomeDidi`).
2. Select **Yes** or **No** for the relevant traits on the form.
3. Click **Action** (`Btnaction`) to view the resulting classification in `txtmushroom`.
4. Click **Cancel** (`Btncancel`) to return to `WelcomeDidi`.

## Project Structure & Notes

- **Package:** `com.mycompany.didiproject1`
- **Main Class:** `Mushroom` (`javax.swing.JFrame`)
- **Related Class:** `WelcomeDidi` (referenced inside `BtncancelActionPerformed`)
- **NetBeans GUI Warning:** Avoid manually editing code inside `initComponents()` if using the NetBeans Matisse Form Editor, as it regenerates that block automatically.
- **Logic & Validation Notes:**
  - `rdonogills` is checked first, so selecting **No** for gills returns `Cepe de bordeaux` regardless of the other radio buttons.
  - Because `else` branches act as fallbacks when a `No` button is not explicitly checked, leaving a secondary radio button unselected is treated the same as selecting `No` along those paths; verifying each `ButtonGroup` has a selection before classifying can make selection checks explicit.
