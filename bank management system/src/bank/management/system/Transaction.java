package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balanceenquriy, exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,850);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(180,270,700, 35);
        text.setForeground(Color.WHITE); // text color change
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(155,392,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(330,392,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(155,425,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        balanceenquriy = new JButton("Balance Enquiry");
        balanceenquriy.setBounds(330,458,150,30);
        balanceenquriy.addActionListener(this);
        image.add(balanceenquriy);
        
        exit = new JButton("Exit");
        exit.setBounds(330,490,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
         
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(330,425,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(155,458,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        setSize(850,850);
        setLocation(300,0);
        setUndecorated(true);// this will hide the max min close bar
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource()== balanceenquriy){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transaction("");
    }
}
