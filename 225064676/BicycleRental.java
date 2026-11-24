
package my.mushroom;

import java.util.Scanner;

public class BicycleRental {

    public static int calculateCost(int starthour, int endhour) {

        int total = 0;

        for (int hour = starthour; hour < endhour; hour++) {
            int rent;

            if ((hour >= 0 && hour < 7) || (hour >= 21 && hour < 24)) {
                rent = 500;
            }
            else if ((hour >= 7 && hour < 14) || (hour >= 19 && hour < 21)) {
                rent = 1000;
            }
            else {
                rent = 1500;
            }

            total = total + rent;
        }

        return total;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter starting hour (0-23): ");
        int starthour = input.nextInt();

        System.out.println("Enter ending hour (1-24): ");
        int endhour = input.nextInt();

        int total = calculateCost(starthour, endhour);

        System.out.println("Total Rental cost: " + total + " RWF");
    }

  
}
