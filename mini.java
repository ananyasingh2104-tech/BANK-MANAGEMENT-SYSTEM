package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    mini(String pin){
        this.pin = pin;

        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,300);
        add(label1);

        JLabel label2 = new JLabel("Ananya Singh");
        label2.setFont(new Font("System",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);


        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM login WHERE pin = '"+pin+"'");

            if(resultSet.next()){
                String card = resultSet.getString("card_no");
                label3.setText("Card Number: " + card.substring(0,4) + "XXXXXXXX" + card.substring(12));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


        try{
            int balance = 0;
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");

            String statement = "<html>";

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                int amount = Integer.parseInt(resultSet.getString("amount"));

                statement += date + "&nbsp;&nbsp;" + type + "&nbsp;&nbsp;" + amount + "<br>";

                if (type.equals("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            statement += "</html>";
            label1.setText(statement);
            label4.setText("Your total Balance is Rs " + balance);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args){
        new mini("");   // pass pin here
    }
}
