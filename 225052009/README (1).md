# Bicycle Rental and Mushroom Programs

This folder contains two Java Swing programs and this README file, which explains their purpose and main parts.

## 1. Bicycle_rental.java

The `Bicycle_rental` program calculates the total cost of renting a bicycle based on the starting and ending times entered by the user.

### How it works

1. The program displays two text fields. The user enters a starting time from `0` to `23` and an ending time from `1` to `24`.
2. When the user clicks **Calculate**, the program converts both entries into integers.
3. It checks that the values are within the allowed ranges and that the ending time is later than the starting time. Invalid values produce an error message.
4. A `for` loop checks every rented hour and adds the rate for that hour:

   | Time range | Cost per hour |
   |---|---:|
   | 00:00–06:59 | 500 RWF |
   | 07:00–13:59 | 1,000 RWF |
   | 14:00–18:59 | 1,500 RWF |
   | 19:00–20:59 | 1,000 RWF |
   | 21:00–23:59 | 500 RWF |

5. The total cost is displayed in a `JOptionPane` message dialog.
6. **Go to Mushroom** opens the Mushroom window. **Quit** asks the user to confirm before closing the application.

### Main Java concepts used

- `JFrame`, `JPanel`, `JLabel`, `JTextField`, and `JButton` create the graphical user interface.
- `BorderLayout` and `GridLayout` arrange the components.
- `addActionListener()` responds to button clicks.
- `Integer.parseInt()` converts text into whole numbers.
- `if`, `else if`, and `else` select the hourly rate.
- A `for` loop calculates the cost hour by hour.
- `try` and `catch` handle entries that are not valid integers.
- `JOptionPane` displays errors, results, and the quit confirmation.

## 2. Mushroom.java

The intended Mushroom program identifies one mushroom from six possible types by asking the user Yes/No questions. The intended design, as described in the request, uses `JOptionPane.showConfirmDialog()` for the questions and conditional statements to decide which mushroom matches the answers. It should identify the mushroom using no more than three questions.

**Important:** The code pasted under “Mushroom codes” was an exact copy of the Bicycle Rental program. It did not contain mushroom names, questions, characteristics, or identification conditions. Therefore, `Mushroom.java` is currently a starter window, not a completed mushroom identifier. Its **Identify Mushroom** button explains what information is missing. The actual six mushroom types and their distinguishing characteristics are needed to complete the decision logic without inventing answers.

The starter window already includes buttons to return to Bicycle Rental and to quit the application.

## 3. README.md

This file explains the purpose of both programs, how the Bicycle Rental calculation works, the Java concepts used, and the current status of the Mushroom program.

## Running the programs

These files use the package name:

```java
package com.mycompany.quitbuttonexample;
```

In a standard Maven Java project, place the two `.java` files in:

```text
src/main/java/com/mycompany/quitbuttonexample/
```

Keep `README.md` in the main project folder. Open the project in your Java IDE and run `Bicycle_rental.java` or `Mushroom.java`.

The two Java files are separate runnable entry points. Both use Java Swing, which is included with the standard Java Development Kit (JDK).
