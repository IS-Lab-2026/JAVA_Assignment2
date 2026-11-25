package javaapplication1;

import javax.swing.JOptionPane;

public class Lab2_mushroomSwing {

    public static void main(String[] args) {

        String gills;
        String forest;
        String ring;
        String convexCup;

        JOptionPane.showMessageDialog(null,
                "MUSHROOM IDENTIFICATION PROGRAM",
                "Welcome",
                JOptionPane.INFORMATION_MESSAGE);

        // Question 1: Gills
        gills = JOptionPane.showInputDialog(
                "Does your mushroom have gills? (yes/no):");

        if (gills == null) {
            return;
        }

        gills = gills.toLowerCase().trim();

        if (gills.equals("no")) {

            JOptionPane.showMessageDialog(null,
                    "Your mushroom is: Cepe de bordeaux");

        } else if (gills.equals("yes")) {

            // Question 2: Forest
            forest = JOptionPane.showInputDialog(
                    "Does your mushroom grow in a forest? (yes/no):");

            if (forest == null) {
                return;
            }

            forest = forest.toLowerCase().trim();

            if (forest.equals("no")) {

                // Question 3: Ring
                ring = JOptionPane.showInputDialog(
                        "Does your mushroom have a ring? (yes/no):");

                if (ring == null) {
                    return;
                }

                ring = ring.toLowerCase().trim();

                if (ring.equals("yes")) {

                    JOptionPane.showMessageDialog(null,
                            "Your mushroom is: Coprin chevelu");

                } else if (ring.equals("no")) {

                    JOptionPane.showMessageDialog(null,
                            "Your mushroom is: Agaric jaunissant");

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Invalid answer! Please enter yes or no.");
                }

            } else if (forest.equals("yes")) {

                // Question 3: Convex cup
                convexCup = JOptionPane.showInputDialog(
                        "Does your mushroom have a convex cup? (yes/no):");

                if (convexCup == null) {
                    return;
                }

                convexCup = convexCup.toLowerCase().trim();

                if (convexCup.equals("yes")) {

                    // Question 4: Ring
                    ring = JOptionPane.showInputDialog(
                            "Does your mushroom have a ring? (yes/no):");

                    if (ring == null) {
                        return;
                    }

                    ring = ring.toLowerCase().trim();

                    if (ring.equals("yes")) {

                        JOptionPane.showMessageDialog(null,
                                "Your mushroom is: Amanite tue-mouches");

                    } else if (ring.equals("no")) {

                        JOptionPane.showMessageDialog(null,
                                "Your mushroom is: Pied bleu");

                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Invalid answer! Please enter yes or no.");
                    }

                } else if (convexCup.equals("no")) {

                    JOptionPane.showMessageDialog(null,
                            "Your mushroom is: Girolle");

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Invalid answer! Please enter yes or no.");
                }

            } else {

                JOptionPane.showMessageDialog(null,
                        "Invalid answer! Please enter yes or no.");
            }

        } else {

            JOptionPane.showMessageDialog(null,
                    "Invalid answer! Please enter yes or no.");
        }
    }
}