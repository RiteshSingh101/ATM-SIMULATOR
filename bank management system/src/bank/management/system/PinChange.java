package bank.management.system;

import javax.swing.*; // JFrame
import java.awt.*; // image class
import java.awt.event.*; // ActionListener

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,850);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN: ");
        text.setBounds(230,270,700, 35);
        text.setForeground(Color.WHITE); // text color change
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin: ");
        pintext.setBounds(160,300,700, 35);
        pintext.setForeground(Color.WHITE); // text color change
        pintext.setFont(new Font("System", Font.BOLD,16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(305,305,180,25);
        image.add(pin);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(305,355,180,25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(160,400,140,25);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(320,400,140,25);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        JLabel repintext = new JLabel("Re-Enter New Pin: ");
        repintext.setBounds(160,350,700,35);
        repintext.setForeground(Color.WHITE); // text color change
        repintext.setFont(new Font("System", Font.BOLD,16));
        image.add(repintext); 
        
        
        
        
        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);// this will hide the max min close bar
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){   
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered Pin Does not Match!");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the pin!");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new pin!");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Succesfully!");
            setVisible(false);
            new Transaction(rpin).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}

