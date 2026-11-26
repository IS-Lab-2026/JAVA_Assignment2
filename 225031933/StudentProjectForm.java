package lab2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class StudentProjectForm extends JFrame {

    public StudentProjectForm() {
        setTitle("Student Project Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 8, 8));
        topPanel.setBorder(BorderFactory.createEmptyBorder(12, 15, 8, 15));

        JTextField regNoField = new JTextField();
        JTextField projectNameField = new JTextField();

        topPanel.add(new JLabel("REG NO:"));
        topPanel.add(regNoField);
        topPanel.add(new JLabel("Project Name:"));
        topPanel.add(projectNameField);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> projectList = new JList<>(listModel);

        JButton addBtn = new JButton("Save Project");
        JButton cancelBtn = new JButton("Cancel");

        addBtn.addActionListener(e -> {
            String regNo = regNoField.getText().trim();
            String projectName = projectNameField.getText().trim();
            if (regNo.isEmpty() || projectName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter both REG NO and Project Name.", "Missing Data", JOptionPane.WARNING_MESSAGE);
                return;
            }
            listModel.addElement(regNo + " - " + projectName);
            regNoField.setText("");
            projectNameField.setText("");
        });

        cancelBtn.addActionListener(e -> dispose());

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 8, 0));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(8, 15, 12, 15));
        bottomPanel.add(addBtn);
        bottomPanel.add(cancelBtn);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(projectList), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}