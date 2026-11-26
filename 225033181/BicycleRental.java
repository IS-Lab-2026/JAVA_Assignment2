package com.mycompany.gui_mains;

import java.util.Scanner;

/** The hourly rate and validation logic from the supplied BicycleRental.java. */
public class BicycleRental {

    /** Calculate a single-day rental; the ending hour may be 24 (midnight). */
    public static int calculateRent(int startTime, int endTime) {
        if (startTime < 0 || startTime > 23 || endTime < 1 || endTime > 24) {
            throw new IllegalArgumentException("Invalid hour ranges provided. Start: 0-23, End: 1-24.");
        }
        if (startTime >= endTime) {
            throw new IllegalArgumentException("Starting time must be less than ending time.");
        }

        int totalCost = 0;
        for (int h = startTime; h < endTime; h++) {
            if ((h >= 0 && h < 7) || (h >= 21 && h < 24)) {
                totalCost += 500;
            } else if ((h >= 7 && h < 14) || (h >= 19 && h < 21)) {
                totalCost += 1000;
            } else if (h >= 14 && h < 19) {
                totalCost += 1500;
            }
        }
        return totalCost;
    }

    /** Console entry point retained so the original exercise can still be run. */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter starting time (0-23): ");
            int startTime = input.nextInt();
            System.out.print("Enter ending time (1-24): ");
            int endTime = input.nextInt();
            try {
                System.out.println("Total rent to pay: " + calculateRent(startTime, endTime) + " RWF");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
