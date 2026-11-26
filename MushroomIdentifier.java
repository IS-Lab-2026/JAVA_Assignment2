package lab1;

import java.util.Scanner;

public class MushroomIdentifier {

    private static boolean askYesNo(Scanner scanner, String question) {
        while (true) {
            System.out.print(question + " (yes/no): ");
            String answer = scanner.next().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            } else if (answer.equals("no") || answer.equals("n")) {
                return false;
            } else {
                System.out.println("Please answer with 'yes' or 'no'.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of one of the 6 mushrooms and answer up to 3 questions.");

        String mushroom;
        boolean hasGills = askYesNo(scanner, "Does your mushroom have gills?");

        if (!hasGills) {
            // Only Cepe de bordeau has pores instead of gills
            mushroom = "Cepe de bordeau";
        } else {
            boolean growsInForest = askYesNo(scanner, "Does your mushroom grow in a forest?");
            boolean hasConvexCup = askYesNo(scanner, "Does your mushroom have a convex cup?");

            if (!growsInForest) {
                // Meadow + gills: Agaric Jaunissant (convex) vs. Coprin chevelu (not convex)
                mushroom = hasConvexCup ? "Agaric Jaunissant" : "Coprin chevelu";
            } else {
                // Forest + gills
                if (!hasConvexCup) {
                    mushroom = "Girolle";
                } else {
                    boolean hasRing = askYesNo(scanner, "Does your mushroom have a ring?");
                    mushroom = hasRing ? "Amanite tue-mouche" : "Pied bleu";
                }
            }
        }

        System.out.println("Your mushroom is: " + mushroom);
        scanner.close();
    }
}