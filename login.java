package bank.management.system;

import javax.swing.*; //jframe ki vajah s ye pacakge aya
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    //actionlistner ki vajah s buttons ko se kr sakte hai
    JLabel label1,label2,label3;//global constructor jis s hum isko class k bahar b use krle andr for img bahar for buttons
    JTextField textField2;
    JPasswordField passwordield3;

    JButton button1, button2 , button3;
    login(){
        super("Bank Management System");//ye frame k top me title ayega super hamesha upar raheta hai
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);

        setLayout(null);//hum khudh s set krenge
        add(image);

        //now lets add card image
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image i20 = i10.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i30 = new ImageIcon(i20);
        JLabel iimage = new JLabel(i30);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325,190,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordield3 = new JPasswordField(15);
        passwordield3.setBounds(325,250,230,30);
        passwordield3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordield3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this); //for cicking button s kuch ho action perform
        add(button3);


        //now lets add background img
        ImageIcon i100 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image i200 = i100.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon i300 = new ImageIcon(i200);
        JLabel iiimage = new JLabel(i300);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setSize(850,480);//frame ka size
        setLocation(450,200);//iski vajah s frame centre s hoga
        setUndecorated(true);
        setVisible(true);//iski vajah s humko frame dikhega lekin corner me ayega lets correct that
        //jo b humko visible krvana hai vo set visible k upar rahega varna dikehga ni

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){
                con c = new con();
                String cardno = textField2.getText();
                String pin = passwordield3.getText();
                String q = "select * from login where card_no='" + cardno + "' and pin='" + pin + "'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new main_class(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }



            }
            else if(e.getSource()==button2){
                textField2.setText("");
                passwordield3.setText("");
            }
            else if(e.getSource()==button3){
                new signup();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new login(); //object
    }
}
