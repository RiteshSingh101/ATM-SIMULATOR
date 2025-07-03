package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);// due to this setbound will work
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);// beoz we cannot place image direclty on jframe
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,850);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,300,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(335,460,150,28);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(335,492,150,28);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850,850);
        setLocation(300, 0);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == withdraw){
        String number = amount.getText();
        Date date = new Date();
        
        if (number.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
        } else {
            try {
                Conn conn = new Conn();
                int balance = 0;

                // 1. Calculate current balance
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                int withdrawalAmount = Integer.parseInt(number);

                // 2. Check if balance is sufficient
                if (balance < withdrawalAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {
                    // 3. Proceed with withdrawal
                    String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs: "+number+" Withdrawn Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }

            } catch(Exception e){
                System.out.println("Issue: "+e);
            }
        }
    } else if (ae.getSource() == back){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}

    /*
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
               try {
                    Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs: "+number+" Withdraw Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
               } catch(Exception e){
                   System.out.println("Issue: "+e);
               }
                
            }
        } else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
*/
    public static void main(String args[]){
        new Withdrawl("");
    }
}
