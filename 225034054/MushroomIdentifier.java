package com.mycompany.bicyclerentals;

public class MushroomIdentifier {

    // Takes the four yes/no answers and returns the mushroom name
    public String identify(boolean forest, boolean convex, boolean ring, boolean gills) {
        if (!forest) {
            if (convex) {
                return "Agaric Jaunissant";
            } else {
                return "Coprin chevelu";
            }
        } else {
            if (convex) {
                if (ring) {
                    return "Amanite tue-mouche";
                } else {
                    return "Pied bleu";
                }
            } else {
                if (gills) {
                    return "Girolle";
                } else {
                    return "Cepe de bordeaux";
                }
            }
        }
    }
}
