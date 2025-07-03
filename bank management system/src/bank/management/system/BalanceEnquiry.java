package bank.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
 
public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    BalanceEnquiry(String  pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,850);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(340,460,140,25);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
            try {
                // ResultSet found in sql package
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        // balance is integer and amount is string so
                        // we use Intger.parse to convert String to Integer
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                       balance -= Integer.parseInt(rs.getString("amount")); 
                    }
                }
                
            } catch(Exception e){
                System.out.println(e);
            }
          
          JLabel text = new JLabel("Your Current Account Balance Is Rs "+ balance);
          text.setForeground(Color.WHITE);
          text.setBounds(170,300,400,30);
          image.add(text);
          
           
        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);// this will hide the max min close bar
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
