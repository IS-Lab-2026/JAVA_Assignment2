import javax.swing.SwingUtilities;

public class Main {
 public static void main(String []args){
 
    
    SwingUtilities.invokeLater(()->{
    boolean [] answer = new boolean[1];
    boolean [] answer2 = new boolean[1];
    boolean [] answer3 = new boolean[1];
    int []step = {1};
      MushGUI GUI = new MushGUI();
      GUI.Mush();
      GUI.BRC();
      GUI.WelcomeGUI.setVisible(true);

      GUI.Mush.addActionListener(e ->{
      GUI.WelcomeGUI.dispose();
      GUI.MushFr.setVisible(true);
      step[0] = 1;
      GUI.Yes.setEnabled(true);
      GUI.No.setEnabled(true);
      GUI.Out.setText("\tMushroom guess game (Click YES or NO)\n\n\tDoes your mushroom have a ring?");
            });
      
      GUI.Yes.addActionListener(e->{
       processChoice(true, step, answer, answer2, answer3, GUI);
      });
        
      GUI.No.addActionListener(e -> {
        processChoice(false, step, answer, answer2, answer3, GUI);
      });

      GUI.back.addActionListener(e ->{
      GUI.MushFr.dispose();
      GUI.WelcomeGUI.setVisible(true);
        
    });

      GUI.Byc.addActionListener(e ->{
      GUI.WelcomeGUI.dispose();
      GUI.BRC.setVisible(true);       
      });

      GUI.backBRC.addActionListener(e ->{   
      GUI.BRC.dispose();  
      GUI.WelcomeGUI.setVisible(true);
    });
 });
}
    private static void processChoice(boolean choice, int[] step, boolean[] answer, boolean[] answer2, boolean[] answer3, MushGUI GUI) {
        if (step[0] == 1) {
            answer[0] = choice;
            step[0] = 2;
            GUI.Out.setText("\tDoes your mushroom have a convex cup?");

        } else if (step[0] == 2) {
            answer2[0] = choice;

            if (answer[0] && answer2[0]) {
                step[0] = 3;
                GUI.Out.setText("\tDoes your mushroom grow in meadows?");
            } else if (answer[0] && !answer2[0]) {
                finishGame("Coprin chevelu", step, GUI);
            } else if (!answer[0] && answer2[0]) {
                finishGame("Pied bleu", step, GUI);
            } else if (!answer[0] && !answer2[0]) {
                step[0] = 3;
                GUI.Out.setText("\tDoes your mushroom have gills?");
            }

        } else if (step[0] == 3) {
            answer3[0] = choice;

            if (answer[0] && answer2[0]) {
                if (answer3[0]) {
                    finishGame("Agaric jaunissant", step, GUI);
                } else {
                    finishGame("Amanite tue-mouche", step, GUI);
                }
            } else if (!answer[0] && !answer2[0]) {
                if (answer3[0]) {
                    finishGame("Girolle", step, GUI);
                } else {
                    finishGame("Cepe de bordeaux", step, GUI);
                }
            }
        }
    }

    private static void finishGame(String mushroomName, int[] step, MushGUI GUI) {
        GUI.Yes.setEnabled(false);
        GUI.No.setEnabled(false);
        GUI.Out.setText("\tYour Mushroom is " + mushroomName);
    }
}
