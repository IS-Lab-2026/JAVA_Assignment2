
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentProject extends JFrame {

    JTextField regField;
    JTextField projectField;
    JLabel resultLabel;

    public StudentProject() {
        setTitle("CampusDesk - Student Project");
        setSize(460, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(243, 246, 250));

        JLabel title = new JLabel("Student Project Form");
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(new Color(20, 40, 62));
        title.setBounds(80, 25, 320, 35);
        add(title);

        JLabel regLabel = new JLabel("Reg No:");
        regLabel.setBounds(50, 100, 100, 25);
        add(regLabel);

        regField = new JTextField();
        regField.setBounds(160, 100, 230, 30);
        add(regField);

        JLabel projectLabel = new JLabel("Project Name:");
        projectLabel.setBounds(50, 155, 100, 25);
        add(projectLabel);

        projectField = new JTextField();
        projectField.setBounds(160, 155, 230, 30);
        add(projectField);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(50, 215, 160, 40);
        submitBtn.setBackground(new Color(27, 153, 139));
        submitBtn.setForeground(Color.WHITE);
        add(submitBtn);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(230, 215, 160, 40);
        add(cancelBtn);

        resultLabel = new JLabel("Fill in your project details.");
        resultLabel.setBounds(50, 275, 350, 35);
        resultLabel.setForeground(new Color(20, 40, 62));
        add(resultLabel);

        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submit();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void submit() {
        String reg = regField.getText().trim();
        String project = projectField.getText().trim();

        if (reg.equals("") || project.equals("")) {
            resultLabel.setText("Please fill in both fields.");
        } else {
            resultLabel.setText("Submission details accepted!");
        }
    }
}
