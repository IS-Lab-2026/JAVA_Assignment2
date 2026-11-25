# Java Assignment

**Student:** ISHIMWE Divine  
**Registration number:** 225038614  
**Language:** Java

## Open in NetBeans

1. Create or open a Java Application project using JDK 17 or later.
2. Copy the nine Java and form files from this folder into the project's source
   directory (for Maven, `src/main/java`). Keep each form beside its matching Java file.
3. Under **Source Packages → <default package>**, open
   `Welcome.java`, `BicycleRentalForm.java`, or `MushroomIdentificationForm.java`.
4. Select **Design** to edit the interface, or double-click a button to jump
   to its handler in **Source**. Use **Run File** (Shift+F6) to launch a form.
5. To launch the whole application, right-click `GUI_assign.java` and choose
   **Run File**. The Welcome window opens either exercise. Its **Exit** button
   closes the application.

`BicycleRental.java` and `MushroomIdentification.java` are the original console
programs. Either can also be launched with **Run File**.

## Bicycle Rental

Enter the start hour (0–23) and end hour (1–24) on the same day. The program
charges each hour from the start up to the end hour. For example, 06:00 to
08:00 costs 1,500 RWF.

| Hours | RWF per hour |
| --- | ---: |
| 00:00–07:00 and 21:00–24:00 | 500 |
| 07:00–14:00 and 19:00–21:00 | 1,000 |
| 14:00–19:00 | 1,500 |

## Mushroom Identification

Answer the yes-or-no questions about gills, habitat, a ring, and cap shape.
The exercise can display Cèpe de Bordeaux, Agaric jaunissant, Coprin chevelu,
Amanite tue-mouche, Pied bleu, or Girolle.

The console program practices Scanner input, nested if-else statements,
and case-insensitive string comparison. Enter only yes or no in that version.
This classroom exercise must never be used to judge whether a mushroom is safe to eat.
