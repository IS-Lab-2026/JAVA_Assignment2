# Bicycle Rental & Mushroom Identifier System

A Java Swing desktop application that combines two services behind one welcome screen:

1. **Bicycle Rental Shop**: calculates a rental fee in RWF from a start hour and an end hour.
2. **Mushroom Identifier**: identifies one of six mushrooms from a series of Yes/No answers.

The project turns two console programs (`Scenario1` and `MushroomIdentifier`) into graphical interfaces built with the NetBeans GUI builder.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [How to Run](#how-to-run)
- [1. Welcome Frame](#1-welcome-frame)
- [2. Bicycle Rental Frame](#2-bicycle-rental-frame)
- [3. Mushroom Identifier Frame](#3-mushroom-identifier-frame)
- [Navigation Flow](#navigation-flow)
- [Input Validation](#input-validation)

---

## Project Structure

| Frame | Purpose | Based on |
|---|---|---|
| Welcome Frame | Entry point; lets the user choose a service or exit | None (navigation only) |
| Bicycle Rental Frame | Rental fee calculator | `Scenario1.java` |
| Mushroom Identifier Frame | Mushroom identification | `MushroomIdentifier.java` |

> Rename the class names above to match your own files (for example `WelcomeForm`, `BicycleRental`, `MushroomIdentifierForm`).

## Requirements

- Java JDK 8 or later
- NetBeans IDE (recommended, because the frames were designed with its GUI builder)
- Maven (the package names `com.mycompany...` come from the NetBeans Maven template)

## How to Run

1. Open the project in NetBeans.
2. Right-click the **Welcome frame** class and choose **Run File** (or set it as the main class).
3. Choose a service from the welcome screen.

---

## 1. Welcome Frame

The first screen the user sees. It introduces the system and lets the user pick a service.

### Components

| Component | Type | Description |
|---|---|---|
| Title | Label | "WELCOME TO OUR SYSTEM" |
| Description | Label | Short explanation of the two services |
| Choose service | Label | Prompts the user to pick an option |
| Bicycle Rental Shop | Button | Opens the Bicycle Rental frame |
| Mushroom Identifier | Button | Opens the Mushroom Identifier frame |
| Exit | Button | Closes the application |

### Behaviour

- **Bicycle Rental Shop**: opens the Bicycle Rental frame and closes the welcome frame.
- **Mushroom Identifier**: opens the Mushroom Identifier frame and closes the welcome frame.
- **Exit**: ends the program with `System.exit(0)`.

---

## 2. Bicycle Rental Frame

Calculates the total rental fee for a time range within one day.

### Components

| Component | Type | Description |
|---|---|---|
| Start Time | Text field | Starting hour (whole number, 0 to 23) |
| End Time | Text field | Ending hour (whole number, 1 to 24) |
| Calculate | Button | Computes the fee and shows it in Result |
| Result | Text field (read-only) | Displays hours rented and the total fee |
| Back | Button | Returns to the Welcome frame |
| Cancel | Button | Clears all fields |

### Pricing Rules

The fee is charged **per hour**, depending on the hour of the day:

| Time band | Rate per hour |
|---|---|
| 00h to 07h and 21h to 24h | 500 RWF |
| 07h to 14h and 19h to 21h | 1000 RWF |
| 14h to 19h | 1500 RWF |

### How the Calculation Works

1. Read the start and end hours from the text fields.
2. Validate the input (see [Input Validation](#input-validation)).
3. Loop through each hour from `start` up to (but not including) `end`.
4. Add the rate for that hour to the total.
5. Show the result in the Result field.

### Example

| Start | End | Hours charged | Total |
|---|---|---|---|
| 1 | 4 | 1, 2, 3 (all 500 RWF) | **1500 RWF** |
| 6 | 9 | 6 (500) + 7 (1000) + 8 (1000) | **2500 RWF** |
| 13 | 16 | 13 (1000) + 14 (1500) + 15 (1500) | **4000 RWF** |

---

## 3. Mushroom Identifier Frame

Identifies a mushroom from the user's Yes/No answers.

### Components

| Component | Type | Description |
|---|---|---|
| Choose mushroom type | Dropdown | The mushroom the user has in mind |
| Does it have a ring? | Dropdown (Yes/No) | Question 1 |
| Does it grow in forest? | Dropdown (Yes/No) | Asked when the mushroom has a ring |
| Does it have a convex cup? | Dropdown (Yes/No) | Asked on the remaining branches |
| Does it have gills? | Dropdown (Yes/No) | Asked when the mushroom has no ring |
| Identify | Button | Runs the decision logic |
| Result | Text field (read-only) | Displays the identified mushroom |
| Back | Button | Returns to the Welcome frame |
| Cancel | Button | Resets all dropdowns and clears Result |

### Supported Mushrooms

- Agaric jaunissant
- Amanite tue-mouche
- Cepe de bordeaux
- Coprin chevelu
- Girolle
- Pied bleu

### Decision Logic

```
Ring?
├── Yes
│   ├── Grows in forest? Yes -> Amanite tue-mouche
│   └── Grows in forest? No
│       ├── Convex cup? Yes -> Agaric jaunissant
│       └── Convex cup? No  -> Coprin chevelu
└── No
    ├── Gills? No -> Cepe de bordeaux
    └── Gills? Yes
        ├── Convex cup? Yes -> Pied bleu
        └── Convex cup? No  -> Girolle
```

### Notes on the Interface

- Not every question matters on every path. For example, "forest" is only used when the mushroom has a ring. The unused dropdowns can be disabled automatically so the interface follows the same flow as the console program.
- The "Choose mushroom type" dropdown is optional. It can be used to compare the user's choice against the program's result.
- If the result is **Amanite tue-mouche** (toxic), the Result text can be shown in red as a warning.

---

## Navigation Flow

```
                 ┌────────────────┐
                 │  Welcome Frame │
                 └───────┬────────┘
          ┌──────────────┼──────────────┐
          ▼              ▼              ▼
   Bicycle Rental   Mushroom         Exit
      Frame        Identifier       (closes app)
          │          Frame
          │              │
          └──── Back ────┘
                 │
                 ▼
           Welcome Frame
```

---



## Input Validation

### Bicycle Rental Frame

| Condition | Message |
|---|---|
| Empty field or non-numeric input (letters, decimals) | Whole numbers only |
| Start less than 0 or greater than 23 | Invalid range |
| End less than 1 or greater than 24 | Invalid range |
| Start greater than or equal to End | Invalid range |

### Mushroom Identifier Frame

Inputs come from dropdowns, so invalid text input is not possible.

---

