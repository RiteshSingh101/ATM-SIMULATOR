package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno){
       
       this.formno = formno;
       setLayout(null);
        
       JLabel l1 = new JLabel("Page 3: Account Details:");
       l1.setFont(new Font("Raleway",Font.BOLD,22));
       l1.setBounds(280, 30, 400,40);
       add(l1);
       
       JLabel type = new JLabel("Account Type:");
       type.setFont(new Font("Raleway",Font.BOLD,22));
       type.setBounds(100, 100, 200,30);
       add(type);
       
       r1 = new JRadioButton("Saving Account");
       r1.setFont(new Font("Raleway",Font.BOLD,16));
       r1.setBackground(Color.WHITE);
       r1.setBounds(100, 150, 150, 20);
       add(r1);
       
       r2 = new JRadioButton("Fixed Deposit Account");
       r2.setFont(new Font("Raleway",Font.BOLD,16));
       r2.setBackground(Color.WHITE);
       r2.setBounds(350, 150, 250, 20);
       add(r2);
       
       r3 = new JRadioButton("Current Account");
       r3.setFont(new Font("Raleway",Font.BOLD,16));
       r3.setBackground(Color.WHITE);
       r3.setBounds(100, 200, 150, 20);
       add(r3);
       
       r4 = new JRadioButton("Recurring Deposit Account");
       r4.setFont(new Font("Raleway",Font.BOLD,16));
       r4.setBackground(Color.WHITE);
       r4.setBounds(350, 200, 250, 20);
       add(r4);
       
       ButtonGroup groupaccount = new ButtonGroup();
       groupaccount.add(r1);
       groupaccount.add(r2);
       groupaccount.add(r3);
       groupaccount.add(r4);
       
       
       JLabel cardno = new JLabel("Card Number:");
       cardno.setFont(new Font("Raleway",Font.BOLD,22));
       cardno.setBounds(100, 250, 200,30);
       add(cardno);
       
       JLabel number = new JLabel("XXXX-XXXX-XXXX-4152");
       number.setFont(new Font("Raleway",Font.BOLD,22));
       number.setBounds(330, 250, 300,30);
       add(number);
       
       JLabel carddetails = new JLabel("(Your 16 Digit Card Number)");
       carddetails.setFont(new Font("Raleway",Font.BOLD,12));
       carddetails.setBounds(100, 280, 300,20);
       add(carddetails);
       
       JLabel pindetail = new JLabel("(Your 4 Digit Password:)");
       pindetail.setFont(new Font("Raleway",Font.BOLD,12));
       pindetail.setBounds(100, 360, 300,20);
       add(pindetail);
       
       JLabel pin = new JLabel("PIN:");
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(100, 330, 200,30);
       add(pin);
       
       JLabel services = new JLabel("Services Required:");
       services.setFont(new Font("Raleway",Font.BOLD,22));
       services.setBounds(100, 420, 200,30);
       add(services);
       
       JLabel pinno = new JLabel("XXXX");
       pinno.setFont(new Font("Raleway",Font.BOLD,22));
       pinno.setBounds(330, 330, 300,30);
       add(pinno);
       
       
       c1 = new JCheckBox("ATM CARD");
       c1.setBackground(Color.WHITE);
       c1.setFont(new Font("Raleway",Font.BOLD,16));
       c1.setBounds(100,480,200,30);
       add(c1);
      
       c2 = new JCheckBox("Mobile Banking");
       c2.setBackground(Color.WHITE);
       c2.setFont(new Font("Raleway",Font.BOLD,16));
       c2.setBounds(100,530,200,30);
       add(c2);
       
       c3 = new JCheckBox("Cheque Book");
       c3.setBackground(Color.WHITE);
       c3.setFont(new Font("Raleway",Font.BOLD,16));
       c3.setBounds(100,580,200,30);
       add(c3);
       
       c4 = new JCheckBox("Internet Banking");
       c4.setBackground(Color.WHITE);
       c4.setFont(new Font("Raleway",Font.BOLD,16));
       c4.setBounds(350,480,200,30);
       add(c4);
       
       
       c5 = new JCheckBox("EMAIL Alerts");
       c5.setBackground(Color.WHITE);
       c5.setFont(new Font("Raleway",Font.BOLD,16));
       c5.setBounds(350,530,200,30);
       add(c5);
       
       
       c6 = new JCheckBox("E-Statement");
       c6.setBackground(Color.WHITE);
       c6.setFont(new Font("Raleway",Font.BOLD,16));
       c6.setBounds(350,580,200,30);
       add(c6);
       
       
       c7 = new JCheckBox("I Here By Declares that the above entered details are correct to the best of my knowlege");
       c7.setBackground(Color.WHITE);
       c7.setFont(new Font("Raleway",Font.BOLD,12));
       c7.setBounds(140,630,600,30);
       add(c7);
       
       submit = new JButton("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("Raleway",Font.BOLD, 14));
       submit.setBounds(250,680,100,30);
       submit.addActionListener(this);
       add(submit);
 
       cancel = new JButton("Cancel");
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.setFont(new Font("Raleway",Font.BOLD, 14));
       cancel.setBounds(420,680,100,30);
       cancel.addActionListener(this);
       add(cancel);
       
       getContentPane().setBackground(Color.WHITE);
       setSize(850,820);
       setLocation(350,0);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if  (r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = "" +  Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = ""  + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card"; 
            } else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            } else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            } else if(c4.isSelected()){
                facility = facility + " Email & SMS Alerts";
            } else if (c5.isSelected()){
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()){
                facility = facility + " E-Statment";
            }
            
            try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account Type is Required");
               } else {
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree(formno, accountType, cardnumber, pinnumber, facility) " +
                "values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";

                 String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                 conn.s.executeUpdate(query1);
                 conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: "+pinnumber);
                   
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(false);
              
               }
            } catch(Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}
