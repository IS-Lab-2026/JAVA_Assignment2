package GUI_IS;

import javax.swing.*;
import java.awt.*;

public class Mushroom extends JFrame {
    private JComboBox<String> gillsBox, forestBox, convexBox, ringBox;
    private JLabel resultLabel;
    private final String[] answers = {"-- Select --", "Yes", "No"};

    public Mushroom() { initComponents(); }
    private void initComponents() {
        setTitle("Mushroom Identification"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setResizable(false);
        JLabel heading = new JLabel("MUSHROOM IDENTIFICATION", SwingConstants.CENTER); heading.setFont(new Font("Arial",Font.BOLD,20));
        JPanel questions = new JPanel(new GridLayout(4,2,10,10)); questions.setBorder(BorderFactory.createTitledBorder("Answer the questions"));
        questions.add(new JLabel("Does it have gills?")); gillsBox = new JComboBox<>(answers); questions.add(gillsBox);
        questions.add(new JLabel("Does it grow in a forest?")); forestBox = new JComboBox<>(answers); questions.add(forestBox);
        questions.add(new JLabel("Does it have a convex cup?")); convexBox = new JComboBox<>(answers); questions.add(convexBox);
        questions.add(new JLabel("Does it have a ring?")); ringBox = new JComboBox<>(answers); questions.add(ringBox);
        JButton identify = new JButton("Identify"); identify.addActionListener(e -> identifyMushroom());
        JButton clear = new JButton("Clear"); clear.addActionListener(e -> clearAnswers());
        JButton back = new JButton("Back"); back.addActionListener(e -> { new Welcome().setVisible(true); dispose(); });
        JButton exit = new JButton("Exit"); exit.addActionListener(e -> System.exit(0));
        JPanel buttons = new JPanel(); buttons.add(identify); buttons.add(clear); buttons.add(back); buttons.add(exit);
        resultLabel = new JLabel("Result will appear here.", SwingConstants.CENTER); resultLabel.setFont(new Font("Arial",Font.BOLD,16)); resultLabel.setBorder(BorderFactory.createTitledBorder("Identification result"));
        JPanel panel = new JPanel(); panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS)); panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT); panel.add(heading); panel.add(Box.createVerticalStrut(15)); panel.add(questions); panel.add(buttons); panel.add(resultLabel);
        setContentPane(panel); setSize(520,360); setLocationRelativeTo(null);
    }
    private String selected(JComboBox<String> box) { return (String) box.getSelectedItem(); }
    private boolean isYes(String value) { return "Yes".equals(value); }
    private boolean isNo(String value) { return "No".equals(value); }
    private boolean missing(JComboBox<String> box) { return "-- Select --".equals(selected(box)); }
    private void identifyMushroom() {
        if (missing(gillsBox)) { error("Please answer whether the mushroom has gills."); return; }
        if (isNo(selected(gillsBox))) { showResult("Cepe de bordeaux"); return; }
        if (missing(forestBox)) { error("Please answer whether it grows in a forest."); return; }
        if (isNo(selected(forestBox))) {
            if (missing(ringBox)) { error("Please answer whether it has a ring."); return; }
            showResult(isYes(selected(ringBox)) ? "Coprin chevelu" : "Agaric jaunissant"); return;
        }
        if (missing(convexBox)) { error("Please answer whether it has a convex cup."); return; }
        if (isNo(selected(convexBox))) { showResult("Girolle"); return; }
        if (missing(ringBox)) { error("Please answer whether it has a ring."); return; }
        showResult(isYes(selected(ringBox)) ? "Amanite tue-mouches" : "Pied bleu");
    }
    private void showResult(String name) { resultLabel.setText("Identified mushroom: " + name); }
    private void error(String message) { JOptionPane.showMessageDialog(this,message,"Missing answer",JOptionPane.WARNING_MESSAGE); }
    private void clearAnswers() { gillsBox.setSelectedIndex(0); forestBox.setSelectedIndex(0); convexBox.setSelectedIndex(0); ringBox.setSelectedIndex(0); resultLabel.setText("Result will appear here."); }
}
