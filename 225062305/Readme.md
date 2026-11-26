# Bicycle Rental & Mushroom Identification 

## Project Overview
This is a Java Swing desktop application built in Apache NetBeans. The application acts as a central hub that connects a welcome dashboard to two independent functional modules:

1. Time-Tiered Cost Calculator: Computes usage charges automatically by applying different pricing rates depending on the duration entered.
2. Mushroom Identification Tool: Guides the user through physical traits to identify different mushroom species.

## Application Architecture
The project is organized under the 'com.mycompany.bicyclemushroom' package using a clean, event-driven GUI structure:

"Bicyclemushroom.java" The main entry point of the program. It initializes the graphical user interface safely on the Swing Event Dispatch Thread using EventQueue.invokeLater().
"Welcomee.java" . The landing window ('JFrame') that greets the user and provides navigation buttons to launch either the Cost Calculator or the Mushroom Identification form.
Module Forms ('JFrame') — Separate GUI forms that handle user input, apply conditional logic, and display results clearly.
Used "java.awt.EventQueue.invokeLater()" in the "main" method to ensure UI components render reliably without thread conflicts.


