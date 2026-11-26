package com.mycompany.gui_mains;

import java.util.Scanner;

/** The exact mushroom decision tree from the user's MushroomGuess exercise. */
public class MushroomGuess {

    @FunctionalInterface
    public interface QuestionAsker {
        boolean ask(String question);
    }

    /** Returns the mushroom name by asking only the relevant yes/no questions. */
    public static String identify(QuestionAsker questions) {
        if (!questions.ask("Does your mushroom have gills?")) {
            return "Cepe de Bordeaux";
        } else {
            if (!questions.ask("Does your mushroom grow in a forest?")) {
                if (questions.ask("Does your mushroom have a ring?")) {
                    return "Agaric Jaunissant";
                } else {
                    return "Coprin Chevelu";
                }
            } else {
                if (questions.ask("Does your mushroom have a convex cup?")) {
                    if (questions.ask("Does your mushroom have a ring?")) {
                        return "Amanite tue-mouche";
                    } else {
                        return "Pied bleu";
                    }
                } else {
                    return "Girolle";
                }
            }
        }
    }

    /** Console entry point retained for comparison with the original source. */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Think of one of these mushrooms:");
            System.out.println("1. Agaric Jaunissant");
            System.out.println("2. Amanite tue-mouche");
            System.out.println("3. Cepe de Bordeaux");
            System.out.println("4. Coprin chevelu");
            System.out.println("5. Girolle");
            System.out.println("6. Pied bleu");
            String mushroom = identify(question -> {
                while (true) {
                    System.out.print(question + " (yes/no): ");
                    String answer = input.nextLine().trim();
                    if (answer.equalsIgnoreCase("yes")) return true;
                    if (answer.equalsIgnoreCase("no")) return false;
                    System.out.println("Please enter yes or no.");
                }
            });
            System.out.println("Your mushroom is: " + mushroom);
        }
    }
}
