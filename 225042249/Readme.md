
README – Mushroom Identification Program
Introduction

This is a simple Java program that helps users identify mushrooms by selecting radio buttons. After making a selection, the program displays the mushroom name in a text field.

How the Program Works

The program has two methods:

1. txtmushroomActionPerformed()

This method is empty for now. It does not perform any action.

2. txtactionActionPerformed()

This is the main part of the program. It checks which radio buttons the user has selected and displays the matching mushroom name.

Explanation of IF and ELSE

The program uses IF and ELSE to make decisions.

IF means the program checks whether something is true.
ELSE means the program does something different if the condition is false.

First, the program checks if the first radio button is selected.

If it is selected, it checks the other radio buttons.
If it is not selected, it moves to another group of conditions.

In the first group:

If radio button 7 is selected, it displays Amanite tue-mouche.
If radio button 5 is selected, it displays Agaric jaunissant.
If neither is selected, it displays Coprin chevelu.

In the second group:

If radio button 4 is selected, it displays Cèpe de Bordeaux.
If radio button 5 is selected, it displays Pied bleu.
If neither is selected, it displays Girolle.
Other Instructions Used
isSelected() checks if a radio button is selected.
setText() displays the mushroom name in the text field.
Mushroom Names

The program can display six mushroom names:

Amanite tue-mouche
Agaric jaunissant
Coprin chevelu
Cèpe de Bordeaux
Pied bleu
Girolle
Conclusion

This program uses IF and ELSE to check the user's choices and decide which mushroom name to display. It is a simple example of how Java makes decisions using conditions.

README – Parking Cost Calculator
How IF and ELSE Work

In my code, I used IF and ELSE to check the time and decide how much someone should pay for parking.

First, the program checks if the time entered is correct.

If the starting time is below 0 or above 23, it shows "Invalid time."
If the ending time is below 1 or above 24, it also shows "Invalid time."
If the starting time is bigger than or equal to the ending time, it shows "Invalid time."

If the time is correct, the program continues.

How the Parking Prices Work

The program checks each hour and gives it a price.

IF the hour is before 7 AM or after 9 PM, the price is 500 RWF.
ELSE IF the hour is between 7 AM and 2 PM, or between 7 PM and 9 PM, the price is 1,000 RWF.
ELSE the price is 1,500 RWF (between 2 PM and 7 PM).
How WHILE Works

The WHILE loop counts the parking hours one by one.

For every hour, it adds the price to the total.

Final Result

At the end, the program adds all the prices and shows the total amount in the text field.

Conclusion

In simple words, IF and ELSE help my program choose the parking price. The WHILE loop counts the hours, and the program calculates how much the person needs to pay.
