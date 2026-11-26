public class MushroomGuesser {
    public static String guess(String ring, String forest, String gills, String cup) {
        String r = ring == null ? "" : ring.trim().toLowerCase();
        String f = forest == null ? "" : forest.trim().toLowerCase();
        String g = gills == null ? "" : gills.trim().toLowerCase();
        String c = cup == null ? "" : cup.trim().toLowerCase();

        if (r.equals("yes") && f.equals("yes") && g.equals("yes") && c.equals("yes")) {
            return "Fly agaric";
        }
        if (r.equals("yes") && f.equals("no") && g.equals("no") && c.equals("no")) {
            return "Field mushroom";
        }
        if (r.equals("no") && f.equals("yes") && g.equals("yes") && c.equals("no")) {
            return "Chanterelle";
        }
        if (r.equals("no") && f.equals("no") && g.equals("no") && c.equals("yes")) {
            return "Puffball";
        }

        return "Unknown mushroom type.";
    }
}
