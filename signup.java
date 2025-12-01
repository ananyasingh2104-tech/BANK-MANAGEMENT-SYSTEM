package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup extends JFrame implements ActionListener {
    JRadioButton r1,r2;
    JButton next;
    JTextField textName, textFname, textEmail,textMs,textad,textCity,textPinc,textS;

    JDateChooser dateChooser;

    Random rand = new Random();
    long first4 = (rand.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    signup(){
        super("APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330,70,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290,90,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(100,190,100,30);
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,190,400,30);
        add(textName);

        JLabel labelfName = new JLabel("Father's Name:");
        labelfName.setBounds(100,240,200,30);
        labelfName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelfName);

        textFname = new JTextField( );
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,240,400,30);
        add(textFname);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setBounds(100,340,200,30);
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        add(DOB);

        //ab calender lana hai we need to use a class JDateChooser
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender:");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,290,200,30);
        add(labelG);
        //yaha humko iske samne radio button lana hai
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBounds(300,290,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBounds(450,290,90,30);
        add(r2);

        //lets use button group jis s hum at a time sirf ek hi button either male or female ko select kr paye
        ButtonGroup buttonGrp = new ButtonGroup();
        buttonGrp.add(r1);
        buttonGrp.add(r2);

        JLabel labelEmail = new JLabel("Email address:");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,390,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Married Status:");
        labelMs.setFont(new Font("Raleway",Font.BOLD,20));
        labelMs.setBounds(100,440,200,30);
        add(labelMs);

        textMs = new JTextField();
        textMs.setFont(new Font("Raleway",Font.BOLD,14));
        textMs.setBounds(300,440,400,30);
        add(textMs);

        JLabel labelad = new JLabel("Address:");
        labelad.setFont(new Font("Raleway",Font.BOLD,20));
        labelad.setBounds(100,490,200,30);
        add(labelad);

        textad = new JTextField();
        textad.setFont(new Font("Raleway",Font.BOLD,14));
        textad.setBounds(300,490,400,30);
        add(textad);

        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway",Font.BOLD,20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway",Font.BOLD,14));
        textCity.setBounds(300,540,400,30);
        add(textCity);

        JLabel labelPinc = new JLabel("Pin Code:");
        labelPinc.setFont(new Font("Raleway",Font.BOLD,20));
        labelPinc.setBounds(100,590,200,30);
        add(labelPinc);

        textPinc = new JTextField();
        textPinc.setFont(new Font("Raleway",Font.BOLD,14));
        textPinc.setBounds(300,590,400,30);
        add(textPinc);

        JLabel labelState = new JLabel("State:");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,640,200,30);
        add(labelState);

        textS = new JTextField();
        textS.setFont(new Font("Raleway",Font.BOLD,14));
        textS.setBounds(300,640,400,30);
        add(textS);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,710,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222,225,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String formno = first;
         String name = textName.getText();
         String fname = textFname.getText();
         String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if(r1.isSelected()){
             gender = "Male";
         }
         else if(r2.isSelected()){
             gender = "Female";
         }
         String email = textEmail.getText();
         String martial = null;
         String address = textad.getText();
         String city = textCity.getText();
         String pincode = textPinc.getText();
         String state = textS.getText();

         try{
             if(textName.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"Fill all the fields");
             }
             else{
                 con con1 = new con();
                 String q = "insert into singup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                 con1.statement.executeUpdate(q);
                 new signup2(formno);
                 setVisible(false);
             }
         }
         catch(Exception E){
             E.printStackTrace();
         }

    }

    public static void main(String[] args){
        new signup();
    }
}

