                      DESCRIPTION ABOUT PROGRAM

 INTRODUCTION

This program is a Java Swing program with three windows. The user starts at the
Welcome window and chooses one of two small applications: Bicycle Rental
or Mushroom. All three classes are in the package "Welcome".

 Welcome:The main class i.e This is the class you run.
 
 Bicyclerental: Calculate the cost of renting a Bicycle.
 
 Mushroom: Finds a mushroom by asking Yes or No questions.


1. THE WELCOME CLASS

Welcome is the first window the user sees. It has three buttons:
 Bicyclerental: Opens the Bicycle Rental window.
 Mushroom: Opens the Mushroom window.
 Exit :Asks for confirmation, then closes the program.

While another window is open, Welcome is hidden. It is the only class with
a main method, and closing it ends the whole program.


2. THE BICYCLERENTAL CLASS

The user chooses a starting hour (0 to 23) and an ending hour (1 to 24).
The program then calculates the total cost.

Buttons:
    Calculate Cost: Shows the total cost in RWF.
    
    Clear :Resets the hours and the cost.
    
    Cancel :Closes this window and returns to Welcome.

Price per hour:
    00:00 to 07:00 and 21:00 to 24:00    500 RWF
    
    07:00 to 14:00 and 19:00 to 21:00    1000 RWF
    
    14:00 to 19:00                       1500 RWF

If the starting hour is not smaller than the ending hour, an error message
is shown.

3. THE MUSHROOM CLASS
   
The user thinks of one of six mushrooms and answers Yes or No to each
question. The program uses the answers to find the mushroom.

Buttons:
    Yes / No   Answer the current question.
    
    Restart    Go back to the first question.
    
    Cancel     Close this window and return to Welcome.

The program remembers the current question in a variable called "step

Questions and results:

1.Does it have Gills?

No ->Cepe de Bordeaux

Yes ->Go to question 2

2.Does it glow in forest?

No ->Go to question 3

 Yes->Go to question 3

 3.Does it have a convex cup? (not in a foredt)

 Yes ->Agaric jaunissant

 No ->Coprin chevelu

 4.Does it have a convex cup? (in a forest)

 Yes ->Pied bleu

 No ->Go to question 5

5.Does it have a ring?

Yesv ->Amanite tue-mouche

No ->Girolle
    

4. HOW THE CLASSES ARE CONNECTED
   

    Welcome  ->  BicycleRental  ->  back to Welcome
   
    Welcome  ->  Mushroom       ->  back to Welcome

Explanations;

    1. The user runs Welcome and sees the menu.
    
    2. The user clicks Bicyclerental or Mushroom.
    
    3. Welcome hides itself and creates the new window, giving itself to it:
           new BicycleRental(this)
           new Mushroom(this)
       Here, "this" means the Welcome window.
       
    4. The new window stores this Welcome window in a variable.
    
    5. When the user clicks Cancel or closes the window, it calls
       dispose() to close itself, then welcome.setVisible(true) to show
       the menu again.

Why is Welcome passed to the other classes?
A window can only show another window if it holds a reference to it. Passing
"this" in the constructor is how BicycleRental and Mushroom know which
Welcome window to bring back.

Why do BicycleRental and Mushroom have no main method?
They need a Welcome window to be created, so they cannot start by themselves.


5. THE WAY TO RUN
   

    1. Put the three files in the package "Welcome".
       
    3. Run Welcome.java.
  
    5. Click a button to open a window, and Cancel to return to the menu.
       
    7. If changes do not appear, use Clean and Build, then run again.




