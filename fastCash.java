package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    fastCash(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(440, 180, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 24));
        l3.add(label);

        b1 = createButton("Rs. 100", 410, 274, l3);
        b2 = createButton("Rs. 500", 700, 274, l3);
        b3 = createButton("Rs. 1,000", 410, 318, l3);
        b4 = createButton("Rs. 2,000", 700, 318, l3);
        b5 = createButton("Rs. 5,000", 410, 362, l3);
        b6 = createButton("Rs. 10,000", 700, 362, l3);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(700, 406, 150, 35);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    // Reusable button generator
    private JButton createButton(String text, int x, int y, JLabel container) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(65, 125, 128));
        btn.setBounds(x, y, 150, 35);
        btn.addActionListener(this);
        container.add(btn);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Back button
        if (e.getSource() == b7) {
            setVisible(false);
            new main_class(pin);
            return;
        }

        // Extract amount correctly
        String text = ((JButton) e.getSource()).getText();   // Example: "Rs. 1,000"
        String amountString = text.split(" ")[1].replace(",", ""); // → "1000"
        int withdrawAmount = Integer.parseInt(amountString);

        con c = new con();
        Date date = new Date();

        try {

            // STEP 1: Get total balance
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                int amt = Integer.parseInt(resultSet.getString("amount"));

                if (type.equals("Deposit")) {
                    balance += amt;
                } else {
                    balance -= amt;
                }
            }

            // STEP 2: Check sufficient balance
            if (balance < withdrawAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // STEP 3: Deduct and record transaction
            c.statement.executeUpdate(
                    "INSERT INTO bank VALUES('" + pin + "', '" + date + "', 'Withdrawal', '" + withdrawAmount + "')"
            );

            JOptionPane.showMessageDialog(null,
                    "Rs. " + withdrawAmount + " Debited Successfully");

            setVisible(false);
            new main_class(pin);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new fastCash("");
    }
}


