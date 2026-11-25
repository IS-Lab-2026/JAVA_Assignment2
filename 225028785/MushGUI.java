import javax.swing.*;
import java.awt.*;

public class MushGUI{
       JFrame WelcomeGUI,MushFr,BRC;
       JLabel welclabel,label,label1,label2,label3,output;
       JButton Mush,Byc,back,Yes,No,backBRC,check;
       JTextField StartingTime,EndingTime;
       JTextArea Out,OutBRC;


public MushGUI(){
    
    WelcomeGUI = new JFrame();
    WelcomeGUI.setLayout(null);
    welclabel = new JLabel("Welcome to Mushroom Identification System and Bycycle Rental System");
    welclabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 20));
    welclabel.setBounds(150, 200, 900, 60);
    WelcomeGUI.add(welclabel);
    Mush = new JButton("Mush IS");
    Mush.setBounds(200, 400, 200, 50);
    Byc = new JButton("Byc RS");
    Byc.setBounds(600, 400, 200, 50);
    WelcomeGUI.add(Mush);
    WelcomeGUI.add(Byc);
    WelcomeGUI.setSize(1000,600);  
    WelcomeGUI.setLocationRelativeTo(null);
    WelcomeGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    WelcomeGUI.setUndecorated(true);
    WelcomeGUI.setVisible(false);
    Mush();
    BRC();  
   

}

public void Mush(){
    
     
        MushFr =new JFrame("Mushroom Identification System");
        label = new JLabel("Mushroom Identification System");
        label.setFont(new Font("verdana",Font.PLAIN,25));
        label.setBounds(250,20, 600,40);
        MushFr.add(label);
        back = new JButton("back");
        back.setBounds(700, 20, 100, 40);
        MushFr.add(back);
        Out = new JTextArea();
        Out.setBounds(150, 100, 600, 300);
        MushFr.add(Out);
        Yes = new JButton("Yes");
        Yes.setBounds(200, 500, 200, 50);
        No = new JButton("No");
        No.setBounds(500, 500, 200, 50);
        MushFr.add(Yes);
        MushFr.add(No);
        MushFr.setLayout(null);
        MushFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MushFr.setSize(900,800);
        MushFr.setLocationRelativeTo(null);
        MushFr.setVisible(false);

    
}
public void BRC(){ 

        BRC =new JFrame("Bicycle Rental System");
        label1 = new JLabel("Bicycle Rental System");
        label1.setFont(new Font("verdana",Font.PLAIN,25));
        label1.setBounds(300,20, 600,40);
        BRC.add(label1);
        backBRC = new JButton("back");
        backBRC.setBounds(700, 20, 100, 40);
        BRC.add(backBRC);
        label2 = new JLabel("Starting Time (0-23)");
        label2.setFont(new Font("verdana",Font.PLAIN,17));
        label2.setBounds(160, 150, 200, 40);
        BRC.add(label2);
        StartingTime = new JTextField();
        StartingTime.setBounds(150, 200, 200, 40);
        label3 = new JLabel("Ending Time (1-24)");
        label3.setFont(new Font("verdana",Font.PLAIN,17));
        label3.setBounds(560, 150, 200, 40);
        BRC.add(label3);
        EndingTime = new JTextField();
        EndingTime.setBounds(550, 200, 200, 40);
        BRC.add(StartingTime);
        BRC.add(EndingTime);
        output = new JLabel("Total Cost");
        output.setFont(new Font("verdana",Font.PLAIN,17));
        output.setBounds(400, 270, 200, 40);
        BRC.add(output);
        OutBRC = new JTextArea();
        OutBRC.setBounds(350, 310, 200, 40);
        BRC.add(OutBRC);
        check = new JButton("Check");
        check.setBounds(300, 450, 300, 50);
        BRC.add(check);
        BRC.setLayout(null);
        BRC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BRC.setSize(900,800);
        BRC.setLocationRelativeTo(null);
        BRC.setVisible(false);
    
}}