import javax.swing.*;
import java.awt.event.*;

public class ProjectForm extends JFrame implements ActionListener {

    JLabel regLabel = new JLabel("Reg No:");
    JTextField regBox = new JTextField();
    JLabel nameLabel = new JLabel("Project Name:");
    JTextField nameBox = new JTextField();
    JButton submitButton = new JButton("Submit");
    JButton cancelButton = new JButton("Cancel");
    JLabel result = new JLabel("");

    public ProjectForm() {
        setTitle("Student Project");
        setSize(380, 280);
        setLayout(null);

        regLabel.setBounds(20, 30, 100, 25);
        regBox.setBounds(130, 30, 200, 25);
        nameLabel.setBounds(20, 70, 100, 25);
        nameBox.setBounds(130, 70, 200, 25);
        submitButton.setBounds(60, 120, 100, 30);
        cancelButton.setBounds(200, 120, 100, 30);
        result.setBounds(20, 170, 340, 25);

        add(regLabel);
        add(regBox);
        add(nameLabel);
        add(nameBox);
        add(submitButton);
        add(cancelButton);
        add(result);

        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            dispose();
        }

        if (e.getSource() == submitButton) {
            String reg = regBox.getText();
            String name = nameBox.getText();

            if (reg.equals("") || name.equals("")) {
                result.setText("Please fill in both boxes");
            } else {
                result.setText("Saved: " + reg + " - " + name);
            }
        }
    }

    public static void main(String[] args) {
        new ProjectForm();
    }
}
