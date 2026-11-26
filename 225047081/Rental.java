package GUI_IS;

import javax.swing.*;
import java.awt.*;

public class Rental extends JFrame {
    private JTextField startField, endField;
    private JTextArea resultArea;

    public Rental() { initComponents(); }

    private void initComponents() {
        setTitle("Bicycle Rental Calculator"); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setResizable(false);
        JLabel heading = new JLabel("BICYCLE RENTAL COST", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        String[][] priceRows = {{"00:00–07:00", "500 RWF"}, {"07:00–14:00", "1,000 RWF"}, {"14:00–19:00", "1,500 RWF"}, {"19:00–21:00", "1,000 RWF"}, {"21:00–24:00", "500 RWF"}};
        JTable priceTable = new JTable(priceRows, new String[]{"Time period", "Hourly price"});
        priceTable.setEnabled(false); priceTable.setRowHeight(23);
        JScrollPane tableScroll = new JScrollPane(priceTable);
        JPanel input = new JPanel(new GridLayout(2,2,8,8)); input.setBorder(BorderFactory.createTitledBorder("Rental hours (24-hour clock)"));
        input.add(new JLabel("Starting hour (0–23):")); startField = new JTextField(); input.add(startField);
        input.add(new JLabel("Ending hour (1–24):")); endField = new JTextField(); input.add(endField);
        JButton calculate = new JButton("Calculate"); calculate.addActionListener(e -> calculateCost());
        JButton clear = new JButton("Clear"); clear.addActionListener(e -> clearFields());
        JButton back = new JButton("Back"); back.addActionListener(e -> { new Welcome().setVisible(true); dispose(); });
        JButton exit = new JButton("Exit"); exit.addActionListener(e -> System.exit(0));
        JPanel buttons = new JPanel(); buttons.add(calculate); buttons.add(clear); buttons.add(back); buttons.add(exit);
        resultArea = new JTextArea(7,35); resultArea.setEditable(false); resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        resultArea.setText("Your rental calculation will appear here."); JScrollPane resultScroll = new JScrollPane(resultArea); resultScroll.setBorder(BorderFactory.createTitledBorder("Rental summary"));
        JPanel panel = new JPanel(); panel.setBorder(BorderFactory.createEmptyBorder(15,18,15,18)); panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT); panel.add(heading); panel.add(Box.createVerticalStrut(10)); panel.add(tableScroll); panel.add(Box.createVerticalStrut(12)); panel.add(input); panel.add(buttons); panel.add(resultScroll);
        setContentPane(panel); pack(); setSize(570,570); setLocationRelativeTo(null);
    }

    // Add the price for each individual hour so different time periods are handled correctly.
    private int priceForHour(int hour) {
        if (hour < 7) return 500;
        if (hour < 14) return 1000;
        if (hour < 19) return 1500;
        if (hour < 21) return 1000;
        return 500;
    }
    private void calculateCost() {
        int start, end;
        try { start = Integer.parseInt(startField.getText().trim()); end = Integer.parseInt(endField.getText().trim()); }
        catch (NumberFormatException ex) { showError("Enter whole-number hours in both fields."); return; }
        if (start < 0 || start > 23) { showError("Starting hour must be from 0 to 23."); startField.requestFocus(); return; }
        if (end < 1 || end > 24) { showError("Ending hour must be from 1 to 24."); endField.requestFocus(); return; }
        if (start >= end) { showError("Starting hour must be less than ending hour."); return; }
        int total = 0; StringBuilder details = new StringBuilder();
        for (int h=start; h<end; h++) { int price=priceForHour(h); total += price; details.append(String.format("%02d:00–%02d:00  %s RWF\n",h,h+1,String.format("%,d",price))); }
        resultArea.setText("RENTAL SUMMARY\n----------------------------\nStart: " + String.format("%02d:00",start) + "\nEnd:   " + String.format("%02d:00",end) + "\nHours: " + (end-start) + "\n\nHourly prices:\n" + details + "----------------------------\nTOTAL: " + String.format("%,d",total) + " RWF");
    }
    private void showError(String message) { JOptionPane.showMessageDialog(this,message,"Input error",JOptionPane.ERROR_MESSAGE); }
    private void clearFields() { startField.setText(""); endField.setText(""); resultArea.setText("Your rental calculation will appear here."); startField.requestFocus(); }
}
