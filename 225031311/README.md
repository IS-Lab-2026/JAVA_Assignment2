# JAVA Assignment 2

## Overview
This project contains two Java Swing GUI programs in one project:
1. **Bicycle Rental System** - Calculates rental price based on time used
2. **Mushroom Identification System** - Helps identify a mushroom

Both programs are opened from a main Welcome menu.

## How To Run
1. Open the project in NetBeans
2. Run `GUI_assign.java` - This is the main file that starts the program
3. The Welcome screen will appear
4. Choose Bicycle Rental or Mushroom Identification

## Files In This Project

| File | What It Does |
| :--- | :--- |
| `GUI_assign.java` | Main class. Starts the whole program |
| `Welcome.java` / `Welcome.form` | First screen. Main menu with 2 buttons to open the two programs |
| `BicycleRental.java` / `BicycleRental.form` | Bicycle Rental calculator |
| `MushroomIdentification.java` / `MushroomIdentification.form` | Mushroom Identification program |

---

## 1. Bicycle Rental System

**What it does:**
Calculates how much a customer must pay for renting a bicycle, based on how long they used it.

**How it works:**
1. User types **StartTime** - when they took the bike
2. User types **EndTime** - when they returned the bike
3. User clicks **Calculate**
4. Program calculates:
   Time Used = EndTime - StartTime
   Total Amount = Time Used x 500 RWF per hour
5. Program shows the total amount

**Example:**
StartTime = 3
EndTime = 5
Time Used = 2 hours
Total = 2 x 500 = 1000 RWF

**Buttons:**
- `Calculate` - Calculates total price from time used
- `Clear` - Clears all fields
- `Cancel` - Closes the window

**Price:**
- Fixed price: **500 RWF per hour**

---

## 2. Mushroom Identification System

**What it does:**
Helps the user identify a mushroom by selecting its features.

**How it works:**
1. User opens Mushroom Identification from the Welcome screen
2. User selects the features of the mushroom shown on the form
3. User clicks the button to identify
4. Program shows information / identification result for that mushroom

**Buttons:**
- Identify / Check - Shows the result
- Clear - Clears the selection
- Back / Cancel - Returns to Welcome screen

---

## Tools Used
- Language: Java
- GUI: Java Swing (JFrame, JButton, JTextField, JLabel)
- IDE: NetBeans


   
