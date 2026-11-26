 My Java Programs

In this project, I worked on two small Java programs using NetBeans. I
wanted to practise how to use Java Swing, radio buttons, text fields,
buttons, and IF and ELSE statements.

The two programs are Mushroom Identification and Bicycle Rental.
Below, I explain what each one does and how the code works.

 1. Mushroom Identification

 What the program does

The Mushroom Identification program asks the user questions about a
mushroom. The user chooses Yes or No using radio buttons. When they
click the Action button, the program checks their answers and shows
a mushroom name in the `txtmushroom` text field.

 Methods used in the program

1. `radioyesgillsActionPerformed()`

This method runs when the user clicks the Yes option for gills. At the
moment, it is empty, so it does not do anything.

**2. `radionogillsActionPerformed()`**

This method runs when the user clicks the No option for gills. It is
also empty in the current code.

**3. `btnactionActionPerformed()`**

This is where the main work happens. When the user clicks Action,
this method checks the selected radio buttons and decides which mushroom
name to show.

**4. `btncancelActionPerformed()`**

When the user clicks **Cancel**, this method opens the `welcome` form
and hides the Mushroom Identification form.

How IF and ELSE work in this program

I used `if` and `else` because the program needs to make decisions based
on the answers selected by the user.

-   `if` checks whether a condition is true.
-   `else` tells the program what to do when the condition is false.
-   `isSelected()` checks whether a radio button has been selected.
-   `setText()` puts the result into a text field.

First, the program checks whether `radioyesring` is selected.

**If `radioyesring` is selected:**

-   If `radioyesforest` is also selected, the result is Amanite
    tue-mouche.
-   If not, the program checks `radioyescup`.
-   If `radioyescup` is selected, the result is Agaric jaunissant.
-   If it is not selected, the result is Coprin chevelu.

**If `radioyesring` is not selected:**

-   The program checks whether `radionogills` is selected.
-   If it is selected, the result is Cepe de bordeaux.
-   If it is not selected, the program checks `radioyescup`.
-   If `radioyescup` is selected, the result is Pied bleu.
-   Otherwise, the result is Girolle.

 Mushroom names displayed

The program can display these six names:

1.  Amanite tue-mouche
2.  Agaric jaunissant
3.  Coprin chevelu
4.  Cepe de bordeaux
5.  Pied bleu
6.  Girolle

## Conclusion

This program helped me practise using radio buttons and IF and ELSE
statements. It shows how a program can check a user's choices and
display a result. The names are shown according to the conditions in my
code.

# 2. Bicycle Rental

## What the program does

The Bicycle Rental program calculates the cost of renting a bicycle. The
user enters the starting time and ending time, then clicks the
**Calculate** button. The program works out how many hours the bicycle
was rented for and displays the cost in the `txtcost` text field.

## Main method used

`btncalculateActionPerformed()`

This method does the calculation when the user clicks Calculate.

The program uses these variables:

-   `startTime` keeps the starting time entered by the user.
-   `endTime` keeps the ending time.
-   `hours` stores the number of hours rented.
-   `rate` stores the price for one hour.
-   `total` stores the final amount to pay.

## How IF and ELSE work in this program

The program first checks whether the starting time is less than 0 or
greater than 23. If it is, it displays invalid starting time.

It then checks whether the starting time is greater than or equal to the
ending time. If it is, it displays *starting time must not be greater
than ending time*.

If the time passes these checks, the program finds the number of hours
by subtracting the starting time from the ending time:

`hours = endTime - startTime`

After that, the program checks the time conditions to choose the hourly
rate:

-   **500 RWF** when the first rate condition in the code is met.
-   **1,000 RWF** when the second rate condition is met.
-   **1,500 RWF** when neither of those conditions is met.

At the end, the program multiplies the number of hours by the rate:

`total = hours * rate`

The answer is then displayed in `txtcost`, followed by `rwf`.

Other instructions used

-   `getText()` gets the information entered in a text field.
-   `trim()` removes extra spaces from the beginning and end of the
    text.
-   `Integer.parseInt()` changes the text entered by the user into an
    integer.
-   `setText()` displays the answer or an error message in a text field.

 Conclusion

The Bicycle Rental program helped me practise reading user input,
working with numbers, doing calculations, and using IF and ELSE
statements. It checks the starting time before calculating the rental
cost.



