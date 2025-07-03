package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);// due to this setbound will work
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);// beoz we cannot place image direclty on jframe
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,850);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,300,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(335,460,150,28);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(335,492,150,28);
        back.addActionListener(this);
        image.add(back);
        
        setSize(850,850);
        setLocation(300, 0);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
               try {
                    Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs: "+number+" Deposited Successfully");
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
    public static void main(String args[]){
        new Deposit("");
    }
}
