# JAVA Assignment 2

Reg number: 225028767

This project contains two Java Swing programs connected together in one main Welcome screen:
1. Bicycle Rental System
2. Mushroom Identification System

---

## 1. Welcome Screen (`Welcome.java`)

When the program starts, the Welcome window opens with three buttons:
- **Bicycle Rental**: opens the Bicycle Rental window.
- **Mushroom Identification**: opens the Mushroom Identifier window.
- **Exit**: closes the program.

Inside both applications, clicking **Cancel** closes that window and takes you back to the Welcome screen.

---

## 2. Bicycle Rental (`Rental.java`)

### Description
This program calculates the total amount a customer pays for renting a bicycle between a starting hour and an ending hour.
The price per hour changes depending on the time of day:

- **00:00 - 07:00**: 500 RWF per hour
- **07:00 - 14:00**: 1,000 RWF per hour
- **14:00 - 19:00**: 1,500 RWF per hour
- **19:00 - 21:00**: 1,000 RWF per hour
- **21:00 - 24:00**: 500 RWF per hour

### Inputs
- Start Time: integer between 0 and 23
- End Time: integer between 1 and 24
- Start time must be less than end time.

### Example
- Starting hour: 6
- Ending hour: 9
- 6 to 7 = 500 RWF
- 7 to 8 = 1,000 RWF
- 8 to 9 = 1,000 RWF
- Total payment = 2,500 RWF

### Buttons
- **Calculate**: validates the input numbers and calculates the total cost.
- **Clear**: clears the text boxes.
- **Cancel**: returns back to the Welcome screen.

---

## 3. Mushroom Identification (`Mushroom.java`)

### Description
This program identifies a mushroom species by asking a few Yes/No questions using radio buttons.

### Questions
1. Does your mushroom have a ring?
2. Does your mushroom grow in forest?
3. Does your mushroom have a convex cup?
4. Does your mushroom have gills?

### Mushrooms Identified
- **Amanite tue-mouche**: Ring = Yes, Forest = Yes
- **Agaric Jaunissant**: Ring = Yes, Forest = No, Convex cup = Yes
- **Coprin chevelu**: Ring = Yes, Forest = No, Convex cup = No
- **Pied bleu**: Ring = No, Gills = Yes, Convex cup = Yes
- **Girolle**: Ring = No, Gills = Yes, Convex cup = No
- **Cepe de bordeaux**: Ring = No, Gills = No

### Buttons
- **Execute**: checks the answers and displays the mushroom name.
- **Clear**: resets all selections.
- **Cancel**: returns back to the Welcome screen.

---