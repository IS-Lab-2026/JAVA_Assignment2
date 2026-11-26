package lab1;

import java.util.Scanner;

public class BicycleRental {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting hour (0-23): ");
        int startHour = scanner.nextInt();

        System.out.print("Enter ending hour (1-24): ");
        int endHour = scanner.nextInt();

        // Validate constraints: integer hours, same day, start < end, valid bounds
        if (startHour < 0 || startHour > 23 || endHour < 1 || endHour > 24 || startHour >= endHour) {
            System.out.println("Invalid input. Ensure 0 <= start < end <= 24 within a single day.");
            scanner.close();
            return;
        }

        int totalCost = 0;

        // Loop through each 1-hour slot [hour, hour + 1)
        for (int hour = startHour; hour < endHour; hour++) {
            int rate;
            if ((hour >= 0 && hour < 7) || (hour >= 21 && hour < 24)) {
                rate = 500;
            } else if ((hour >= 7 && hour < 14) || (hour >= 19 && hour < 21)) {
                rate = 1000;
            } else {
                // Covers 14 <= hour < 19
                rate = 1500;
            }
            totalCost += rate;
        }

        System.out.println("Total rental cost: " + totalCost + " RWF");
        scanner.close();
    }
}