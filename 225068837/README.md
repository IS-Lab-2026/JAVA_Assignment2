Bicycle Rental GUI (Rental.java)

A desktop application built with Java Swing in Apache NetBeans (package com.mycompany.gui_main) that determines bicycle rental charges according to the entered start and end hours.

Capabilities

Start & End Time Entry: Users provide the rental start and end hours (Txtstart and TxtEnd).
Hourly Rate Computation: The total amount owed is calculated across the different time-based pricing bands and shown in TxtPay.
Input Checking: "Invalid" is shown whenever the hour range is illegal, the start time is later than the end time, or a value is not numeric.
Navigation: A Cancel button (btncancel) takes the user back to the Welcome screen.
Pricing Bands (Each Hour Interval [i, i+1))
500 per hour: 00:00–07:00 (0 <= i < 7) and 21:00–24:00 (21 <= i < 24)
1,000 per hour: 07:00–14:00 (7 <= i < 14) and 19:00–21:00 (19 <= i < 21)
1,500 per hour: 14:00–19:00 (14 <= i < 19)
Project Structure
— Destination frame opened when clicking Cancel

How to Run

Open the GUI_main project in Apache NetBeans.
Make sure no stray methods sit outside public class Rental and no braces are unmatched.
Run Rental.java (or the project main class).
Mushroom Identification GUI (Mushroom.java)
An interactive Java Swing decision-tree form in Apache NetBeans (package com.mycompany.gui_main) that determines mushroom species from Yes / No trait choices.

Capabilities
Guided Yes/No Questions: Radio buttons cover ring presence, forest habitat, convex cup shape, and gills.
Result Output: The matched mushroom name appears in the Mushroom name field—or "Invalid input" if the selection path is incomplete.
Selection Controls: Radio buttons can be grouped with ButtonGroups, selections are limited, answers can be cleared, and Cancel returns to Welcome.
Decision Paths
Ring = Yes + Forest = Yes
→
Amanite tue-mouche.
Ring = Yes + Forest = No + Convex cup = Yes
→
Agaric Jaunissant.
Ring = Yes + Forest = No + Convex cup = No
→
Coprin chevelu
Ring = No + Gills = Yes + Convex cup = Yes
→
Pied bleu
Ring = No + Gills = Yes + Convex cup = No
→
Girolle
Ring = No + Gills = No
→
Cepe de bordeau
How to Run
Open the GUI_main project in Apache NetBeans.
Assign each Yes/No radio button pair to its own ButtonGroup in Design view.
Run Mushroom.java and choose options before clicking Execute.