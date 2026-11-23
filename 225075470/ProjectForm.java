import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectForm extends JFrame implements ActionListener {
    JLabel title, lReg, lName, msg;
    JTextField tReg, tName;
    JButton bSubmit, bCancel;

    public ProjectForm() {
        setTitle("GreenWheel Hub - Student Project");
        setSize(460, 340);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 244, 214));

        title = new JLabel("Student Project", SwingConstants.CENTER);
        title.setBounds(30, 20, 400, 40);
        title.setFont(new Font("Georgia", Font.BOLD, 28));
        add(title);

        lReg = new JLabel("Reg No:");
        lReg.setBounds(40, 90, 120, 25);
        add(lReg);

        tReg = new JTextField();
        tReg.setBounds(170, 90, 230, 28);
        add(tReg);

        lName = new JLabel("Project Name:");
        lName.setBounds(40, 140, 120, 25);
        add(lName);

        tName = new JTextField();
        tName.setBounds(170, 140, 230, 28);
        add(tName);

        bSubmit = new JButton("Submit");
        bSubmit.setBounds(40, 200, 170, 40);
        bSubmit.addActionListener(this);
        add(bSubmit);

        bCancel = new JButton("Cancel");
        bCancel.setBounds(230, 200, 170, 40);
        bCancel.addActionListener(this);
        add(bCancel);

        msg = new JLabel("Fill in both boxes.", SwingConstants.CENTER);
        msg.setBounds(20, 260, 410, 30);
        msg.setFont(new Font("Verdana", Font.BOLD, 14));
        add(msg);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bCancel) {
            dispose();
        }

        if (e.getSource() == bSubmit) {
            String reg = tReg.getText().trim();
            String name = tName.getText().trim();

            if (reg.length() == 0 && name.length() == 0) {
                msg.setForeground(Color.RED);
                msg.setText("Both boxes are empty.");
            } else if (reg.length() == 0) {
                msg.setForeground(Color.RED);
                msg.setText("Please enter your Reg No.");
            } else if (name.length() == 0) {
                msg.setForeground(Color.RED);
                msg.setText("Please enter the Project Name.");
            } else {
                msg.setForeground(new Color(20, 110, 60));
                msg.setText("Submitted: " + name + " (" + reg + ")");
            }
        }
    }

    public static void main(String[] args) {
        new ProjectForm();
    }
}