package com.mycompany.bicyclerentals;

public class RentalCalculator {

    // Takes start and end hour, returns total cost in RWF
    public int calculateTotal(int startTime, int endTime) {
        int totalCost = 0;

        for (int hour = startTime; hour < endTime; hour++) {
            if (hour < 7 || hour >= 21) {
                totalCost += 500;
            } else if ((hour >= 7 && hour < 14) || (hour >= 19 && hour < 21)) {
                totalCost += 1000;
            } else if (hour >= 14 && hour < 19) {
                totalCost += 1500;
            }
        }
        return totalCost;
    }
}
