package lab2;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lab1.MushroomIdentifier;

public class MushroomIdForm extends JFrame {

    public MushroomIdForm() {
        setTitle("Mushroom Id");
        setSize(380, 260);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 6, 6));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JCheckBox gillsBox = new JCheckBox("Has gills (unchecked = pores)");
        JCheckBox forestBox = new JCheckBox("Grows in a forest (unchecked = meadow)");
        JCheckBox ringBox = new JCheckBox("Has a ring");
        JCheckBox convexBox = new JCheckBox("Has a convex cup");

        JButton identifyBtn = new JButton("Identify Mushroom");
        JButton cancelBtn = new JButton("Cancel");
        JLabel resultLabel = new JLabel("Mushroom: -");

        identifyBtn.addActionListener(e -> {
            String result = MushroomIdentifier.identifyMushroom(
                    gillsBox.isSelected(),
                    forestBox.isSelected(),
                    ringBox.isSelected(),
                    convexBox.isSelected()
            );
            resultLabel.setText("Mushroom: " + result);
        });

        cancelBtn.addActionListener(e -> dispose());

        JPanel actionRow = new JPanel(new GridLayout(1, 2, 8, 0));
        actionRow.add(identifyBtn);
        actionRow.add(cancelBtn);

        panel.add(gillsBox);
        panel.add(forestBox);
        panel.add(ringBox);
        panel.add(convexBox);
        panel.add(resultLabel);
        panel.add(actionRow);

        add(panel);
    }
}