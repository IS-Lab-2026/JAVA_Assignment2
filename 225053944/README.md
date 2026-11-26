NAME: NIYUBAHWE Ben Deolis      225053280
# Bicycle & Mushroom Java App

A clean, interactive Java Swing desktop application that combines two everyday utilities into one unified interface: a **Bicycle Rental Cost Calculator** and a step-by-step **Mushroom Identifier**

## 1. Project Overview

The Bicycle & Mushroom Utility Suite provides a central dashboard allowing users to switch effortlessly between two distinct modules:

* **Main Dashboard (`Bicycle_Mushroom`):** Acts as the central home screen where users choose which utility to launch. Both tools include **Back** navigation to return smoothly to the dashboard.
* **Bicycle Rental Cost Calculator (`Bicycle`):** Computes total rental fees in **Rwandan Francs (RWF)** using dynamic time-of-day pricing tiers.
* **Interactive Mushroom Identifier (`Mushroom`):** Uses a step-by-step decision tree to identify six mushroom species based on physical and habitat traits.

---

## 2. Bicycle Rental Cost Calculator

Users enter a starting hour (`0–23`) and an ending hour (`1–24`) using 24-hour whole-number format. The calculator iterates hour by hour from start to end and applies the corresponding rate tier:

| Time Window | Tier Name | Hourly Rate |
| :--- | :--- | :--- |
| `00:00 – 07:00` | Off-Peak Hours | 500 RWF/hr |
| `07:00 – 14:00` | Standard Hours | 1,000 RWF/hr |
| `14:00 – 19:00` | Peak Hours | 1,500 RWF/hr |
| `19:00 – 21:00` | Standard Hours | 1,000 RWF/hr |
| `21:00 – 24:00` | Off-Peak Hours | 500 RWF/hr |

### Input Validation Rules
* Both inputs must be valid whole integers.
* Start time must be between `0` and `23`; end time must be between `1` and `24`.
* Start time must be strictly earlier than end time (`start < end`).

---

## 3. Interactive Mushroom Identifier

The mushroom module guides users through up to four **Yes / No** questions using a Swing `CardLayout` interface backed by a history stack (`Deque`). Clicking **Back** undoes the most recent answer so users can correct mistakes without restarting, and clicking **Start Again** resets the entire session.

| Identified Species | Has Gills? | Forest Habitat? | Has Ring? | Convex Cap? |
| :--- | :--- | :--- | :--- | :--- |
| **Cèpe de Bordeaux** | No | — | — | — |
| **Amanite tue-mouches** | Yes | Yes | Yes | — |
| **Pied bleu** | Yes | Yes | No | Yes |
| **Girolle** | Yes | Yes | No | No |
| **Agaric jaunissant** | Yes | No | — | Yes |
| **Coprin chevelu** | Yes | No | — | No |

---

## 4. Project Architecture & Files

```text
com/mycompany/bicycle_mushroom/
├── Bicycle_Mushroom.java   # Main entry point & home menu JFrame
├── Bicycle_Mushroom.form   # NetBeans GUI Builder layout metadata
├── Bicycle.java            # Bicycle rental cost calculator window & pricing logic
└── Mushroom.java           # Decision-tree wizard, step history stack & summary
```

| File Name | Role & Responsibility |
| :--- | :--- |
| `Bicycle_Mushroom.java` | Main entry point (`main` method) and home menu `JFrame` |
| `Bicycle_Mushroom.form` | NetBeans GUI Builder XML layout metadata for the home screen |
| `Bicycle.java` | Rent Cost Calculator window, input validation, and hourly billing |
| `Mushroom.java` | Decision-tree wizard, step history stack, and feature summary |

---

## 5. How to Run the Application

### System Requirements
* **Java Development Kit (JDK) 16 or newer** (required for Java `record` and switch expression syntax in `Mushroom.java`).
* **Apache NetBeans IDE** (recommended) or any standard Java terminal environment.

### Option 1: Running via Apache NetBeans
1. Open **Apache NetBeans** and select **File > Open Project**.
2. Locate and select the `Bicycle_Mushroom` project directory.
3. Right-click `Bicycle_Mushroom.java` in the Projects pane and select **Run File** (or press `Shift + F6`).

### Option 2: Running via Command Line / Terminal
1. Open a terminal inside the project's `src/main/java` folder.
2. Compile the source files:
   ```bash
   javac com/mycompany/bicycle_mushroom/*.java
   ```
3. Run the main class:
   ```bash
   java com.mycompany.bicycle_mushroom.Bicycle_Mushroom




