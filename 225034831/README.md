
# Bicycle Rental & Mushroom Identifier (Java Swing)

Package: `com.mycompany.bicyclemushroom`
Source folder: `src/com/mycompany/bicyclemushroom/`

Program flow:

```
Bicyclemushroom (main)
        |
   TRAVELAGENCY  (welcome page)
     |        |         |
 Bicyclerental  mushroom  EXIT
     |             |
   Cancel        Cancel   -> back to TRAVELAGENCY
```

---

## 1. Bicyclemushroom.java (start-up class)

**Purpose:** contains `main`. It starts the program by showing the welcome form.

**How it works:** `main` calls `java.awt.EventQueue.invokeLater(...)` to create and show `TRAVELAGENCY`.

**Run this file to start the whole project.**

---

## 2. TRAVELAGENCY.java (welcome / landing page)

**Purpose:** first screen the user sees: "WELCOME TO MY PROJECT".

| Component | Variable | What it does |
|---|---|---|
| Button "Bicycle rental" | `btnbicycle` | Opens the `Bicyclerental` form and closes the welcome form |
| Button "Mushroom" | `btnmushroom` | Opens the `mushroom` form and closes the welcome form |
| Button "EXIT" | `btnexit` | Closes the whole program (`System.exit(0)`) |

---

## 3. Bicyclerental.java (bicycle rental calculator)

**Purpose:** calculates what a customer pays for a rental (Problem 1 of Lab 1).

**Inputs:** start time (hour) and end time (hour), whole numbers only.

| Component | Variable | What it does |
|---|---|---|
| Text field "Start time" | `txtstart` | Start hour |
| Text field "Endtime" | `txtend` | End hour |
| Button "Calculate amount" | `btncalculate` | Calculates the total cost |
| Result box | `txtanswerbicycle` | Shows the total or an error message |
| Button "Cancel" | `btncancel1` | Goes back to the welcome form |

**Rules:**
- Start must be 0-23, end must be 1-24, and start must be less than end, otherwise the result shows `Invalid time.`
- Text that is not a whole number shows `Please enter valid numbers for start and end time.`
- Each rented hour is charged by its own band, then all hours are added:

| Hours | Rate per hour |
|---|---|
| 0-7 and 21-24 | 500 RWF |
| 7-14 and 19-21 | 1000 RWF |
| 14-19 | 1500 RWF |

**Examples:** 6 to 8 = 500 + 1000 = **1500 RWF**; 13 to 15 = 1000 + 1500 = **2500 RWF**; 0 to 24 = **21500 RWF**.

---

## 4. mushroom.java (mushroom identifier)

**Purpose:** guesses which of the six mushrooms the user is thinking of (Problem 2 of Lab 1). It asks at most three of the four questions.

**Questions (each answered with Yes / No radio buttons):**

 Question  Variables 

Does it have gills?  `radiogillsyes`, `radiogillsno` 
 Does it grow in a forest?  `radioforestyes`, `radioforestno` 
 Does it have a ring? `radioringyes`, `radioringno` 
 Does it have a convex cup?  `radioconvexyes`, `radioconvexno` 

 Component Variable  What it does 
 Button "Action"  `btnaction`  Works out the mushroom 
 Result box  `txtanswermushroom`  Shows the mushroom or a "please select..." message 
 Button "Cancel"  `btncancel2`  Goes back to the welcome form

**Decision logic:**
- No gills -> **Cepe de Bordeaux**
- Gills, does not grow in a forest (meadow):
  - convex cup yes -> **Agaric Jaunissant**
  - convex cup no -> **Coprin chevelu**
- Gills, grows in a forest:
  - ring yes -> **Amanite tue-mouche**
  - ring no and convex cup yes -> **Pied bleu**
  - ring no and convex cup no -> **Girolle**
javac -d bin src/com/mycompany/bicyclemushroom/*.java
java -cp bin com.mycompany.bicyclemushroom.Bicyclemushroom
```
