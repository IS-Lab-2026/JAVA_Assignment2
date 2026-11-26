public class BicycleRental {
    public static String getRent(int start, int end) {
        if (start < 0 || start > 23 || end < 1 || end > 24) {
            return "Invalid time entered.";
        }
        if (start >= end) {
            return "Start time must be less than end time.";
        }

        int total = 0;

        if (end <= 7) {
            total = (end - start) * 500;
        } else if (start >= 7 && end <= 14) {
            total = (end - start) * 1000;
        } else if (start >= 14 && end <= 19) {
            total = (end - start) * 1500;
        } else if (start >= 19 && end <= 21) {
            total = (end - start) * 1000;
        } else if (start >= 21) {
            total = (end - start) * 500;
        } else {
            int h1 = 0, h2 = 0, h3 = 0;

            if (start < 7) {
                h1 += (end <= 7) ? (end - start) : (7 - start);
            }
            if (start < 14 && end > 7) {
                int s = Math.max(start, 7);
                int e = Math.min(end, 14);
                h2 += (e - s);
            }
            if (start < 19 && end > 14) {
                int s = Math.max(start, 14);
                int e = Math.min(end, 19);
                h3 += (e - s);
            }
            if (start < 21 && end > 19) {
                int s = Math.max(start, 19);
                int e = Math.min(end, 21);
                h2 += (e - s);
            }
            if (end > 21) {
                h1 += (start >= 21) ? (end - start) : (end - 21);
            }

            total = (h1 * 500) + (h2 * 1000) + (h3 * 1500);
        }

        return "The total rent to pay is: " + total + " RWF";
    }
                }
                                                       
