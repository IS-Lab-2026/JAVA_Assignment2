
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
