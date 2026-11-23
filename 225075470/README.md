# GreenWheel Hub

A small Java Swing app for my lab.

## Files

- MainMenu.java - main menu (start here)
- RentalForm.java - bicycle rental price
- MushroomForm.java - mushroom identifier
- ProjectForm.java - student project form

Keep all four files in the same folder.

## Compile and run

```
javac *.java
java MainMenu
```

To test the project form alone: `java ProjectForm`

## What it does

- **Rental:** enter start hour (0-23) and end hour (1-24). The program shows the total in RWF.
- **Mushroom:** answer up to 3 Yes/No questions and it names the mushroom.
- **Project:** Submit checks that Reg No and Project Name are filled.
- Every form has a Cancel button that closes only that form.

## Quick tests

- Rental 6 to 9 = 2500 RWF
- Rental 0 to 24 = 21500 RWF
- Mushroom: Yes, No = Coprin chevelu
