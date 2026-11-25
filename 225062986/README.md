
# Javaswing project

This is my Java swing project. It is a small program with windows (a GUI) made using Java Swing.

## What it does

When you open it, you see a welcome window with three buttons:

- **Rental System**: you type the hour the rental starts and the hour it ends, and it tells you how much to pay.
- **Mushroom Identifier**: you think of a mushroom, answer a few Yes or No questions, and the program guesses it.
- **Exit**: closes the program.

Each window has a **Cancel** button that takes you back.

## How the rental prices work

The price depends on the time of day:

- Early morning and night (0 to 7 and 21 to 24): 500 RWF per hour
- Morning and evening (7 to 14 and 19 to 21): 1000 RWF per hour
- Afternoon (14 to 19): 1500 RWF per hour

Example: renting from 6 to 9 costs 2500 RWF.

## How to run it

1. Keep all the files in the same folder.
2. Open the terminal in that folder.
3. Type `javac *.java` and press Enter.
4. Type `java MainForm` and press Enter.

## Things to remember

- In the rental window, type whole numbers only (no decimals).
- The start hour must be smaller than the end hour.
- The mushroom program asks 3 questions at most.

## About me

Name: Agasaro Sylivie Benigne
Reg No: 225062986
University of Rwanda, Information Systems
